import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LoginPageComponent } from './login-page/login-page.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { RestAppService} from './rest-app.service';
import { from } from 'rxjs';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import {MatTableModule} from '@angular/material/table';
import { RegisterComponent } from './register/register.component';
import { SideListComponent } from './side-list/side-list.component';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import { LayoutModule } from '@angular/cdk/layout';
import { AgmCoreModule } from '@agm/core';
import {MapaComponent} from './mapa/mapa.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import { KosztaComponent } from './koszta/koszta.component';
import { PracownicyComponent } from './pracownicy/pracownicy.component';
import { NgxEchartsModule } from 'ngx-echarts';
import { MagazynComponent } from './magazyn/magazyn.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    LandingPageComponent,
    MenuComponent,
    RegisterComponent,
    SideListComponent,
    MapaComponent,
    KosztaComponent,
    PracownicyComponent,
    MagazynComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FlexLayoutModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatListModule,
    MatIconModule,
    MatSidenavModule,
    MatToolbarModule,
    LayoutModule,
    MatSlideToggleModule,
    MatSelectModule,
    NgxEchartsModule.forRoot({
      echarts: () => import('echarts')
    }),
    AgmCoreModule.forRoot({apiKey:'AIzaSyCPr7B04oPNyzMSE4HEv80ESthv4Vdfefs'})
  ],
  providers: [RestAppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
