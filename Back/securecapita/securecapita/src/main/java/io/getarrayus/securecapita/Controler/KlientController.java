package io.getarrayus.securecapita.Controler;

import io.getarrayus.securecapita.Serwis.KlientSerwis;
import io.getarrayus.securecapita.tabele.Klient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class KlientController {

    private final KlientSerwis klientService;
    public KlientController(KlientSerwis klientService) {
        this.klientService = klientService;
    }
    @PostMapping()
    ResponseEntity<Klient> addKlient(@RequestBody Klient klient){
       return ResponseEntity.ok(klientService.saveUser(klient)) ;
    }

}
