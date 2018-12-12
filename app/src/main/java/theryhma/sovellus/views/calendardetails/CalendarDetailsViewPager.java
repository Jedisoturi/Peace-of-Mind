package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
/** This class includes the code for CalendarDetails viewPager.*/
public class CalendarDetailsViewPager extends ViewPager {

    public CalendarDetailsViewPager(Context context) {
        super(context);
        init();
    }

    public CalendarDetailsViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new CalendarDetailsPageTransformer());
        setOffscreenPageLimit(3);   // load all pages at start
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class CalendarDetailsPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position < -1){    // [-Infinity,-1)
                // do not change
            }
            else if (position < 0){    // [-1,0]
                // do not change
            }
            else if (position < 1){    // (0,1]
                // do not change
            }
            else {    // (1,+Infinity]
                // do not change
            }
        }
    }
}
