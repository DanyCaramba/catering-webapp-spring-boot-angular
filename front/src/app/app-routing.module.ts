import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DietaComponent } from './dieta/dieta.component';
import { LogowanieComponent } from './logowanie/logowanie.component';
import { AuthGuard } from './utility/app.guard';
import { KlasycznyComponent } from './klasyczny/klasyczny.component';
import { KoszykComponent } from './koszyk/koszyk.component';
const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'Diety', component: DietaComponent},
  {path: 'Klasyczny', component: KlasycznyComponent},
  {path: 'Koszyk', component: KoszykComponent},
  {path: 'Logowanie', component:LogowanieComponent, canActivate: [AuthGuard] }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

