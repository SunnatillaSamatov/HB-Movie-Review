package spring.mvc.dao;

import java.util.List;

import spring.mvc.entity.Reviewer;

public interface ReviewerDAO {

	public void saveReviewer(Reviewer theReviewer);

	
	public List<Reviewer> getreviewerScoreComment(int id);
	
}
