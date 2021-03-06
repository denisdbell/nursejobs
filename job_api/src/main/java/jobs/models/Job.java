package jobs.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Job entity
 * 
 * @author Denis Bell <http://denisdbell.com>
 */
@Entity
@Table(name = "jobs")
public class Job {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long _id;

  private String id;

  
  //Title or position of the job
  @NotNull
  private String position_title;

  //Organization for the job
  @NotNull
  private String organization_name;

  @NotNull
  private String rate_interval_code;

  //Minimum Salary
  @NotNull
  private Integer minimum;

  //Maximum Salary
  @NotNull
  private Integer maximum;

  //Job start date
  @NotNull
  private Date start_date;

  //Job end date
  @NotNull
  private Date end_date;

  //TODO Locations
  @NotNull
  private String url;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
  private List<Location> locations;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  public Job() {
  }

  // Getter and setter methods

  public long get_Id() {
    return this._id;
  }

  public void set_Id(long value) {
    this._id = value;
  }


  public String getId() {
    return id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getPosition_title() {
    return this.position_title;
  }

  public void setPosition_title(String position) {
    this.position_title = position;
  }

  public String getOrganization_name() {
    return this.organization_name;
  }

  public void setOrganization_name(String organization_name) {
    this.organization_name = organization_name;
  }

  public String getRate_interval_code() {
    return this.rate_interval_code;
  }

  public void setRate_interval_code(String rate_interval_code) {
    this.rate_interval_code = rate_interval_code;
  }

  public Integer getMinimum() {
    return this.minimum;
  }

  public void setMinimum(Integer minimum) {
    this.minimum = minimum;
  }

  public Integer getMaximum() {
    return this.maximum;
  }

  public void setMaximum(Integer maximum) {
    this.maximum = maximum;
  }

  public Date getStart_date() {
    return this.start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return this.end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Location> getLocations() {
    return this.locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }
  
} // class Job
