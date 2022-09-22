package spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.Movie;
import spring.mvc.entity.Reviewer;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query 
		Query<Movie> theQuery = currentSession.createQuery("from Movie", Movie.class);
				
		// execute query and result list
		List<Movie> movies = theQuery.getResultList();
				
		System.out.println(movies);
		
		return movies;
	}

	

}
