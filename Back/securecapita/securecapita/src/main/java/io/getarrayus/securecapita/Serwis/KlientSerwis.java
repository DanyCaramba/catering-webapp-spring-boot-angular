package io.getarrayus.securecapita.Serwis;

import io.getarrayus.securecapita.Repositories.KlientRepository;
import io.getarrayus.securecapita.tabele.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlientSerwis {

    private final KlientRepository userRepository;

    public KlientSerwis(KlientRepository userRepository) {

        this.userRepository = userRepository;
    }

    public Klient saveUser(Klient user) {

        return userRepository.save(user);
    }
}
