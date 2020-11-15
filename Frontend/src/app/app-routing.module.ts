import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import {LandingPageComponent} from './landing-page/landing-page.component';
import {MenuComponent} from './menu/menu.component';
import {RegisterComponent} from './register/register.component';
import { from } from 'rxjs';
import { SideListComponent } from './side-list/side-list.component';
import { MapaComponent } from './mapa/mapa.component';
import {KosztaComponent} from './koszta/koszta.component';
import {PracownicyComponent} from './pracownicy/pracownicy.component';
import {MagazynComponent} from './magazyn/magazyn.component';

const routes: Routes = [
  {path: '', component: LandingPageComponent},
  {path: 'logowanie', component: LoginPageComponent},
  {path: 'strona_glowna', component: LandingPageComponent},
  {path: 'menu', component:MenuComponent},
  {path: 'rejestracja', component:RegisterComponent},
  {path: 'mapa', component:MapaComponent},
  {path: 'koszta', component:KosztaComponent},
  {path: 'pracownicy', component:PracownicyComponent},
  {path: 'magazyn', component:MagazynComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
