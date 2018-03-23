package netgloo.controllers;

import netgloo.models.Job;
import netgloo.models.JobDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
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
  public String create(Job job) {
    Job newJob = null;
    try {
      newJob = jobDao.save(job);
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
  
} // class UserController
