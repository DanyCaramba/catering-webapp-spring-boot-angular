package io.getarrayus.securecapita.Controler;

import io.getarrayus.securecapita.tabele.Dieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.getarrayus.securecapita.Repositories.DietaRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/diety")
public class DietaController {


    @Autowired
    private DietaRepository dietaRepository;
    @GetMapping("/all")
    public List<Dieta> getAllklient2(){return dietaRepository.findAll();}
}
