import { Component, OnInit } from '@angular/core';
import { DiscrepancyEntity } from '../../models/DiscrepancyEntity';
import { CommonServiceService } from '../../services/common-service.service';

@Component({
  selector: 'app-discrepancies',
  templateUrl: './discrepancies.component.html',
  styleUrls: ['./discrepancies.component.css']
})
export class DiscrepanciesComponent implements OnInit {
  entities;
  constructor(private _discrepancyService: CommonServiceService) {

   }

  ngOnInit() {
     this._discrepancyService.discrepancy().subscribe(data=>{this.entities=data;console.log(data)});
  }



}
