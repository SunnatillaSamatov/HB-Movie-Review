package spring.mvc.entity;




public class Rating {
 	
	/**
	 * @Id
	@Column(name="movie_id")
	@Id
	@Column(name="reviewer_id")
	@Column(name="stars")
	@Column(name="comments")
	 */
		

	
	private Integer movieId;
	
	
	private Integer reviewerId;
	
	
	private Integer stars;
	
	
	private String comments;
  
	public Rating() {
		
	}

	public Rating(Integer movieId, Integer reviewerId, Integer stars, String comments) {
		
		this.movieId = movieId;
		this.reviewerId = reviewerId;
		this.stars = stars;
		this.comments = comments;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", reviewerId=" + reviewerId + ", stars=" + stars + ", comments="
				+ comments + "]";
	}
	
  

  
	
}
