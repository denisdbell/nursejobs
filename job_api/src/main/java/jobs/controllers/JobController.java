package jobs.controllers;

import jobs.models.Job;
import jobs.models.JobDao;
import jobs.models.Location;
import jobs.models.LocationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to test interactions with the MySQL database using the JobDao class.
 *
 * @author Denis Bell <http://denisdbell.com>
 */
@Controller
public class JobController {

  @RequestMapping("/job/create")
  @ResponseBody
  public Job create(@RequestBody Job job) {
    Job newJob = null;
    try {

      List<Location> locations = job.getLocations();

      job.setLocations(null);

      newJob = jobDao.save(job);

      for (int x = 0; x < locations.size(); x++) {
        locations.get(x).setJob(newJob);
      }

      locationDao.save(locations);

    } catch (Exception ex) {
      return null;
    }
    return newJob;
  }

  @RequestMapping("job/list")
  @ResponseBody
  public ArrayList<Job> getAll() {

    ArrayList<Job> jobs = null;

    try {
      jobs = jobDao.findAll();
    } catch (Exception ex) {
      return new ArrayList<Job>();
    }
    return jobs;
  }

  @RequestMapping(value = "job/delete/{id}")
  @ResponseBody
  public void delete(@PathVariable Long id) {

    jobDao.delete(id);

  }

  @Autowired
  private JobDao jobDao;

  @Autowired
  private LocationDao locationDao;

} // class JobController
