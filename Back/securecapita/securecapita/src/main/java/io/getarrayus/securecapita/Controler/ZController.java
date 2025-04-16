package io.getarrayus.securecapita.Controler;

import io.getarrayus.securecapita.DTO.ZamowienieDTO;
import io.getarrayus.securecapita.Serwis.ZamowienieDietaSerwis;
import io.getarrayus.securecapita.tabele.ZamowienieDieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calosc2")
@CrossOrigin(origins = "http://localhost:4200")
public class ZController {

    @Autowired
    private ZamowienieDietaSerwis zamowienieDietaSerwis;

    @PostMapping("/d")
    public ZamowienieDieta przyjmijZamowienie(@RequestBody ZamowienieDTO zamowienie) {
        return zamowienieDietaSerwis.zapisz(zamowienie);
    }
}
