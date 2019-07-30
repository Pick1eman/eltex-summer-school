package ru.eltex;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository crudRepository)
    {
        return (args)-> {
            crudRepository.save(new User(0,"Eugene","900"));
            crudRepository.save(new User(1,"Alex","123"));
            for (User user: crudRepository.findAll())
            {
                System.out.println(user.getFio());
            }
        };
    }

    @Bean
    public CommandLineRunner demo2(CallRepository crudRepository)
    {
        return (args)-> {
            crudRepository.save(new Call(1,2));
            crudRepository.save(new Call(2,1));

        };
    }
}