package netgloo.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * A DAO for the Job entity
 */
@Transactional
public interface JobDao extends CrudRepository<Job, Long> {

    ArrayList<Job> findAll();

} // class JobDao
