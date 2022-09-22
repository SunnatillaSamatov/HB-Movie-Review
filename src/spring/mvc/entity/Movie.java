package spring.mvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private Integer movieId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="director")
	private String director;
	
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinTable(
			name="rating",
			joinColumns=@JoinColumn(name="movie_id"),
			inverseJoinColumns=@JoinColumn(name="reviewer_id")
			)
	private List<Reviewer> reviewers;
	
	public Movie() {
		
	}

	public Movie(Integer movieId, String title, Integer year, String director) {
		
		this.movieId = movieId;
		this.title = title;
		this.year = year;
		this.director = director;
	}
	
	

	

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Reviewer> getReviewers(){
		return reviewers;
	}
	
    public void addReviewer(Reviewer reviewer) {
		
		if(reviewers ==null) {
			reviewers = new ArrayList<>();
			
		}
		
		reviewers.add(reviewer);
	}

    
	

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", director=" + director + "]";
	}
	
	
	
}
