import { Component } from "@angular/core";
import { Job } from "./model/Job";
import { JobService } from "./service/JobService";

@Component({
  selector: "app",
  templateUrl: "./app.component.html",
  providers: [JobService]
})
export class AppComponent {

  jobs: Job[];

  constructor(private jobService: JobService) {
    this.loadInitialData();
        
    console.log("Jobs" + this.jobs);
  }

  loadInitialData() {
    this.jobService.fetchAll()
    .subscribe((data: Job[]) =>  this.jobs = data );
  }
}

