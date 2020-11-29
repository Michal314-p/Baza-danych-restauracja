import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { RestAppService } from '../rest-app.service';
import { SidenavService} from '../side-list/sidenav.service';
import {MatDialog} from '@angular/material/dialog';
import { DialogDostawaComponent } from './dialog-dostawa/dialog-dostawa.component';


export interface PeriodicElement {
  pojazd: string;
  marka: string;
  spalanie: number;
  koszt: number;
  id:number;
}
@Component({
  templateUrl: './dostawa.component.html',
  styleUrls: ['./dostawa.component.css']
})
export class DostawaComponent implements OnInit {

  displayedColumns: string[] = ['id','pojazd', 'marka', 'spalanie', 'koszt'];
  dataSource = new MatTableDataSource<Element>();
  constructor(public dialog: MatDialog,private service:RestAppService,public nav:SidenavService) { }

  items:any;
  pojazd:string;
  marka:string;
  spalanie:number;
  koszt:number;
  id:number;
  cena:number;

  ngOnInit(): void {
    this.pobierz_dane();
    this.nav.toggle();
  }

  pobierz_dane() : void
  {
    let response=this.service.dane_pojazdy();
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

  dodaj_pojazd()
  {
    this.service.dodaj_pojazd(this.pojazd,this.marka).subscribe(res=>{});
  }

  usun_pojazd()
  {
    this.service.usun_pojazd(this.id).subscribe(res=>{});
  }

  edytuj_pojazd()
  {
    this.service.edytuj_pojazd(this.id,this.pojazd,this.marka,this.spalanie,this.koszt).subscribe(res=>{});
  }

  rachunek_paliwo()
  {
    this.service.rachunek_paliwo(this.id,this.spalanie,this.koszt).subscribe(res=>{});
  }

  reset_paliwo()
  {
    this.service.reset_paliwo(this.id).subscribe(res=>{});
  }

  openDialog() {
    this.dialog.open(DialogDostawaComponent, {
      height: '400px',
      width: '600px',
    });
  }

}


