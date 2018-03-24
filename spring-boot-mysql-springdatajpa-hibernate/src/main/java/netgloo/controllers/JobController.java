package netgloo.controllers;

import netgloo.models.Job;
import netgloo.models.JobDao;
import netgloo.models.Location;
import netgloo.models.LocationDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@Controller
public class JobController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  @RequestMapping("/job/create")
  @ResponseBody
  public String create(@RequestBody Job job) {
    Job newJob = null;
    try {

      List<Location> locations = job.getLocations();

      job.setLocations(null);

      newJob = jobDao.save(job);

      for(int x = 0; x < locations.size() ; x++){
          locations.get(x).setJob(newJob);
      }

      locationDao.save(locations);

      //job.setLocations( locations );
      
      
    }
    catch (Exception ex) {
      return "Error creating the job: " + ex.toString();
    }
    return "Job succesfully created! (id = " + newJob.getId() + ")";
  }
  

  

  @RequestMapping("job/list/")
  @ResponseBody
  public ArrayList<Job> getAll() {
    
    ArrayList<Job> jobs = null;
    
    try {
        jobs = jobDao.findAll();
    }
    catch (Exception ex) {
      return new ArrayList<Job>();
    }
    return jobs;
  }
  
  

  @Autowired
  private JobDao jobDao;

  @Autowired
  private LocationDao locationDao;
} // class JobController
