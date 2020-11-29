import { Component, OnInit } from '@angular/core';
import { SidenavService} from '../side-list/sidenav.service';
import {MatTableDataSource} from '@angular/material/table';
import { RestAppService } from '../rest-app.service';


export interface PeriodicElement {
  data: any;
  opis: string;
  cena: number;
}

@Component({
  templateUrl: './koszta.component.html',
  styleUrls: ['./koszta.component.css']
})
export class KosztaComponent implements OnInit {

  dane1:any;
  dane2:any;

  suma:number;

  items:any;
  data:any;
  opis:string;
  cena:number;

  koszt_produktow:number;
  koszt_pracownikow:number;
  koszt_pojazdow:number;
  koszt_inne:number;
  dochod_restauracja:number;
  dochod_calkowity:number;

  displayedColumns: string[] = ['data', 'opis', 'cena'];
  dataSource = new MatTableDataSource<Element>();

  constructor(private service:RestAppService,public nav:SidenavService) {}

  ngOnInit(): void {
    this.nav.show();
    this.dane_dzienne_pobierz();
    this.dochod_pobierz();
    this.pobierz_dane_inne_wydatki();
  }

  pobierz_dane_inne_wydatki() : void
  {
    let response=this.service.dane_inne_wydatki();
    response.subscribe(data => {

      console.log("data>>>>>",data);
      this.items = data;
      this.dataSource.data = this.items;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  dane_dzienne_pobierz()
  {
    let response=this.service.dane_dzienne_pobierz();
    response.subscribe(data=>this.dane1=data);
  }

  dochod_pobierz()
  {
    let response=this.service.dochod_pobierz();
    response.subscribe(data=>this.dane2=data);
  }

  dzienny_dochod()
  {
    this.service.dzienny_dochod(this.suma).subscribe(res=>{});
  }

  dodatkowe_wydatki()
  {
    this.service.dodatkowe_wydatki(this.data,this.opis,this.cena).subscribe(res=>{});
  }

  zatwierdz_koszta()
  {
    this.service.zatwierdz_koszta(this.data).subscribe(res=>{});
  }
}
