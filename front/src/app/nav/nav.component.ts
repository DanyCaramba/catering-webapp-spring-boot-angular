import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  router: any;
  constructor(private readonly keycloak: KeycloakService) { }
  public isLoggedIn: boolean = false;
  public hasAdminRole: boolean = false;

  ngOnInit(): void {
    this.keycloak.isLoggedIn().then(isLoggedIn => {
      this.isLoggedIn = isLoggedIn;
      this.hasAdminRole = this.keycloak.getUserRoles().includes('admin');
    });
   } 

  public async logout() {
    this.clearLocalStorage();
   this.keycloak.logout(); 
    this.router.navigate(['/']);
  }

  public async login() {
    this.keycloak.login(); 
  }

  public clearLocalStorage(): void {
    localStorage.clear();
  }
}
