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
        if (Constant.DEBUG_QUESTIONNAIRE && i==1) {
            DemoFragment demoFragment = new DemoFragment();
            return demoFragment;
        } else if (Constant.DEBUG_GRAPH) {
            GraphFragment graphFragment = new GraphFragment();
            Bundle bundle = new Bundle();

            graphFragment.setArguments(bundle);
            return graphFragment;
        } else if (Constant.DEBUG_QUESTIONNAIRE && i==6) {
            DebugQuestionResults debugQuestionResults = new DebugQuestionResults();
            Bundle bundle = new Bundle();

            debugQuestionResults.setArguments(bundle);
            return debugQuestionResults;
        } else if (Constant.DEBUG_QUESTIONNAIRE) {
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i - 2);
            questionFragment.setArguments(bundle);
            return questionFragment;
        }
        else {
            ButtonFragment buttonFragment = new ButtonFragment();
            Bundle bundle = new Bundle();
            buttonFragment.setArguments(bundle);
            return buttonFragment;
        }
    }

    @Override
    public int getCount() {
        if (Constant.DEBUG_QUESTIONNAIRE) {
            return 6;
        } else if(Constant.DEBUG_GRAPH){
            return 1;
        } else {
            return 100;
        }
    }
}
