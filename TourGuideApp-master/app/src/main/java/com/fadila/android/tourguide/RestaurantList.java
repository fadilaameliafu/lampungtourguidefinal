package com.fadila.android.tourguide;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class RestaurantList extends ArrayAdapter<dbfirebase> {
    private Activity context;
    List<dbfirebase> items;


    public RestaurantList(Activity context, List<dbfirebase> items) {
        super(context, R.layout.single_restaurant_view, items);
        this.context = context;
        this.items = items;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.single_restaurant_view, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.text_view0);
        TextView textViewCat = (TextView) listViewItem.findViewById(R.id.text_view);
        TextView textViewAdr = (TextView) listViewItem.findViewById(R.id.text_view_2);
        TextView textViewMri = (TextView) listViewItem.findViewById(R.id.text_view_3);

        dbfirebase item = items.get(position);
        textViewName.setText(item.getCategory());
        textViewCat.setText(item.getName());
        textViewCat.setText(item.getAddress());
        textViewCat.setText(item.getMoreInfo());


        return listViewItem;
    }

}
