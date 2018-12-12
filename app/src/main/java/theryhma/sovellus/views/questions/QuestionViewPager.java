package theryhma.sovellus.views.questions;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Viewpager for the questionnaire
 */
public class QuestionViewPager extends ViewPager {

    public QuestionViewPager(Context context) {
        super(context);
        init();
    }

    public QuestionViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new QuestionPageTransformer());
        setOffscreenPageLimit(5);   // load all pages at start
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class QuestionPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position < -1){    // [-Infinity,-1)
                // do nothing
            }
            else if (position < 0){    // [-1,0]
                // do nothing
            }
            else if (position < 1){    // (0,1]
                // do nothing
            }
            else {    // (1,+Infinity]
                // do nothing
            }
        }
    }
}
