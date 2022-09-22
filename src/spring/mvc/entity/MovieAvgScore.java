package spring.mvc.entity;

public class MovieAvgScore extends Movie {
	
	private Double avgScore;

	public MovieAvgScore() {
		
	}

	public MovieAvgScore(Integer movieId, String title, Integer year, String director, Double avgScore) {
		super(movieId, title, year, director);
		this.avgScore=avgScore;
		
	}

	@Override
	public String toString() {
		return "MovieAvgScore [avgScore=" + avgScore + "]";
	}
	
	

	
	

}
