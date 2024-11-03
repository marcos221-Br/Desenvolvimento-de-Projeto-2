package api.utfpr.projeto2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import api.utfpr.projeto2.configs.StorageConfig;
import api.utfpr.projeto2.services.MessageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfig.class)
public class Projeto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto2Application.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
	CommandLineRunner createDirectory(MessageService messageService){
		return (args) -> {
			messageService.createDirectory();
		};
	}

}
