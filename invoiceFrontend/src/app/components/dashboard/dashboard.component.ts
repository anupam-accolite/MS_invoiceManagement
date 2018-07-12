import { Component, OnInit } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
//import { NgbCarouselModule, NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { Router, ActivatedRoute } from '@angular/router';
import { TfrComponent } from '../tfr/tfr.component';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css',
  "./assets/web/assets/mobirise-icons/mobirise-icons.css",
  "./assets/tether/tether.min.css",
  "./assets/bootstrap/css/bootstrap.min.css",
  "./assets/bootstrap/css/bootstrap-grid.min.css",
  "./assets/bootstrap/css/bootstrap-reboot.min.css",
  "./assets/socicon/css/styles.css",
  "./assets/dropdown/css/style.css",
  "./assets/theme/css/style.css"]
})
export class DashboardComponent implements OnInit {


  constructor(private router:Router) {

   
   }

  ngOnInit() {
     if( localStorage.getItem("loggedInUser")==null)
     {
         this.router.navigate(['login']);
     }
  }
Projection()
{
 this.router.navigate(['projection']);
}

Invoice()
{
    this.router.navigate(['invoice']);
}

Discrepancies()
{
    this.router.navigate(['discrepancies']);
}

Pending()
{
    this.router.navigate(['followUp']);
}
Utilization()
{
    this.router.navigate(['utilisation']);
}



TFR(){
    this.router.navigate(['tfr']);
}
}