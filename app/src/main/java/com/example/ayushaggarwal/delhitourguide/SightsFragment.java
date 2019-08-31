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
public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.india_gate), getString(R.string.india_gate_desc), R.drawable.india_gate));
        words.add(new Word(getString(R.string.red_fort), getString(R.string.red_fort_desc), R.drawable.red_fort));
        words.add(new Word(getString(R.string.qutub_minar), getString(R.string.qutub_minar_desc), R.drawable.qutub_minar));
        words.add(new Word(getString(R.string.lotus_temple), getString(R.string.lotus_temple_desc), R.drawable.lotus_temple));
        words.add(new Word(getString(R.string.akshardham), getString(R.string.akshardham_desc), R.drawable.akshardham_mandir));
        words.add(new Word(getString(R.string.jama_masjid), getString(R.string.jama_masjid_desc), R.drawable.jama_masjid));
        words.add(new Word(getString(R.string.pragati_maidan), getString(R.string.pragati_maidan_desc), R.drawable.pragati_maidan));
        words.add(new Word(getString(R.string.jantar_mantar), getString(R.string.jantar_mantar_desc), R.drawable.jantar_mantar));
        words.add(new Word(getString(R.string.bangla_sahib), getString(R.string.bangla_sahib_desc), R.drawable.bangla_sahib));
        words.add(new Word(getString(R.string.lodi_gardens), getString(R.string.lodi_gardens_desc), R.drawable.lodi_gardens));
        words.add(new Word(getString(R.string.agrasen_baoli), getString(R.string.agrasen_baoli_desc), R.drawable.agrasen_ki_baoli));

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
