package io.getarrayus.securecapita.Repositories;

import io.getarrayus.securecapita.tabele.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietaRepository extends JpaRepository<Dieta,Long> {

    List<Dieta> findAllById(int i);
}
