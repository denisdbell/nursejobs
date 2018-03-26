import { Injectable } from "@angular/core";
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { Job } from "../model/Job";

@Injectable()
export class SaveJobService {
  apiEndPointHost: string = "http://10.5.0.5:8080";

  constructor(private http: Http) {}

  save(job: Job) {
    let headers = new Headers();
    headers.append("Content-Type", "application/json");
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.apiEndPointHost + "/job/create", job, options);
  }

  delete(id: number) {
    let headers = new Headers();
    headers.append("Content-Type", "application/json");
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(this.apiEndPointHost + "/job/delete/"+id, options);
  }

  fetchAll() {
    let headers = new Headers();

    return this.http
      .get(this.apiEndPointHost + "/job/list", {
        headers: headers
      })
      .map((resp: Response) => resp.json());
  }
}
