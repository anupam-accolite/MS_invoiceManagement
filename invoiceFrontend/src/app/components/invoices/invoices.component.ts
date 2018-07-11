
import { Component, OnInit } from '@angular/core';
import {CommonServiceService} from '../../services/common-service.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.css']
})
export class InvoicesComponent implements OnInit {

  selected=true;
  invoiceData={
    bangalore:0,
    mumbai:0
  } 

  months=[
    {
      month:"Current",
      value:true
     },
     {
      month:"Previous",
      value:false
     }
  ]

  constructor(private service:CommonServiceService,private router : Router) { }

  ngOnInit() {
    if( localStorage.getItem("loggedInUser")==null)
    {
        this.router.navigate(['login']);
    }
  }

  invoice(){
    this.invoiceData.bangalore = 0.0 ;
    this.invoiceData.mumbai = 0.0 ;
    { 
      let x= {
      "month":this.selected
    }

    console.log(this.selected);
   this.service.invoice(x).subscribe((data:any)=>{
     console.log(data);
     this.invoiceData.bangalore=data.blr;
     this.invoiceData.mumbai=data.mum;
     
   });



  }
}

}
