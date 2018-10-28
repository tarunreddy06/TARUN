package spring.practice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.practice.entity.Data;


@Repository
public interface DataRepository extends CrudRepository<Data, Long> {
	
	List<Data> findByEmail(String email);
	List<Data> findByName(String name);

   // List<Data> findByDate(Timestamp date);

	// Stream<Data> findByEmailReturnStream(@Param("email") String email);
    
}
