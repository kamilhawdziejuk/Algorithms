package Common;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class MoviesStartTimes {

	public static class Movie
	{
		public Movie()
		{
			
		}
		int priority;
		int startTime;
	};
	
	public static String run(int nr_movies, int[] priorities, int[] start_times) {

		List<Movie> movies = new LinkedList<Movie>();	
	
		for (int i = 0; i < nr_movies; i++)
		{
			Movie mov = new Movie();
			mov.priority = priorities[i];
			mov.startTime = start_times[i];
			movies.add(mov);
		}
		
		movies.sort(new Comparator<Movie>() 
				{
			@Override
			public int compare(Movie arg0, Movie arg1) {
				if (arg1.priority < arg0.priority)
				{
					return -1;
				}
				else if (arg1.priority > arg0.priority)
				{
					return 1;
				}
				else if (arg1.startTime < arg0.startTime)
				{
					return -1;
				}
				else if (arg1.startTime > arg0.startTime)
				{
					return 1;
				}
				return 0;
			}
		});
		
		int[] starts = new int[24];
		for (int i = 0; i < 24; i++) starts[i] = 0;
		
		for (Movie mov : movies)
		{
			int st = mov.startTime;
			if (starts[st] == 0 && starts[st+1] == 0)
			{
				starts[st] = mov.priority;
				starts[st+1] = mov.priority;				
			}
		}
		
		String movies_list_hour = "";
		
		for (int i = 0; i <= 22; i++)
		{
			if (starts[i] > 0)
			{
				if (movies_list_hour == "")
				{
					movies_list_hour = movies_list_hour + i;					
				}
				else
				{
					movies_list_hour = movies_list_hour + "," + i;					
				}
				starts[i+1] = 0;
			}
		}
		
		return movies_list_hour;
	}
}
