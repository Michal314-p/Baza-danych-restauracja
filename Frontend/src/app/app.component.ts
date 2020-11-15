import { Component } from '@angular/core';
import { RestAppService } from './rest-app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private service: RestAppService) {}




  title = 'logowanie';
}
