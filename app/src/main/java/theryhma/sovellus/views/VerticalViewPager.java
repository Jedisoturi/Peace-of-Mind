package theryhma.sovellus.views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.MainActivity;
import theryhma.sovellus.R;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // The majority of the magic happens here
        setPageTransformer(true, new VerticalPageTransformer());
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            //view.setTranslationX(-position*view.getWidth()); // This counteracts the normal transition effect
            if (position < -1){    // [-Infinity,-1)
                // This page is way off-screen to the left.
                //view.setAlpha(0);
            }
            else if (position <= 0){    // [-1,0] Pienempi indeksi
                // This is the top page (index is lower)
                if (view.getId() == R.id.gif) {
                    GlobalModel.getInstance().setCurrentPage(1);
                    view.setTranslationX(-position*view.getWidth());
                    float yPosition = position * view.getHeight() ;
                    view.setTranslationY(yPosition);
                    view.setAlpha(1-Math.abs(position));
                } else {
                    GlobalModel.getInstance().setCurrentPage(0);
                }

            }
            else if (position <= 1){    // (0,1] Suurempi indeksi
                // This is the bottom page (index is higher)
                //int page = ;
                if (GlobalModel.getInstance().getCurrentPage() == 1) {
                    view.setTranslationX(-position*view.getWidth());
                }
                // Do nothing
            }
            else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                //view.setAlpha(0);

            }
        }
    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    /*private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev){
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev); // return touch coordinates to original reference frame for any child views
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
    */
}
