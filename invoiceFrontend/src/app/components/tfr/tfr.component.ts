import { Component, OnInit } from '@angular/core';

import { CommonServiceService } from '../../services/common-service.service';
import { Status_Code_Mapping } from '../../models/status_code_mapping';
import { TFREntity } from '../../models/TFREntity';
@Component({
  selector: 'app-tfr',
  templateUrl: './tfr.component.html',
  styleUrls: ['./tfr.component.css']
})
export class TfrComponent implements OnInit {

  constructor(private _tfrService:CommonServiceService) { }

  public entities:TFREntity[];
  public statusFilter:number=0;
  public filterValues:Status_Code_Mapping[]=[{"status":0,"mappedName":"none"},
  {"status":1,"mappedName":"Billable"},
  {"status":2,"mappedName":"Non-Billable"}]

  ngOnInit() {

this.getList();
  }
  getList()
  {
    this._tfrService.tfrGetDetails(this.statusFilter).subscribe((data:TFREntity[])=>this.entities=data);
  } 
    

  onClick()
  {
    this._tfrService.tfrUpdate(this.statusFilter,this.entities).subscribe((data:TFREntity[])=>this.entities=data);
   }

}
