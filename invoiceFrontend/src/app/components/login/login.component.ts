import { Component, OnInit } from '@angular/core';
import {MatInputModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {LoginService} from '../../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  private login={
    id:"",
    password:""
  }
  constructor(private loginService:LoginService) { }

  ngOnInit() {
  }
log(){
  this.loginService.login(this.login);
 }
}
