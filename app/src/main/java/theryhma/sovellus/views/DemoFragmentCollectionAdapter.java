package theryhma.sovellus.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.status.StatusTools;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.tools.Maths;

public class DemoFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public DemoFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        i = i + 1;
        if (i==1) {
            DemoFragment demoFragment = new DemoFragment();
            return demoFragment;
        } else if (Constant.DEBUG_QUESTIONNAIRE && i==6) {
            DebugQuestionResults debugQuestionResults = new DebugQuestionResults();
            Bundle bundle = new Bundle();

            debugQuestionResults.setArguments(bundle);
            return debugQuestionResults;
        } else if (Constant.DEBUG_QUESTIONNAIRE){
            QuestionFragment questionFragment = new QuestionFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i-2);
            questionFragment.setArguments(bundle);
            return questionFragment;
        } else if (Constant.DEBUG_STATUS) {
            ButtonFragment buttonFragment = new ButtonFragment();
            Bundle bundle = new Bundle();
            /*
            ArrayList<Double> indices = new ArrayList<>();
            indices.add(1.0);
            indices.add(0.5);
            indices.add(0.0);
            indices.add(-0.5);
            indices.add(-1.0);
            double e = indices.get(Maths.getRandomIntegerBetweenRange(0, 4));
            double m = indices.get(Maths.getRandomIntegerBetweenRange(0, 4));
            double a = indices.get(Maths.getRandomIntegerBetweenRange(0, 4));
            double s = indices.get(Maths.getRandomIntegerBetweenRange(0, 4));
            Status status = new Status(e, m, a, s);
            GlobalModel.getInstance().addStatuses(status);
            Status meanStatus = StatusTools.getNonZeroMean(GlobalModel.getInstance().getStatuses());
            bundle.putString("status", status.toString());
            bundle.putString("mean", meanStatus.toString());
            ArrayList<Status> list = GlobalModel.getInstance().getStatuses();
            for (Status stat : list) {
                Log.d("supersovellus", stat.toString());
            }
            Log.d("supersovellus", "mean(" + GlobalModel.getInstance().getStatuses().size() + "):" + meanStatus.toString());
            */
            buttonFragment.setArguments(bundle);
            return buttonFragment;
        } else if (Constant.DEBUG_TIP) {
            ButtonFragment buttonFragment = new ButtonFragment();
            Bundle bundle = new Bundle();

            TipOfTheDay tip = TipOfTheDayGenerator.generate();
            String message = tip.getTitle() + tip.getText();
            bundle.putString("message", message);

            buttonFragment.setArguments(bundle);
            return buttonFragment;
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
        } else {
            return 100;
        }
    }
}
