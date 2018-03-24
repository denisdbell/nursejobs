package netgloo.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

@Transactional
public interface LocationDao extends CrudRepository<Location, Long> {

} // class LocationDao
