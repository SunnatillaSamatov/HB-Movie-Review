package spring.mvc.testdb;



import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import spring.mvc.entity.Movie;
import spring.mvc.entity.MovieAvgScore;
import spring.mvc.entity.Rating;
import spring.mvc.entity.Reviewer;
import spring.mvc.entity.ReviewerScoreAndComment;



public class AddreviewerForMovieDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Reviewer.class)
                                .addAnnotatedClass(Movie.class)
                                .addAnnotatedClass(Rating.class)
                                .addAnnotatedClass(MovieAvgScore.class)
                                .addAnnotatedClass(ReviewerScoreAndComment.class)
                                .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		EntityManager entityManager = null  ;
		
		try {
		
			// start transaction 
			session.beginTransaction();
				
			
   /*			
		 int id=104;
		 Double avgStar = (Double) session.createQuery("SELECT avg(stars) from Rating where movieId= :param1")
				          .setParameter("param1",id)
				          .getSingleResult();
			
		 System.out.println(avgStar);
		 
	*/	 	
		/*
			Query query = session.createSQLQuery("CALL get_movies()").addEntity(Movie.class);
			List<Movie> allFoos = query.list();
			System.out.println(allFoos);
		*/	
		
		/*	
			int id=104;	
			Query query = session.createSQLQuery("CALL get_reviewers(:fooName)")
					  
					  .addEntity(Reviewer.class)
					  
					  .setParameter("fooName",id);
			List<Reviewer> allFoos = query.list();
			System.out.println(allFoos);
		*/	
		/*	
			int id=104;
			 Double avgStar = (Double) session.createQuery("SELECT avg(stars) from Rating where movieId= :param1")
					          .setParameter("param1",id)
					          .getSingleResult();
				
			 System.out.println(avgStar);
			 
			 Select Reviewer.firstName,Reviewer.secondName From Rating Join Reviewer Where Rating.reviewerId=Reviewer.reviewerId");
					List<Reviewer> allFoos = query.list();
		*/	
			
		/*	
			Query query = session.createQuery("select * "
					+ "from Rating as ra inner join ra.reviewerId "
					+"inner join Reviewer.reviewerId ");
			List<Reviewer> allFoos=query.list();
			System.out.println(allFoos);
			session.getTransaction().commit();
		*/	
			
		/*	
			Query queryy = session.createQuery("select m.movieId, m.title, m.year, m.director "
					+ " from Reviewer r inner join r.movies  m");
			List<Rating> allFos = (List<Rating>)queryy.list();
			System.out.println(allFos);
		*/		
			
			
		//works
			Integer id=101;
			Query query =  session.createNativeQuery("Select re.reviewer_id, re.First_name,\r\n"
					+ "	re.Second_name\r\n"
					+ "from rating as ra \r\n"
					+ "Join reviewer as re\r\n"
					+ "where ra.reviewer_id=re.reviewer_id\r\n"
					+ "and ra.movie_id=?"
					)
					.setParameter(1, id)
                    .addEntity(Reviewer.class);
			
			List<Reviewer> allFoos = query.list();
			System.out.println(allFoos);
	   
	/*		
			int keyword=108;
		        
				Query q = session.createQuery("Select re.reviewerId,re.firstName,"
						+ "	re.secondName"
					
						+ " from Rating as ra"
						+ " Join Reviewer as re"
						+ " where ra.reviewer_id=re.reviewer_id"
						+ " group by ra.movie_id=?");
		        q.setParameter(1, keyword); //etc
		        
		         List<Reviewer> allFoos =  q.getResultList();
					System.out.println(allFoos);
		*/
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	
	}
	
  
	
}
