package theryhma.sovellus.views.start;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Start activitys viewpager
 */
public class StartViewPager extends ViewPager {

    public StartViewPager(Context context) {
        super(context);
        init();
    }

    public StartViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new StartPageTransformer());
        setOffscreenPageLimit(5);   // all views are loaded at start
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class StartPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            view.setTranslationX(-position*view.getWidth()); // This counteracts the normal transition effect
            if (position < -1){    // [-Infinity,-1)
                // This page is way off-screen to the left.
            }
            else if (position < 0){    // [-1,0]
                // This is the top page (index is lower)
                // Make the top fragment (gif) to move away from the top and fade out
                view.setTranslationX(-position * view.getWidth());
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);
                view.setAlpha(1 - Math.abs(position));
            }
            else if (position < 1){    // (0,1]
                // This is the bottom page (index is higher)
            }
            else {    // (1,+Infinity]
                // This page is way off-screen to the right.
            }
        }
    }

    /**
     * Swaps the X and Y coordinates of the touch event
     */
    private MotionEvent swapXY(MotionEvent ev) {
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

}
