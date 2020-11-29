import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { RestAppService } from '../rest-app.service';
import { SidenavService} from '../side-list/sidenav.service';


export interface PeriodicElement {
  id: number;
  imie: string;
  nazwisko: string;
  stanowisko: string;
  telefon: number;
  godziny: number;
  stawka: number;
  wyplata: number;
}

@Component({
  templateUrl: './pracownicy.component.html',
  styleUrls: ['./pracownicy.component.css']
})
export class PracownicyComponent implements OnInit {

  id: number;
  imie: string;
  nazwisko: string;
  stanowisko: string;
  telefon: number;
  godziny: number;
  stawka: number;

  displayedColumns: string[] = ['id', 'imie', 'nazwisko', 'stanowisko', 'telefon', 'godziny', 'stawka' , 'wyplata'];
  dataSource = new MatTableDataSource<Element>();
  constructor(private service:RestAppService,public nav:SidenavService) { }

  items:any;

  ngOnInit(): void {
    this.nav.show();
    let response=this.service.dane_pracownicy();
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

  dodaj()
  {
    this.service.dodaj_pracownik(this.imie,this.nazwisko,this.stanowisko,this.telefon,this.stawka).subscribe(res=>{});
  }

  usun()
  {
    this.service.usun_pracownik(this.id).subscribe(res=>{});
  }

  edytuj()
  {
    this.service.edytuj_pracownik(this.id,this.imie,this.nazwisko,this.stanowisko,this.telefon,this.godziny,this.stawka).subscribe(res=>{});
  }

  dodaj_godziny()
  {
    this.service.dodaj_godziny(this.id,this.godziny).subscribe(res=>{});
  }

  odejmij_godziny()
  {
    this.service.odejmij_godziny(this.id,this.godziny).subscribe(res=>{});
  }

  resetuj_godziny()
  {
    this.service.resetuj_godziny(this.id).subscribe(res=>{});
  }
}
