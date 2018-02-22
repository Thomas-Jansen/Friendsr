package jansen.thomas.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        String name = retrievedFriend.getName();


        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float stored_rating = prefs.getFloat("rating" + name , 0.0f);
        if (stored_rating != 0.0) {
            retrievedFriend.setRating(stored_rating);
        }

        String bio = retrievedFriend.getBio();
        int fotoid = retrievedFriend.getDrawableId();
        float rated = retrievedFriend.getRating();
        TextView textViewname = findViewById(R.id.textViewName2);
        TextView textViewbio = findViewById(R.id.textViewBio2);
        ImageView imageViewface = findViewById(R.id.imageViewFace2);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBarFriend);
        textViewname.setText(name);
        textViewbio.setText(bio);
        imageViewface.setImageResource(fotoid);
        ratingbar.setRating(rated);

        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            float rating = v;
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            String name = retrievedFriend.getName();
            editor.putFloat("rating" + name , rating);
            editor.apply();
        }
    }
}
