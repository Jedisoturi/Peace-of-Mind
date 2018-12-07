package theryhma.sovellus.views.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.views.ButtonFragment;
import theryhma.sovellus.views.DebugQuestionResults;
import theryhma.sovellus.views.DemoFragment;
import theryhma.sovellus.views.GraphFragment;
import theryhma.sovellus.views.QuestionFragment;

public class QuestionFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public QuestionFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (false) {
            DemoFragment demoFragment = new DemoFragment();
            return demoFragment;
        } else {
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i);
            questionFragment.setArguments(bundle);
            return questionFragment;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
