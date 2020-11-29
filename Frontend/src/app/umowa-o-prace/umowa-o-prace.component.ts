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
  templateUrl: './umowa-o-prace.component.html',
  styleUrls: ['./umowa-o-prace.component.css']
})
export class UmowaOPraceComponent implements OnInit {

  id: number;
  imie: string;
  nazwisko: string;
  stanowisko: string;
  telefon: number;
  godziny: number;
  stawka: number;
  etat: number;
  wyplata: number;

  displayedColumns: string[] = ['id', 'imie', 'nazwisko', 'stanowisko', 'telefon', 'etat', 'godziny' , 'wyplata'];
  dataSource = new MatTableDataSource<Element>();
  constructor(private service:RestAppService,public nav:SidenavService) { }

  items:any;

  ngOnInit(): void {
    this.nav.show();
    let response=this.service.dane_o_prace();
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

  dodaj_o_prace()
  {
    this.service.dodaj_o_prace(this.imie,this.nazwisko,this.stanowisko,this.telefon,this.etat,this.wyplata).subscribe(res=>{});
  }

  usun_o_prace()
  {
    this.service.usun_o_prace(this.id).subscribe(res=>{});
  }

  edytuj_o_prace()
  {
    this.service.edytuj_o_prace(this.id,this.imie,this.nazwisko,this.stanowisko,this.telefon,this.etat,this.wyplata).subscribe(res=>{});
  }

  dodaj_godziny_o_prace()
  {
    this.service.dodaj_godziny_o_prace(this.id,this.godziny).subscribe(res=>{});
  }

  odejmij_godziny_o_prace()
  {
    this.service.odejmij_godziny_o_prace(this.id,this.godziny).subscribe(res=>{});
  }

  resetuj_godziny_o_prace()
  {
    this.service.resetuj_godziny_o_prace(this.id).subscribe(res=>{});
  }

  ustaw_etat()
  {
    this.service.ustaw_etat(this.godziny).subscribe(res=>{});
  }

}
