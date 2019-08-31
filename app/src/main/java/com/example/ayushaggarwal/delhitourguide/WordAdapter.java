package com.example.ayushaggarwal.delhitourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {


    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of word objects to display in a list.
     */
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // A ViewHolder keeps references to children views to avoid unnecessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to
            holder = new ViewHolder();

            // Find the TextView in the list_item.xml layout with the ID name_text_view
            holder.nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);

            // Find the TextView in the list_item.xml layout with the ID desc_text_view
            holder.descTextView = (TextView) convertView.findViewById(R.id.desc_text_view);

            // Find the ImageView in the list_item.xml layout with the ID image
            holder.iconView = (ImageView) convertView.findViewById(R.id.image);

            // store the holder with the view.
            convertView.setTag(holder);

        } else {
            // We've just avoided calling findViewById() on resource every time
            // just use the viewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        if (currentWord != null) {
            // Get the name from the current Word object and
            // set this text on the name TextView
            holder.nameTextView.setText(currentWord.getPlaceName());

            // Get the description from the current Word object and
            // set this text on the desc TextView
            holder.descTextView.setText(currentWord.getPlaceDesc());

            // Get the image from the current Word object
            holder.iconView.setImageResource(currentWord.getImageResourceId());
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

    /**
     * ViewHolder class to hold exact set of views
     */
    static class ViewHolder {
        TextView nameTextView;
        TextView descTextView;
        ImageView iconView;
    }

}

