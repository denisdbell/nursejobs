import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { Job } from "../model/Job";

@Injectable()
export class SaveJobService {
  apiEndPoint: string = "http://localhost:8080/job/create";

  constructor(private http: Http) {}

  save(job: Job) {
    let headers = new Headers();
    this.http.post(this.apiEndPoint, job, {
      headers: headers
    });
  }
}
