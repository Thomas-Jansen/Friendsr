package jansen.thomas.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FriendsAdapter extends ArrayAdapter<Friend> {

    ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        Friend currentFriend = friends.get(position);
        String name = currentFriend.getName();
        int fotoid = currentFriend.getDrawableId();
        TextView textViewname = convertView.findViewById(R.id.textViewName);
        ImageView imageViewface = convertView.findViewById(R.id.ImageViewFace);
        textViewname.setText(name);
        imageViewface.setImageResource(fotoid);
        return convertView;
    }
}
