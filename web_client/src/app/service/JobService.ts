import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Job } from '../model/Job';


@Injectable()
export class JobService{
  

  apiEndPoint: string = "https://jobs.search.gov/jobs/search.json?query=nursing+jobs"; 

  constructor(private http: Http){
  }

  fetchAll(){

    let headers = new Headers();

    return this.http.get(this.apiEndPoint, {
        headers: headers
      }).map((resp: Response) => resp.json())
                  
  }


  fetchByCriteriaAndLocation(criteria: string, location: string){

    let headers = new Headers();

    return this.http.get(this.apiEndPoint + "+with+" + criteria + "+in+" + location , {
        headers: headers
    }).map((resp: Response) => resp.json())
                  
  }
}