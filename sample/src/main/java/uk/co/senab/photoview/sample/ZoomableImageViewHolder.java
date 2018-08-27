package uk.co.senab.photoview.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Image in recyclerview
 */
public class ZoomableImageViewHolder extends ImageViewHolder {

    public static ZoomableImageViewHolder inflate(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zoomable_image, parent, false);
        return new ZoomableImageViewHolder(view);
    }

    public ZoomableImageViewHolder(View view) {
        super(view);
    }

}
