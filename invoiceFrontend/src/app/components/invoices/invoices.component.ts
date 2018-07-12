
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
  invoiceData1={
    location:null,
    invoice:0

  } 
  locationArray=[];
  invoiceArray=[];

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
    
    { 
      let x= {
      "month":this.selected
    }

    console.log(this.selected);
   this.service.invoice(x).subscribe((data:any)=>{
     console.log(data);
      this.locationArray=Object.keys(data);
      this.invoiceArray=[];

     for(var i=0, keys=Object.keys(data), ii=keys.length;i<ii;i++){
      //  locationArray.concat(keys[i]);
        var val=data[keys[i]];
        this.invoiceArray[i]=val;
     }
     console.log(this.locationArray);
     console.log(this.invoiceArray);
})



  }
}

}
