package jobs.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * A Data Access Object for the Job entity
 * 
 * @author Denis Bell <http://denisdbell.com>
 */
@Transactional
public interface JobDao extends CrudRepository<Job, Long> {

    ArrayList<Job> findAll();

} // class JobDao
