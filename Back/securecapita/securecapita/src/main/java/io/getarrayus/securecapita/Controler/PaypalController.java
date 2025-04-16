package io.getarrayus.securecapita.Controler;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import io.getarrayus.securecapita.DTO.PaypalDTO;
import io.getarrayus.securecapita.Serwis.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaypalController {

    @Autowired
    PaypalService service;



    @PostMapping(value = "/pay")
    public ResponseEntity<?> payment(@RequestBody PaypalDTO paymentDTO) {

        System.out.println(paymentDTO.getCurrency()+paymentDTO.getTotal()+paymentDTO.getIntent()+paymentDTO.getMethod());
        try {
            Payment payment = service.createPayment(paymentDTO.getTotal(),paymentDTO.getCurrency(),paymentDTO.getMethod()
                    , paymentDTO.getIntent(),"http://localhost:4200","http://localhost:4200/Logowanie");


            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return ResponseEntity.ok("{\"url\": \"" + link.getHref() + "\"}");
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing PayPal payment");
        }
        return ResponseEntity.badRequest().body("Unable to create PayPal payment");
    }

    @GetMapping(value = "/cancel")
    public ResponseEntity<?> cancelPay() {
        return ResponseEntity.ok("Payment canceled");
    }


    @GetMapping("/success")
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            if ("approved".equals(payment.getState())) {
                return ResponseEntity.ok("Payment successful");
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error executing PayPal payment");
        }
        return ResponseEntity.badRequest().body("Payment not successful");
    }


}
