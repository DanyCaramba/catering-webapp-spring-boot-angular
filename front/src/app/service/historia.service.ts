import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Data } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { Observable, from, switchMap } from 'rxjs';

export interface Order {
  zamowienieId: number;
  nazwa: string;
  cenaLaczna: number;
  data:Data;
  zamowienieDietasDTO: Diet[];
}


interface Diet {
  iloscDni: number;
  cenaLaczna: number;
  nazwaDiety: string;
  cena: number;
  zdjmale:String;
}

@Injectable({
  providedIn: 'root'
})
export class HistoriaService {
  private baseURL = "http://localhost:8080/zamowienie/odczyt";

  constructor(
    private httpClient: HttpClient,
    private keycloakService: KeycloakService 
  ) {}

  getDietaList(username: string): Observable<Order[]> {
    return from(this.keycloakService.getToken()).pipe(
      switchMap(token => {
        const headers = new HttpHeaders({
          'Authorization': `Bearer ${token}`
        });
        let params = new HttpParams().set('username', username);
        return this.httpClient.get<Order[]>(this.baseURL, { headers, params });
      })
    );
  }
}
