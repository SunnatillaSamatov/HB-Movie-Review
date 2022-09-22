package spring.mvc.entity;

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

import org.springframework.data.jpa.repository.Query;

@Entity
public class Reviewer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reviewer_id")
	private Integer reviewerId;
	
	@Column(name="First_name")
	private String firstName;
	
	@Column(name="Second_name")
	private String secondName;
	
	@ManyToMany(cascade= {CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinTable(
			name="rating",
			joinColumns=@JoinColumn(name="reviewer_id"),
			inverseJoinColumns=@JoinColumn(name="movie_id")
			)
	private List<Movie> movies;
	
	
	
	public Reviewer() {
		
	}

	public Reviewer(Integer reviewerId, String firstName, String secondName) {
		
		this.reviewerId = reviewerId;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public List<Movie> getMovies(){
		return movies;
	}

	@Override
	public String toString() {
		return "Reviewer [reviewerId=" + reviewerId + ", firstName=" + firstName + ", secondName=" + secondName + "]";
	}
	
	
	
}
