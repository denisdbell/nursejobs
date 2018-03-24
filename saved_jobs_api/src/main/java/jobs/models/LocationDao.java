package jobs.models;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * A Data Access Object for the Location entity
 * 
 * @author Denis Bell <http://denisdbell.com>
 */
@Transactional
public interface LocationDao extends CrudRepository<Location, Long> {

} // class LocationDao
