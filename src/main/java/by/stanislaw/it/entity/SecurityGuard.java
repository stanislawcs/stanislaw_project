package by.stanislaw.it.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.DoubleSummaryStatistics;


@Entity
@Getter
public class SecurityGuard {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    private String passportNumber;
    @Setter
    private String password;
    @Setter
    private String repassword;
    @Setter
    private String name;
    @Setter
    private String role;
    @Setter
    private String pathToGuardImage;
    @Setter
    private Double rating;
}
