import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.phillippascual.data.MovieData;
import com.phillippascual.util.Movie;

public class MovieDataTest {
	Movie testMovie;
	
	@Before
	public void setupTest() {
		testMovie = new Movie("test", "test", "test");
	}
	
	@Test
	public void addMovieDataTest_ArrayListSizeAndInventoryIncrease() {
		MovieData.addMovieData(testMovie);
		MovieData.addInventory("test", 1);
		assertTrue(MovieData.getMovies().size() == 1);
		assertTrue(testMovie.getNumberInStock() == 2);
	}
}
