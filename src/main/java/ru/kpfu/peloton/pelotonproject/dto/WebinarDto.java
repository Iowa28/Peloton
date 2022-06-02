package ru.kpfu.peloton.pelotonproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebinarDto {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String link;
    private List<String> users;
    private String coach;
}
