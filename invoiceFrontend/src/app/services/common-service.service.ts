import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { RequestOptions, Request, RequestMethod } from '@angular/http';
import { GlobalVariable } from '../path';

@Injectable()
export class CommonServiceService {
  
  private projection_url: string = GlobalVariable.BASE_API_URL + "/projection/";
  private utilisation_url: string = GlobalVariable.BASE_API_URL + "/utilization/";
  private discrepancy_url: string = GlobalVariable.BASE_API_URL + "/discrepancy/";
  private invoice_url: string = GlobalVariable.BASE_API_URL + "/invoice/";
  private draft_url: string = GlobalVariable.BASE_API_URL + "/draft/";
  private tfrGet_url:string= GlobalVariable.BASE_API_URL + "/tfr/?status=";
  private tfrUpdate_url:string= GlobalVariable.BASE_API_URL + "/tfr/edit/";
  
  constructor(private http:HttpClient) { }
 
  projection(month)
  {
    return this.http.post(this.projection_url,month);
  }
  utilization(util)
  {
    return this.http.post(this.utilisation_url,util);
  }
  discrepancy()
  {
    return this.http.get(this.discrepancy_url);
  }
  invoice(month)
  {
    return this.http.post(this.invoice_url,month);
  }
  draft()
  {
    return this.http.get(this.draft_url);
  }

  tfrGetDetails(status)
  {
    return this.http.get(this.tfrGet_url+status);
  }
  tfrUpdate(status,tfrEntity)
  { 

    return this.http.put(this.tfrUpdate_url+status,tfrEntity);
  }
  
}
