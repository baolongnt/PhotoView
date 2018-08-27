package uk.co.senab.photoview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Image adapter
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    Listener mListener;
    boolean zoomable;

    public ImageAdapter(Listener listener) {
        this(listener, false);
    }

    public ImageAdapter(Listener mListener, boolean zoomable) {
        this.mListener = mListener;
        this.zoomable = zoomable;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageViewHolder holder = zoomable
                                 ? ZoomableImageViewHolder.inflate(parent)
                                 : ImageViewHolder.inflate(parent);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public interface Listener {
        void onImageClicked(View view);
    }
}
