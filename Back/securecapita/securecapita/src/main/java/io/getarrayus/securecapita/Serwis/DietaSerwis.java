package io.getarrayus.securecapita.Serwis;

import io.getarrayus.securecapita.DTO.ZamowienieDietaDTO;
import io.getarrayus.securecapita.Repositories.DietaRepository;
import io.getarrayus.securecapita.Repositories.ZamowienieDietaRepository;
import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.ZamowienieDieta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DietaSerwis {




    private final DietaRepository dietaRepository ;

    public DietaSerwis(DietaRepository dietaRepository) {
        this.dietaRepository = dietaRepository;
    }


}
