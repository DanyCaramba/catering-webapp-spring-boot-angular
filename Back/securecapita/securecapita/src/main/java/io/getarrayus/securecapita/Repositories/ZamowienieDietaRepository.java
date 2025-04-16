package io.getarrayus.securecapita.Repositories;

import io.getarrayus.securecapita.tabele.Zamowienie;
import io.getarrayus.securecapita.tabele.ZamowienieDieta;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZamowienieDietaRepository extends JpaRepository<ZamowienieDieta,Long> {
    @Override
    ZamowienieDieta save(ZamowienieDieta zamowieniedieta);

    @Override
    List<ZamowienieDieta> findAll();


}
