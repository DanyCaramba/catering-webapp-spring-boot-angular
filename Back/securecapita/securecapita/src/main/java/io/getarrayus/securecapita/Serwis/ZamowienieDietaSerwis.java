package io.getarrayus.securecapita.Serwis;

import io.getarrayus.securecapita.DTO.ZamowienieDTO;
import io.getarrayus.securecapita.Repositories.DietaRepository;
import io.getarrayus.securecapita.Repositories.ZamowienieDietaRepository;
import io.getarrayus.securecapita.Repositories.ZamowienieRepository;
import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Zamowienie;
import io.getarrayus.securecapita.tabele.ZamowienieDieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZamowienieDietaSerwis {


    @Autowired
    private ZamowienieRepository zamowienieRepository;

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private ZamowienieDietaRepository zamowienieDietaRepository;

    public ZamowienieDieta zapisz(ZamowienieDTO zamowienieDTO) {
        ZamowienieDieta zamowieniedieta = new ZamowienieDieta();

        Dieta dieta = dietaRepository.findById(zamowienieDTO.getDietaId())
                .orElseThrow(() -> new RuntimeException("Dieta nie znaleziona"));
        Zamowienie zamowienieRef = zamowienieRepository.findById(zamowienieDTO.getZamowienieId())
                .orElseThrow(() -> new RuntimeException
                        ("Zamówienie nie znalezione"));


        zamowieniedieta.setDieta(dieta);
        zamowieniedieta.setZamowienie(zamowienieRef);
        zamowieniedieta.setIloscDni(zamowienieDTO.getIloscDni());
        zamowieniedieta.setCenaLaczna(zamowienieDTO.getCenaLaczna());
        return zamowienieDietaRepository.save(zamowieniedieta);
    }

    public List<ZamowienieDieta> getZamowienieDieta(){

        return zamowienieDietaRepository.findAll();
    }

    public Optional<ZamowienieDieta> getZamowienieDieta2(long x){

        return zamowienieDietaRepository.findById(x);
    }

}
