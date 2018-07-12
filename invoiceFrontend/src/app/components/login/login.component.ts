import { Component, OnInit } from '@angular/core';
import {MatInputModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Router, ActivatedRoute } from '@angular/router';
import {LoginService} from '../../services/login.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  private login={
    userId:"",
    password:""
  }
  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit() {
  }
logIn(){
  console.log(this.login);
  this.loginService.login(this.login).subscribe(data=>{
    if(data)
  {  localStorage.setItem("loggedInUser","true");
    this.router.navigate(['dashboard']);
  }
  });
 }
}
