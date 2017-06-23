package com.codepath.flicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.flicks.models.Movie;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

//public class MovieDetailsActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_movie_details);
//    }
//}


public class MovieDetailsActivity extends AppCompatActivity {

    // the movie to display
    Movie movie;
//    TextView tvTitle;
//    TextView tvOverview;
//    RatingBar rbVoteAverage;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvOverview) TextView tvOverview;
    @BindView(R.id.rbVoteAverage) RatingBar rbVoteAverage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        //assigning things in here using the findViewById function y'all!!
//        @BindView(R.id.tvTitle) TextView tvTitle;
//        @BindView(R.id.tvOverview) TextView tvOverview;
//        @BindView(R.id.rbVoteAverage) RatingBar rbVoteAverage;

        // tvTitle = (TextView) findViewById(R.id.tvTitle);
        //tvOverview = (TextView) findViewById(R.id.tvOverview);
        //rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);


        // unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));


        // set the title and overview
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);

    }
}

//



//
//    public final static String API_BASE_URL = "https://api.themoviedb.org/3";
//    // the parameter name for the  API key
//    public final static String API_KEY_PARAM = "api_key";
//    //tag for logging this activity
//    public final static String TAG = "MovieListActivity";
