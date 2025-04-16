import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { klient } from '../klasy/klient';

@Injectable({ providedIn: 'root' })
export class KlientService {
  constructor(private http: HttpClient) {}

  saveUser(user:klient) {
    const response = this.http.post('http://localhost:8080/api/users', user);
    return response
  }
}
