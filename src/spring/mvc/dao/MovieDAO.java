package spring.mvc.dao;

import java.util.List;

import spring.mvc.entity.Movie;
import spring.mvc.entity.Reviewer;

public interface MovieDAO {

	public List<Movie> getMovies();

	
}
