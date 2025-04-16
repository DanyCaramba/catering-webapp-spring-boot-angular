import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ZamowienieDieta } from '../klasy/zamowienie-dieta';


@Injectable({
  providedIn: 'root'
})
export class ZamowienieDietaService {
  constructor(private http: HttpClient) {}
  saveZamowienie(zamowieniedieta:ZamowienieDieta) {
    const response = this.http.post('http://localhost:8080/calosc2/d',zamowieniedieta);
    return response
  }
}
