package org.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Order(1)
    @Bean
    public CommandLineRunner beanCommandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Order(2)
    @Bean
    public CommandLineRunner testMongodbCommandLineRunner() {
        return args -> {
            System.out.println("Let's do some testing in our Mongo database:");

            // fetch all users
            System.out.println("Users found with findAll();");
            System.out.println("-------------------------");
            for (User user : userRepository.findAll()) {
                System.out.println(user);
            }
            System.out.println("-------------------------");

            // fetch an individual user
            System.out.println("User found with findByUser('user1@sample.io');");
            System.out.println("-------------------------");
            System.out.println(userRepository.findByUser("user1@sample.io"));
            System.out.println("-------------------------");

            System.out.println("User found with findByWorkstation('192.168.1.11');");
            System.out.println("-------------------------");
            System.out.println(userRepository.findByWorkstation("192.168.1.11"));
            System.out.println("-------------------------");

            // fetch all events
            System.out.println("Events found with findAll();");
            System.out.println("-------------------------");
            for (Event event : eventRepository.findAll()) {
                System.out.println(event);
            }

            // fetch individual events
            System.out.println("-------------------------");
            System.out.println("Events found with findByType('LOGIN');");
            System.out.println("-------------------------");
            for (Event event : eventRepository.findByType("LOGIN")) {
                System.out.println(event);
            }
            System.out.println("-------------------------");
        };

    }

}