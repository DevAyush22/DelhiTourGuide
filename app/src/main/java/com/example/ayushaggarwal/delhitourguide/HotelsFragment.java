package com.example.ayushaggarwal.delhitourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.raddison_blu), getString(R.string.raddison_blu_desc), R.drawable.raddison_blu));
        words.add(new Word(getString(R.string.umrao), getString(R.string.umrao_desc), R.drawable.umrao));
        words.add(new Word(getString(R.string.tivoli), getString(R.string.tivoli_desc), R.drawable.tivoli_resort));
        words.add(new Word(getString(R.string.grand_park), getString(R.string.grand_park_desc), R.drawable.grand_park_inn));
        words.add(new Word(getString(R.string.city_park), getString(R.string.city_park_desc), R.drawable.city_park));
        words.add(new Word(getString(R.string.ashok_hotel), getString(R.string.ashok_hotel_desc), R.drawable.ashok_hotel));
        words.add(new Word(getString(R.string.samrat_hotel), getString(R.string.samrat_hotel_desc), R.drawable.samrat_hotel));
        words.add(new Word(getString(R.string.leela_palace), getString(R.string.leela_palace_desc), R.drawable.leela_palace));
        words.add(new Word(getString(R.string.crowne_plaza), getString(R.string.crowne_plaza_desc), R.drawable.crowne_plaza));
        words.add(new Word(getString(R.string.le_meridien), getString(R.string.le_meridien_desc), R.drawable.le_meridien));
        words.add(new Word(getString(R.string.taj_palace), getString(R.string.taj_palace_desc), R.drawable.taj_palace_hotel));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        final WordAdapter adapter = new WordAdapter(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open the location on map when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Find the current item that was clicked on
                Word currentWord = adapter.getItem(position);

                String str_location = currentWord.getPlaceName();
                String map = getString(R.string.map_literal) + str_location + getString(R.string.location_delhi);

                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(map);

                // Create an Intent to map.
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Send the intent to launch a new activity
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}
