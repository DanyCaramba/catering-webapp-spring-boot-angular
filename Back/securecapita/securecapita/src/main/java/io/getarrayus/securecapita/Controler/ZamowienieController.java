package io.getarrayus.securecapita.Controler;

import io.getarrayus.securecapita.DTO.ZamowienieWystawDTO;
import io.getarrayus.securecapita.Repositories.ZamowienieRepository;
import io.getarrayus.securecapita.Serwis.KlientSerwis;
import io.getarrayus.securecapita.Serwis.ZamowienieSerwis;
import io.getarrayus.securecapita.tabele.Dieta;
import io.getarrayus.securecapita.tabele.Klient;
import io.getarrayus.securecapita.tabele.Zamowienie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/zamowienie")
public class ZamowienieController {
    private final ZamowienieSerwis zamowienieService;
    public ZamowienieController(ZamowienieSerwis zamowienieService) {
        this.zamowienieService = zamowienieService;
    }
    @PostMapping("/zapis")
    ResponseEntity<Long> addzamowienie(@RequestBody Zamowienie zamowienie){
        Zamowienie savedZamowienie = zamowienieService.saveZamowienie(zamowienie);
        return ResponseEntity.ok(savedZamowienie.getZamowienie_id());

    }
    @GetMapping("/odczyt")
    public ResponseEntity<List<ZamowienieWystawDTO>> zamowienies(@RequestParam String username) {
        List<ZamowienieWystawDTO> zamowienia = zamowienieService.getZamowieniaByUser(username);
        return ResponseEntity.ok(zamowienia);

    }




}
