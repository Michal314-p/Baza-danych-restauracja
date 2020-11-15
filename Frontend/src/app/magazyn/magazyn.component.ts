import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { RestAppService } from '../rest-app.service';
import { SidenavService} from '../side-list/sidenav.service';


export interface PeriodicElement {
  nazwa: string;
  jednostka: string;
  ilosc: number;
  cena: number;
  wartosc: number;
}

@Component({
  templateUrl: './magazyn.component.html',
  styleUrls: ['./magazyn.component.css']
})
export class MagazynComponent implements OnInit {

  displayedColumns: string[] = ['nazwa', 'jednostka', 'ilosc', 'cena', 'wartosc'];
  dataSource = new MatTableDataSource<Element>();
  constructor(private service:RestAppService,public nav:SidenavService) { }

  items:any;
  nazwa:string;
  jednostka:string;
  ilosc:number;
  cena:number;

  ngOnInit(): void {
    this.pobierz_dane();
    this.nav.toggle();
  }

  pobierz_dane() : void
  {
    let response=this.service.dane_magazyn();
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

  dodaj_metoda()
  {
    this.service.dodaj_produkt(this.nazwa,this.jednostka,this.ilosc,this.cena).subscribe(res=>{});
  }

  usun_metoda()
  {
    this.service.usun_produkt(this.nazwa).subscribe(res=>{});
  }

  edytuj_metoda()
  {
    this.service.edytuj_produkt(this.nazwa,this.jednostka,this.ilosc,this.cena).subscribe(res=>{});
  }

  zamow()
  {
    this.service.zamow_produkt(this.nazwa,this.ilosc).subscribe(res=>{});
  }

  odejmij()
  {
    this.service.odejmij_produkt(this.nazwa,this.ilosc).subscribe(res=>{});
  }

}
