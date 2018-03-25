import { Component } from "@angular/core";
import { Job } from "./model/Job";
import { JobService } from "./service/JobService";
import { SaveJobService } from "./service/SaveJobService";

@Component({
  selector: "app",
  templateUrl: "./app.component.html",
  providers: [JobService, SaveJobService]
})
export class AppComponent {
  jobs: Job[];
  criteria: string;
  location: string;

  constructor(
    private jobService: JobService,
    private saveJobService: SaveJobService
  ) {
    this.loadInitialData();

    console.log("Jobs" + this.jobs);
  }

  search() {
    this.jobService
      .fetchByCriteriaAndLocation(this.criteria, this.location)
      .subscribe((data: Job[]) => (this.jobs = data));
  }

  saveJob(job: Job) {
    console.log("Save pressed");
    this.saveJobService.save(job);
  }

  loadInitialData() {
    this.jobService.fetchAll().subscribe((data: Job[]) => (this.jobs = data));
  }
}
