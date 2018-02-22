package jansen.thomas.friendsr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friends.add(jon);
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridview = (GridView) findViewById(R.id.gridLayoutProfiles);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new GridItemClickListener());
    }


    ArrayList<Friend> friends = new ArrayList<>();
    Friend jon = new Friend("Jon", "I know nothing", R.drawable.jon);
    Friend arya = new Friend("Arya", "All men must die", R.drawable.arya);
    Friend cersei = new Friend("Cersei", "Kill them all!", R.drawable.cersei);
    Friend daenerys = new Friend("Daenerys", "Daenerys Stormborn of the House Targaryen, " +
            "First of Her Name, the Unburnt, Queen of the Andals and the First Men, Khaleesi of the " +
            "Great Grass Sea, Breaker of Chains, and Mother of Dragons", R.drawable.daenerys);
    Friend jaime = new Friend("Jaime", "The things I do for love", R.drawable.jaime);
    Friend jorah = new Friend("Jorah", "I vow to serve you, to obey you, to die for you " +
            "if need be", R.drawable.jorah);
    Friend margaery = new Friend("Margaery", "One of my husbands preferred the company " +
            "of men and was stabbed through the heart. Another was happiest torturing animals and " +
            "was poisoned at our wedding feast. I must be cursed”", R.drawable.margaery);
    Friend melisandre = new Friend("Melisandre", "For the night is dark and full " +
            "of terror", R.drawable.melisandre);
    Friend sansa = new Friend("Sansa", "Winter is coming", R.drawable.sansa);
    Friend tyrion = new Friend("Tyrion", "Once you’ve accepted your flaws, no one can use them against you", R.drawable.tyrion);

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
