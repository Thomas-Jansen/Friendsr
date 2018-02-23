package jansen.thomas.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
//  Initiate friend
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//      receive intent from Main and retrieve Friend
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        String name = retrievedFriend.getName();
//      check Shared preferences for changes in rating or bio and changes their values if necessary
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float stored_rating = prefs.getFloat("rating" + name , 0.0f);
        if (stored_rating != 0.0) {
            retrievedFriend.setRating(stored_rating);
        }
        String Bio = prefs.getString("Bio" + name, "DEFAULT");
        if (Bio != "") {
            retrievedFriend.setBio(Bio);
        }

//      Get all other variables, their corresponding views and link them
        String bio = retrievedFriend.getBio();
        int fotoid = retrievedFriend.getDrawableId();
        float rated = retrievedFriend.getRating();
        TextView textViewname = findViewById(R.id.textViewName2);
        TextView textViewbio = findViewById(R.id.editTextBio);
        ImageView imageViewface = findViewById(R.id.imageViewFace2);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBarFriend);
        textViewname.setText(name);
        textViewbio.setText(bio);
        imageViewface.setImageResource(fotoid);
        ratingbar.setRating(rated);
//      Set listeners to RatingsBar and TextEdit for bio
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());
        textViewbio.addTextChangedListener(new TextChangedListener());


    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
//      Register a change in rating and safe the value in SharedPreferences
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            String name = retrievedFriend.getName();
            editor.putFloat("rating" + name , v);
            editor.apply();
        }
    }

    private class TextChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

//      Register a change in bio after changing the text and safe the value in SharedPreferences
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String newBio = charSequence.toString();
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            String name = retrievedFriend.getName();
            editor.putString("Bio" + name , newBio);
            editor.apply();
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    }
}
