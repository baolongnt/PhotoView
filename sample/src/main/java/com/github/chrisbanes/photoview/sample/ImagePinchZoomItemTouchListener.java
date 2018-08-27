package com.github.chrisbanes.photoview.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * RecyclerView eats touch events preventing pinch zoom on images. This <code>OnItemTouchListener</code> passes on these
 * events to any <code>ImageView</code> child.
 */
public class ImagePinchZoomItemTouchListener implements RecyclerView.OnItemTouchListener, ScaleGestureDetector.OnScaleGestureListener {

    private WeakReference<ImageView> imageViewWeakRef;
    private boolean isScaleInprogress;
    private ScaleGestureDetector scaleGestureDetector;

    public ImagePinchZoomItemTouchListener(@NonNull Context context) {
        scaleGestureDetector = new ScaleGestureDetector(context, this);
    }

    // region RecyclerView.OnItemTouchListener

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (!(child instanceof ImageView)) {
            return false;
        }

        imageViewWeakRef = new WeakReference<>((ImageView) child);
        scaleGestureDetector.onTouchEvent(e);
        return isScaleInprogress;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        ImageView imageView = imageViewWeakRef.get();
        if (isScaleInprogress
            && imageView != null) {
            imageView.onTouchEvent(e);
        }
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    // endregion

    // region ScaleGestureDetector.OnScaleGestureListener

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        isScaleInprogress = true;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        isScaleInprogress = false;
        imageViewWeakRef = null;
    }

    // endregion
}
