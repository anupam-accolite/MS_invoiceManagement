import { Component, OnInit } from '@angular/core';
import { CommonServiceService } from '../../services/common-service.service';

@Component({
  selector: 'app-incomplete-timesheets',
  templateUrl: './incomplete-timesheets.component.html',
  styleUrls: ['./incomplete-timesheets.component.css']
})
export class IncompleteTimesheetsComponent implements OnInit {
  
  locationKey=[];
  location=[];
 
   timesheetid=[];
   workername=[];

 

  constructor(private _incompleteTimesheetService: CommonServiceService) {

   }

  ngOnInit() {
    this. _incompleteTimesheetService.draft().subscribe(data=>{
this.locationKey=Object.keys(data);
console.log(this.locationKey);
for(var i=0, keys=Object.keys(data), ii=keys.length;i<ii;i++){
  //  locationArray.concat(keys[i]);
 // console.log(this.locationKey[i]);
  var val=data[this.locationKey[i]];
  
  for(var j=0;j<val.length;j++)
  {
   
this.location.push(this.locationKey[i]);
this.timesheetid.push(val[j].timesheetid);
this.workername.push(val[j].workername);

  }
 }
 //console.log(this.location);
 //console.log(this.timesheetid);
 //console.log(this.workername);
    });
  }

}
