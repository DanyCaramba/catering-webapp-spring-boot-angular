import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dieta } from '../klasy/dieta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class DietaService {

  x:Number=1;
  
  private baseURL = "http://localhost:8080/diety/all";
  constructor(private httpClient: HttpClient) { }
  

  getDietaList(): Observable<Dieta[]> {
    return this.httpClient.get<Dieta[]>(`${this.baseURL}`);
  }

}
