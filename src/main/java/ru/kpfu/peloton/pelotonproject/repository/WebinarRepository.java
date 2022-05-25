package ru.kpfu.peloton.pelotonproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.peloton.pelotonproject.model.Webinar;

@Repository
public interface WebinarRepository extends JpaRepository<Webinar, Long> {

}
