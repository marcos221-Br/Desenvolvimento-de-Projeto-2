package api.utfpr.projeto2.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import api.utfpr.projeto2.configs.StorageConfig;
import api.utfpr.projeto2.exceptions.AlreadyExistsException;
import api.utfpr.projeto2.exceptions.StorageException;
import api.utfpr.projeto2.exceptions.StorageFileNotFoundException;
import api.utfpr.projeto2.models.Message;
import api.utfpr.projeto2.repositories.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    private final Path rootLocation;

    public MessageService(StorageConfig configs){
        this.rootLocation = Paths.get(configs.getLocation());
    }

    public void createDirectory(){
        try{
            Files.createDirectories(rootLocation);
        }catch(IOException e){
            throw new StorageException("Não foi possível criar o diretório!");
        }
    }

    public Message createMessage(MultipartFile file){
        Message message = new Message();
        @SuppressWarnings("null")
        Path destinationFile = this.rootLocation.resolve(System.currentTimeMillis()+"."+file.getContentType().split("/")[1]).normalize().toAbsolutePath();
        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, destinationFile);
            message.setMessage(destinationFile.getFileName()+"");
            return this.messageRepository.save(message);
        }catch(IOException e) {
            throw new AlreadyExistsException("Messagem duplicada enviada!");
        }
    }

    public Message updateMessage(Integer id, MultipartFile file){
        Message message = this.messageRepository.getReferenceById(id);
        Path destinationFile = this.rootLocation.resolve(message.getMessage()).normalize().toAbsolutePath();
        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            message.setMessage(destinationFile.getFileName()+"");
            return message;
        }catch(IOException e){
            throw new StorageException("Falha ao armazenar Imagem");
        }
    }

    public List<Message> getAllMessages(){
        return this.messageRepository.findAll();
    }

    public Resource getMessage(Integer id){
        try{
            Path file = rootLocation.resolve(this.messageRepository.getReferenceById(id).getMessage());
            Resource resource = new UrlResource(file.toUri());
            return resource;
        }catch(MalformedURLException e){
            throw new StorageFileNotFoundException("Menssagem não encontrada!");
        }
    }

    public void deleteMessage(Integer id){
        File file = new File(rootLocation + "\\" + this.messageRepository.getReferenceById(id).getMessage());
        if(file.delete()){
            this.messageRepository.deleteById(id);
        }
    }
}
