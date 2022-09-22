package spring.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.dao.MovieDAO;
import spring.mvc.dao.ReviewerDAO;
import spring.mvc.entity.Movie;
import spring.mvc.entity.Reviewer;

@Controller
@RequestMapping("/review")
public class MovieReviewController  {
	
	@Autowired
	private MovieDAO moviedao;
	
	@Autowired
	private ReviewerDAO reviewerdao;
	
	@RequestMapping("/movielist")
	public String listMovies(Model themodel) {
		
		// get customers from the dao
		List<Movie> Movies = moviedao.getMovies();
		
		// add the customers to the model
		themodel.addAttribute("movies",Movies);
		
		
		return "list-movie";
	}
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model theModel) {
		
		Reviewer theReviewer =new Reviewer ();
		theModel.addAttribute("reviewer",theReviewer);
		
		return "reviewer-form";
	}
	
	
	
	@PostMapping("/saveReviewer")
	public String saveReviewer(@ModelAttribute("reviewer") Reviewer theReviewer ) {
		
		// save the customer using our service
		reviewerdao.saveReviewer(theReviewer);
		return "redirect:/review/movielist";
	}
	
	@RequestMapping("/listReviewrScoreComment")
	public String listReviewrScoreComment(@RequestParam("movieId")  Integer movieId,Model themodel) {
		
		//Integer movie_id = Integer. parseInt(movieId);
		List<Reviewer> reviewers = reviewerdao.getreviewerScoreComment(movieId);
		
		
		themodel.addAttribute("reviewerScoreComment",reviewers);
		
		
		return "movie-reviewerList";
	}
	
	
	
	
}
