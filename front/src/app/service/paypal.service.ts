import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaypalDTO } from '../klasy/paypal-dto';


@Injectable({
  providedIn: 'root'
})
export class PaypalService {
  private payUrl = 'http://localhost:8080/pay';
  constructor(private http: HttpClient) { }
  makePayment(order: PaypalDTO): Observable<any> {
    console.log(order.total)
    return this.http.post(this.payUrl, order);
  }
}
export { PaypalDTO };

