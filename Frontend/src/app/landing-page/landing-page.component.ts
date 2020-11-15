import { Component, OnInit } from '@angular/core';
import { SidenavService} from '../side-list/sidenav.service';


@Component({
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(public nav:SidenavService) { }

  ngOnInit(): void {
    this.nav.hide();
  }

}
