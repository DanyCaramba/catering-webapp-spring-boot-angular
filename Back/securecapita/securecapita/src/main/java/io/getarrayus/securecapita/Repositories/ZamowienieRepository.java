package io.getarrayus.securecapita.Repositories;

import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Klient;
import io.getarrayus.securecapita.tabele.Zamowienie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie,Long>{

    @Override
    Zamowienie save(Zamowienie zamowienie);

    List<Zamowienie> findByUsername(String username);

    @Override
    List<Zamowienie> findAll( Sort sort);
}
