import { Component, OnInit } from '@angular/core';
import {CommonServiceService} from '../../services/common-service.service';
@Component({
  selector: 'app-utilisation',
  templateUrl: './utilisation.component.html',
  styleUrls: ['./utilisation.component.css']
})
export class UtilisationComponent implements OnInit {
  
  selectedMonth;
  selectedYear;
 locationArray=[];
 actualArray=[];
 availableArray=[];
 utilisationArray=[];
  months=[
      {
        month:"January",
        bool:true,
        value:1
       },
       {
        month:"February",
        bool:true,
        value:2
       },
       {
        month:"March",
        bool:true,
        value:3
       }
       ,{
        month:"April",
        bool:true,
        value:4
       },{
        month:"May",
        bool:true,
        value:5
       },{
        month:"June",
        bool:true,
        value:6
       },{
        month:"July",
        bool:true,
        value:7
       },{
        month:"August",
        bool:true,
        value:8
       },{
        month:"September",
        bool:true,
        value:9
       },{
        month:"October",
        bool:true,
        value:10
       },{
        month:"November",
        bool:true,
        value:11
       },{
        month:"December",
        bool:true,
        value:12
       }
    ]
    years=[
      2016,
      2017,
      2018
    ]
  constructor(private service:CommonServiceService) { }

  ngOnInit() {
    this.selectedYear=new Date().getFullYear();
    var curMonth:number=new Date().getMonth();
    this.months.forEach(x=>{
      if(curMonth+1==x.value)
      {
        this.selectedMonth=x.value;
      }
    })
  }

  Utilization(){
    
    let x=
    {
      "month":this.selectedMonth,
      "year":this.selectedYear
    }

  if(this.selectedYear==new Date().getFullYear() && this.selectedMonth+1>=new Date().getMonth())
     {
       alert("Select past months only");
     } 
     else{
    this.service.utilization(x).subscribe((data:any)=>{
      console.log(data);
      this.locationArray=Object.keys(data);

      for(var i=0, keys=Object.keys(data), ii=keys.length;i<ii;i++){
        //  locationArray.concat(keys[i]);
          var val=data[keys[i]];
          this.actualArray[i]=val[0];
          this.availableArray[i]=val[1];
          this.utilisationArray[i]=val[2];
       }
       console.log(this.actualArray);
       console.log(this.availableArray);
       console.log(this.utilisationArray);
      // if(data.mum!=null)
      // {
      //   this.utlisationMumbai=data.mum[2]*100;
      // }
      // if(data.blr!=null)
      // {
      //   this.utlisationBangalore=data.blr[2]*100;
      // }

    });
  } 
}
}
