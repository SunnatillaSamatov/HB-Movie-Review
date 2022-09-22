package spring.mvc.entity;

public class ReviewerScoreAndComment extends Reviewer {
	
	private Integer score;
	private String comment;
	
	public ReviewerScoreAndComment(){
		
	}
	
	public ReviewerScoreAndComment(
			Integer reviewerId, String firstName, 
			String secondName, Integer score, String comment) {
		super(reviewerId, firstName, secondName );
		this.score=score;
		this.comment=comment;
	}

}
