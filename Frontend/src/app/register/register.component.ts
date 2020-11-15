import { Component, OnInit } from '@angular/core';
import { RestAppService } from '../rest-app.service';
import { MethodCall } from '@angular/compiler';
import { Router } from '@angular/router';
import { SidenavService} from '../side-list/sidenav.service';



@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  login:string;
  password:string;
  miasto:string;
  wlasciciel:string;

  constructor(private service: RestAppService, private router:Router ,public nav:SidenavService) {}

  ngOnInit(): void {this.nav.hide();}

  register_met()
  {
    this.service.register_user(this.login,this.password).subscribe(res=>{});
  }

}
