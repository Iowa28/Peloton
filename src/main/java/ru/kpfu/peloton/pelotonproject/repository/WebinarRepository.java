package ru.kpfu.peloton.pelotonproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.peloton.pelotonproject.model.Webinar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WebinarRepository extends JpaRepository<Webinar, Long> {

    List<Webinar> findAllByEndDateBefore(LocalDateTime time);

    List<Webinar> findAllByEndDateAfter(LocalDateTime time);

    Optional<Webinar> findByName(String name);

}
