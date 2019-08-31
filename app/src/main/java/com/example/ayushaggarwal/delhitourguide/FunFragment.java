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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.adventure_island), getString(R.string.adventure_island_desc), R.drawable.adventure_island));
        words.add(new Word(getString(R.string.smaaash), getString(R.string.smaaash_desc), R.drawable.smaash));
        words.add(new Word(getString(R.string.oysters), getString(R.string.oysters_desc), R.drawable.oysters));
        words.add(new Word(getString(R.string.dilli_haat), getString(R.string.dilli_haat_desc), R.drawable.dilli_haat));
        words.add(new Word(getString(R.string.wow), getString(R.string.wow_desc), R.drawable.worlds_of_wonder));
        words.add(new Word(getString(R.string.kingdom), getString(R.string.kingdom_desc), R.drawable.kingdom_of_dreams));
        words.add(new Word(getString(R.string.bluo), getString(R.string.bluo_desc), R.drawable.bluo));
        words.add(new Word(getString(R.string.central_park), getString(R.string.central_park_desc), R.drawable.central_park));
        words.add(new Word(getString(R.string.iskate), getString(R.string.iskate_desc), R.drawable.iskate));
        words.add(new Word(getString(R.string.mystery_rooms), getString(R.string.mystery_rooms_desc), R.drawable.mystery_rooms));
        words.add(new Word(getString(R.string.zoo), getString(R.string.zoo_desc), R.drawable.national_zoological_park));

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
