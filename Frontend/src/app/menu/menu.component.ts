import { Component, OnInit } from '@angular/core';
import { RestAppService } from '../rest-app.service';
import { SidenavService} from '../side-list/sidenav.service';


@Component({
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private service:RestAppService,public nav:SidenavService) { }

  users:any;

  ngOnInit(): void {
    this.nav.show();
    let response=this.service.pobierz_dane();
    response.subscribe(data=>this.users=data);
  }



}
