package org.example.cardb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(CarRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Car(null, "Toyota", "Camry", "Black", "123ABC", 2020, 20000));
                repo.save(new Car(null, "BMW", "X5", "White", "987XYZ", 2021, 45000));
                repo.save(new Car(null, "Honda", "Civic", "Blue", "556TTT", 2018, 15000));
            }
        };
    }
}
