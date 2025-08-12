package com.nisc.provisioning;

import com.opencsv.CSVReader;
import com.nisc.provisioning.domain.Customer;
import com.nisc.provisioning.repo.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class DataMigrationConfig {

    private String toE164(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        if (!digits.startsWith("1")) digits = "1" + digits; // US default
        return "+" + digits;
    }

    @Bean
    CommandLineRunner migrate(CustomerRepo repo) {
        return args -> {
            Path csv = Path.of("data/sample/customers.csv");
            if (!Files.exists(csv)) return;
            try (CSVReader reader = new CSVReader(new FileReader(csv.toFile()))) {
                String[] row;
                reader.readNext(); // header
                while ((row = reader.readNext()) != null) {
                    String acct = row[0];
                    String name = row[1];
                    String phone = toE164(row[2]);
                    repo.save(new Customer(acct, name, phone));
                }
            }
        };
    }
}
