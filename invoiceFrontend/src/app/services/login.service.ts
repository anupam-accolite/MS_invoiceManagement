import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { RequestOptions, Request, RequestMethod } from '@angular/http';
import { GlobalVariable } from '../path';

@Injectable()
export class LoginService {
  
  private login_url: string = GlobalVariable.BASE_API_URL + "/login/";
  constructor(private http:HttpClient) {}

  login(login)
  {
    return this.http.post(this.login_url,login);
  }
}
