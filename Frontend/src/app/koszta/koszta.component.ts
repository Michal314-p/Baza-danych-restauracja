import { Component, OnInit } from '@angular/core';
import { SidenavService} from '../side-list/sidenav.service';


@Component({
  templateUrl: './koszta.component.html',
  styleUrls: ['./koszta.component.css']
})
export class KosztaComponent implements OnInit {

  constructor(public nav:SidenavService) {}

  ngOnInit(): void {
    this.nav.show();

  }
}
