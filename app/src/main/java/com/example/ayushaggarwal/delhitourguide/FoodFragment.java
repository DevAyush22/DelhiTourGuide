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
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.vault_cafe), getString(R.string.vault_cafe_desc), R.drawable.vault_cafe));
        words.add(new Word(getString(R.string.tamahsa), getString(R.string.tamasha_desc), R.drawable.tamasha));
        words.add(new Word(getString(R.string.big_yellow_door), getString(R.string.big_yellow_door_desc), R.drawable.big_yellow_door));
        words.add(new Word(getString(R.string.ampm_cafe), getString(R.string.ampm_cafe_desc), R.drawable.ampm_cafe));
        words.add(new Word(getString(R.string.barbeque_nation), getString(R.string.barbeque_nation_desc), R.drawable.barbeque_nation));
        words.add(new Word(getString(R.string.kake_di_hatti), getString(R.string.kake_di_hatti_desc), R.drawable.kake_di_hatti));
        words.add(new Word(getString(R.string.barracks), getString(R.string.barracks_desc), R.drawable.barracks));
        words.add(new Word(getString(R.string.bukhara), getString(R.string.bukhara_desc), R.drawable.bukhara));
        words.add(new Word(getString(R.string.billus_hut), getString(R.string.billus_hut_desc), R.drawable.billus_hut));
        words.add(new Word(getString(R.string.masaba), getString(R.string.masaba_desc), R.drawable.masaba));
        words.add(new Word(getString(R.string.old_world_charm), getString(R.string.old_world_charm_desc), R.drawable.old_world_charm));

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
