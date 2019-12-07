package com.htet.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView gridView;
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-9355307986593731~8329454923");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        gridView = findViewById(R.id.gvMovie);
        clsMoiveModel movieModel1 = new clsMoiveModel();
        movieModel1.MovieImageLink="https://upload.wikimedia.org/wikipedia/en/thumb/4/4d/The_Tale_of_Nokdu.jpg/250px-The_Tale_of_Nokdu.jpg";
        movieModel1.MovieName="Tale of Nokdu";

        clsMoiveModel movieModel2=new clsMoiveModel();
        movieModel2.MovieImageLink="https://upload.wikimedia.org/wikipedia/en/6/67/Melting_Me_Softly.jpg";
        movieModel2.MovieName="Melting me Softly";


        ArrayList<clsMoiveModel> movieModels=new ArrayList<clsMoiveModel>();
        movieModels.add(movieModel1);
        movieModels.add(movieModel2);

        MovieAdapter adapter = new MovieAdapter(movieModels);
        gridView.setAdapter(adapter);


    }

    private class MovieAdapter extends BaseAdapter
    {
        ArrayList<clsMoiveModel> moiveModels= new ArrayList<clsMoiveModel>();

        public MovieAdapter(ArrayList<clsMoiveModel> moiveModels) {
            this.moiveModels = moiveModels;
        }

        @Override
        public int getCount() {
            return moiveModels.size();
        }

        @Override
        public Object getItem(int position) {
            return moiveModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= getLayoutInflater();
            View view = inflater.inflate(R.layout.movie_image_view, null);
            final clsMoiveModel moviemodel = moiveModels.get(position);
            ImageView imageView = view.findViewById(R.id.movieimage);
            TextView textView = view.findViewById(R.id.moviename);
            Glide.with(getApplicationContext()).load(moviemodel.MovieImageLink).into(imageView);

            textView.setText(moviemodel.MovieName);
            return view;
        }
    }
}
