import { Component, OnInit } from '@angular/core';
import {CommonServiceService} from '../../services/common-service.service';
//import {months} from '../../models/month';
@Component({
  selector: 'app-projection',
  templateUrl: './projection.component.html',
  styleUrls: ['./projection.component.css']
})
export class ProjectionComponent implements OnInit {
  
  selected;
  projectionData={
    Bengaluru:0,
    Mumbai: 0
  } 
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
 
    

    
  constructor(private service:CommonServiceService) { }

  ngOnInit() {

    var curMonth:number=new Date().getMonth();
    this.months.forEach(x=>{
      if(curMonth+1==x.value)
      {
        this.selected=x.value;
      }
      if(curMonth+1<=x.value){
          x.bool=false;
      }
    })
    }
  
  
 Projection()
 { 
   let x= {
   "month":this.selected
 }
 console.log(this.selected);
   this.service.projection(x).subscribe((data:any)=>{
     console.log(data);
     this.projectionData.Bengaluru=data.Bengaluru;
     this.projectionData.Mumbai=data.Mumbai;
     console.log(this.projectionData);
     
   });

 }

}
