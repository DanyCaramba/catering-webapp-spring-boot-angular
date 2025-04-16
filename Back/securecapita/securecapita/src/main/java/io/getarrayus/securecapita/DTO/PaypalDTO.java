package io.getarrayus.securecapita.DTO;

import lombok.Data;
import lombok.Value;

@Data
public class PaypalDTO {


        Double total;
        String currency;
        String method;
        String intent;


    public Double getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public String getIntent() {
        return intent;
    }

    public String getMethod() {
        return method;
    }
}
