import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KoszykItem } from '../service/koszyk.service';
import { HistoriaService } from '../service/historia.service';
import {Order} from '../service/historia.service';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-logowanie',
  templateUrl: './logowanie.component.html',
  styleUrls: ['./logowanie.component.css']
})


export class LogowanieComponent implements OnInit {
  user = '';
  order: Order[] = [];

  constructor(
    private keycloakService: KeycloakService,
    private historiaService: HistoriaService
  ) {}

  ngOnInit(): void {
    this.initializeUserOptions();
  }

  private async initializeUserOptions(): Promise<void> {
    if (await this.keycloakService.isLoggedIn()) {
      this.user = this.keycloakService.getUsername();
      this.historiaService.getDietaList(this.user).subscribe(data => {
        this.order = data;
      }, error => {
        console.error('Błąd podczas pobierania danych:', error);
      });
    }
  }
}


