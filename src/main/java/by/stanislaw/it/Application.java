package by.stanislaw.it;

import by.stanislaw.it.enums.RoleEnums;
import by.stanislaw.it.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("by.stanislaw.it.entity")
@EnableJpaRepositories("by.stanislaw.it.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired GuardService guardService) {
        return args -> {
            if (!guardService.getSecurityGuardByPassportNumber("ADMIN").isPresent()) {
                guardService.save("ADMIN", "ADMIN", "ADMIN", RoleEnums.ADMIN.name());
            }
        };
    }
}