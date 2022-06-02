package ru.kpfu.peloton.pelotonproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Webinar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String coachName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String link;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_WEBINAR",
            joinColumns = {@JoinColumn(name = "webinar_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")})
    private List<User> users = new ArrayList<>();
}
