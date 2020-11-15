import { Component, OnInit } from '@angular/core';
import { RestAppService } from '../rest-app.service';
import { MethodCall } from '@angular/compiler';
import { Router } from '@angular/router';
import { SidenavService} from '../side-list/sidenav.service';


@Component({
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  username: string;
  password: string;
  message: string;

  constructor(private service: RestAppService, private router:Router,public nav:SidenavService) { }

  ngOnInit(): void {
    this.nav.hide();
  };

  login_met(){
    let response = this.service.login(this.username,this.password);
    response.subscribe(data=>{
      console.log(data);
      this.router.navigate(["/menu"])
    })
  };

}
