package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query("SELECT c.user.id, COUNT(c.user) FROM Comment AS c WHERE dateComment >= :startDate AND dateComment <= :endDate GROUP BY c.user ORDER BY COUNT(c.user) DESC")
	List<Object[]> countTotalCommentsByMonth(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
