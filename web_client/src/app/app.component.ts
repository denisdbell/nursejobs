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
  criteria: string;
  location: string;

  constructor(private jobService: JobService) {
    this.loadInitialData();

    console.log("Jobs" + this.jobs);
  }

  search() {
    this.jobService
      .fetchByCriteriaAndLocation(this.criteria, this.location)
      .subscribe((data: Job[]) => (this.jobs = data));
  }

  loadInitialData() {
    this.jobService.fetchAll().subscribe((data: Job[]) => (this.jobs = data));
  }
}
