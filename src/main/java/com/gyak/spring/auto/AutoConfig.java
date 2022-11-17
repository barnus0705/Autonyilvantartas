package com.gyak.spring.auto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AutoConfig {

    @Bean
    CommandLineRunner commandLineRunner(AutoRepository repository){
        return args -> {
            Auto opi = new Auto(1,"123-GNC",AutoMarka.Opel, LocalDate.of(2000, Month.AUGUST,23),12345);
            Auto bmw = new Auto(2,"333-GBL",AutoMarka.Bmw, LocalDate.of(2005, Month.APRIL,13),222);
            repository.saveAll(List.of(opi,bmw));
        };

    }
}
