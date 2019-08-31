package com.example.ayushaggarwal.delhitourguide;

/**
 * {@link Word} represents a place that the user wants to travel.
 * It also contains description regarding that place.
 */
public class Word {

    /**
     * Name of place
     */
    private String mPlaceName;

    /**
     * Description regarding place
     */
    private String mPlaceDesc;

    /**
     * Image resource ID for the place
     */
    private int mImageResourceId;

    /**
     * Create a new Word object
     *
     * @param PlaceName       is the name of place user can go-to
     * @param PlaceDesc       is the description regarding that place
     * @param imageResourceId is the drawable resource id for the image associated
     */
    public Word(String PlaceName, String PlaceDesc, int imageResourceId) {
        mPlaceName = PlaceName;
        mPlaceDesc = PlaceDesc;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of place.
     */
    public String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the description of place.
     */
    public String getPlaceDesc() {
        return mPlaceDesc;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
