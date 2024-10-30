package api.utfpr.projeto2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import api.utfpr.projeto2.models.Message;
import api.utfpr.projeto2.services.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message createMessage(@RequestParam("file") MultipartFile file){
        return this.messageService.createMessage(file);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return this.messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getMessage(@PathVariable Integer id){
        Resource file = this.messageService.getMessage(id);

        if(file == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
        return this.messageService.updateMessage(id, file);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Integer id){
        this.messageService.deleteMessage(id);
    }
}
