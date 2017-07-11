package com.sabinay.config;

import com.sabinay.filestorage.StorageProperties;
import com.sabinay.filestorage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppConfig {
	public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
}
