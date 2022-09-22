package spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.Reviewer;

@Repository
public class ReviewerDAOImpl implements ReviewerDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public void saveReviewer(Reviewer theReviewer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theReviewer);
		
	}

	@Override
	@Transactional
	public List<Reviewer> getreviewerScoreComment(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query =  currentSession.createNativeQuery("Select re.reviewer_id, re.First_name,\r\n"
				+ "	re.Second_name\r\n"
				+ "from rating as ra \r\n"
				+ "Join reviewer as re\r\n"
				+ "where ra.reviewer_id=re.reviewer_id\r\n"
				+ "and ra.movie_id=?"
				)
				.setParameter(1, id)
                .addEntity(Reviewer.class);
		
		List<Reviewer> reviewers = query.list();
		System.out.println(reviewers);
		return reviewers;
	}

	
}
