package com.els.test.config;

import com.els.test.domain.Salaried;
import com.els.test.repository.SalariedRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    private SalariedRepository salariedRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Salaried>> mapType = new TypeReference<List<Salaried>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/static/salarieds.json");
        try {
            List<Salaried> salarieds = mapper.readValue(inputStream, mapType);
            salariedRepository.saveAll(salarieds);
        } catch (IOException e) {
            log.error("Unable to save salarieds from JSON file: " + e.getMessage());
        }
    }
}
