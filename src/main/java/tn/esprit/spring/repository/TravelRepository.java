package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> ,JpaRepository<Travel, Long> {
	
	@Query("SELECT t FROM Travel t join t.travelplannings tp WHERE t.startDate BETWEEN :startDate and :endDate and tp.day LIKE :day")
    List<Travel> gettarvelsByDateAndday(@Param("startDate") Date startDate,@Param("endDate") Date endDate, @Param("day") String day);
	
	
	
	@Query("SELECT DISTINCT u.name as name,COALESCE(COUNT(t),0) as value FROM User u join u.travels t GROUP BY u")
	List<Map<Long,Integer>> statistics();
	
	public List<Travel>findByDestination(String destination);
	
	@Query("SELECT t FROM Travel t where CURRENT_DATE BETWEEN t.startDate AND t.endDate")
	List<Travel> getUsersByDate();
	
	@Query("SELECT count(u) FROM Travel u ")	
	int nbTravels();
}
