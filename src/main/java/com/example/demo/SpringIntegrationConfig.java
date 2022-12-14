package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
public class SpringIntegrationConfig {

    @Bean
    public IntegrationFlow integrationFlow(){
        System.out.println("integrationFlow");
        return IntegrationFlow.from(fileReader(),
                        x-> x.poller(Pollers.fixedDelay(500)))
                .handle(fileWriter())
                .get();
    }

    @Bean
    public FileReadingMessageSource fileReader(){
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File("source"));
        return source;
    }

    @Bean
    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("target"));
        handler.setExpectReply(false);
        return handler;
    }

}
