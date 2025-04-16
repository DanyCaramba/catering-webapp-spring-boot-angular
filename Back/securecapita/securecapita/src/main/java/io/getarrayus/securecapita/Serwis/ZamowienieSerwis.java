package io.getarrayus.securecapita.Serwis;

import io.getarrayus.securecapita.DTO.ZamowienieWystawDTO;
import io.getarrayus.securecapita.Repositories.ZamowienieRepository;
import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Zamowienie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZamowienieSerwis {

    private final ZamowienieRepository zamowienieRepository;

    public ZamowienieSerwis(ZamowienieRepository zamowienieRepository) {
        this.zamowienieRepository = zamowienieRepository;
    }

    public Zamowienie saveZamowienie(Zamowienie zamowienie) {

        return zamowienieRepository.save(zamowienie);
    }

    public Zamowienie findById(long id) {
        Optional<Zamowienie> zamowienie = zamowienieRepository.findById(id);

        return zamowienie.orElse(null);
    }

    public List<ZamowienieWystawDTO> al() {
        return zamowienieRepository.findAll().stream().map(ZamowienieWystawDTO::new).collect(Collectors.toList());
    }

    public List<ZamowienieWystawDTO> getZamowieniaByUser(String username) {
        return zamowienieRepository.findByUsername(username).stream()
                .map(ZamowienieWystawDTO::new)
                .collect(Collectors.toList());
    }

}
