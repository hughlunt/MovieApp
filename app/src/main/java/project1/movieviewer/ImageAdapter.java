package project1.movieviewer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hugh on 17/09/15.
 */
public class ImageAdapter extends BaseAdapter {

    private static final String LOG_TAG = ImageAdapter.class.getSimpleName();

    private Context mContext;
    private final int mWidth;
    private final int mHeight;

    private List<Movie> movies;

    public ImageAdapter(Context c, List<Movie> movies) {
        this.mContext = c;
        this.movies = movies;
        mWidth = Math.round(mContext.getResources().getDimension(R.dimen.poster_width_small));
        mHeight = Math.round(mContext.getResources().getDimension(R.dimen.poster_height_small));
    }

    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }

    public void add(Movie movie) {
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void addAll(List<Movie> movieList) {
        movies.addAll(movieList);
        notifyDataSetChanged();
    }

    public int getCount() {
        return movies.size();
    }

    public Object getItem(int position) {
        return movies.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // Create an ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mWidth, mHeight));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }
        Movie item = (Movie) getItem(position);
        StringBuilder sb = new StringBuilder();
        sb.append(mContext.getString(R.string.icon_path));
        sb.append(item.getPosterPath());
        Picasso.with(mContext).load(sb.toString()).into(imageView);
        return imageView;
    }
}
