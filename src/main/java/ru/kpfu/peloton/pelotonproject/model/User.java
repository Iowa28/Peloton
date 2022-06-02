package ru.kpfu.peloton.pelotonproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;


    @ManyToMany(mappedBy = "users")
    private List<Webinar> webinars = new ArrayList<>();
    @OneToOne
    private UserInfo userInfo;
    @OneToOne
    private UserCharacteristics userCharacteristics;
}
