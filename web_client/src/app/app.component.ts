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
  savedJobs: Job[];
  criteria: string;
  location: string;
  showSavedJobs: boolean = false;

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
    console.log(job);
    this.saveJobService.save(job).subscribe(
      data => {
        this.loadSavedJobs();
      },
      err => console.log("An error ocurred")
    );
  }

  loadInitialData() {
    this.loadGovernmentJobs();
    this.loadSavedJobs();
  }

  loadGovernmentJobs() {
    this.jobService.fetchAll().subscribe(
      data => {
        this.jobs = data;
      },
      err => console.log("Error occurred")
    );
  }

  loadSavedJobs() {
    this.saveJobService.fetchAll().subscribe(
      data => {
        this.savedJobs = data;
      },
      err => console.log("Authentication Complete")
    );
  }

  deleteSavedJob(id:number) {
    this.saveJobService.delete(id).subscribe(
      data => {
        this.loadSavedJobs();
      },
      err => console.log("Authentication Complete")
    );
  }

  toggleSavedJobs() {
    this.showSavedJobs = !this.showSavedJobs;
  }
}
