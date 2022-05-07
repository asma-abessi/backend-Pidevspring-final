package tn.esprit.spring.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Opportunity;
import tn.esprit.spring.entities.TypeOpportunity;
import tn.esprit.spring.entities.User;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, Long> ,JpaRepository<Opportunity, Long> {

	@Query("SELECT DISTINCT u.idOpportunity as id , t.name as name,COALESCE(COUNT(t),0) as value FROM Opportunity u join u.user t GROUP BY t")
	List<Map<Long,Integer>> statisticsopp();

	@Query("SELECT count(u) FROM Opportunity u ")	
	int nbOpportunities();

}
