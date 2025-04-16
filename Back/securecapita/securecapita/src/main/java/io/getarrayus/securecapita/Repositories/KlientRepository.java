package io.getarrayus.securecapita.Repositories;

import io.getarrayus.securecapita.tabele.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient,String> {

    @Override
     Klient save(Klient klient);
}
