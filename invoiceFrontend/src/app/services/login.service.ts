import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { RequestOptions, Request, RequestMethod } from '@angular/http';

@Injectable()
export class LoginService {

  constructor(private http:HttpClient) {}

  login(login)
  {
    return this.http.post("",login);
  }
}
