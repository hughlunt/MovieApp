package project1.movieviewer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private Movie movie;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if (intent != null && intent.hasExtra(intent.EXTRA_TEXT)) {
            movie = (Movie) intent.getSerializableExtra(intent.EXTRA_TEXT);

            // Set title
            ((TextView) rootView.findViewById(R.id.detail_title)).
            setText(movie.getTitle());

            // Set plot
            ((TextView) rootView.findViewById(R.id.detail_date)).setText(movie.getOverview());

            // Set user rating
            double rating = movie.getUserRating();
            ((TextView) rootView.findViewById(R.id.detail_userRating)).setText(String.valueOf(rating) + "/10");

            // Set release date
            String date = movie.getReleaseDate();
            String year = date.substring(0, 4);
            ((TextView) rootView.findViewById(R.id.detail_date)).setText(year);

            // Set image icon
            StringBuilder sb = new StringBuilder();
            sb.append(getActivity().getString(R.string.icon_path));
            sb.append(movie.getPosterPath());
            ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_icon);
            Picasso.with(getActivity()).load(sb.toString()).into(imageView);

            // Set synopsis
            ((TextView) rootView.findViewById(R.id.detail_plot)).setText(movie.getOverview());
        }
        return rootView;
    }
}
