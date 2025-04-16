package io.getarrayus.securecapita;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KlientNotFoundException extends RuntimeException {

    private  static final long serialVersionUID = 1L;

    public KlientNotFoundException(String message){
        super(message);

    }

}
