import { APP_INITIALIZER, NgModule } from '@angular/core';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { DietaComponent } from './dieta/dieta.component';
import { LogowanieComponent } from './logowanie/logowanie.component';
import { KoszykComponent } from './koszyk/koszyk.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { KlasycznyComponent } from './klasyczny/klasyczny.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { StopkaComponent } from './stopka/stopka.component';
export function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
  keycloak.init({
    config: {
    url: 'http://localhost:8081/auth',
    realm: 'Front2',
    clientId: 'rosek'
    },
  initOptions: {
  onLoad: 'check-sso',
  silentCheckSsoRedirectUri:
    window.location.origin + '/assets/silent-check-sso.html'
  },
  loadUserProfileAtStartUp: true
  });
}

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    DietaComponent,
    LogowanieComponent,
    KoszykComponent,
    KlasycznyComponent,
    StopkaComponent    
  ],
  exports:[
    MatDatepickerModule,
    MatNativeDateModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    KeycloakAngularModule,
    HttpClientModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatCardModule,
    FormsModule,
    MatDatepickerModule,
    
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    }    
  ],
  bootstrap: [AppComponent]
})
export class AppModule {


  
  constructor(private httpClient: HttpClient){
    
  }
  
 }