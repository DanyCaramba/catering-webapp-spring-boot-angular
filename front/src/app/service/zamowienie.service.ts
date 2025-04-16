import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Zamowienie } from '../klasy/zamowienie';

@Injectable({
  providedIn: 'root'
})
export class ZamowienieService {
  constructor(private http: HttpClient) {}
  saveZamowienie(zamowienie:Zamowienie) {
    const response = this.http.post('http://localhost:8080/zamowienie/zapis',zamowienie);
    return response
  }
}
