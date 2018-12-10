package theryhma.sovellus.views.debug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;
import theryhma.sovellus.tools.Constant;

public class DemoFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public DemoFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        i = i + 1;
        if (Constant.DEBUG_QUESTIONNAIRE && i==1) {
            DemoFragment demoFragment = new DemoFragment();
            return demoFragment;
        } else if (Constant.DEBUG_GRAPH) {
            GraphFragment graphFragment = new GraphFragment();
            Bundle bundle = new Bundle();

            graphFragment.setArguments(bundle);
            return graphFragment;
        /*} else if (Constant.DEBUG_QUESTIONNAIRE && i==2) {
            DebugQuestionFragment debugQuestion = new DebugQuestionFragment();
            Bundle bundle = new Bundle();

            debugQuestion.setArguments(bundle);
            return debugQuestion;*/
        } else if (Constant.DEBUG_QUESTIONNAIRE && i==6) {
            DebugQuestionResults debugQuestionResults = new DebugQuestionResults();
            Bundle bundle = new Bundle();

            debugQuestionResults.setArguments(bundle);
            return debugQuestionResults;
        } else if (Constant.DEBUG_QUESTIONNAIRE){
            QuestionFragmentOld questionFragmentOld = new QuestionFragmentOld();
            Bundle bundle = new Bundle();

            bundle.putInt("index", i-2);
            questionFragmentOld.setArguments(bundle);
            return questionFragmentOld;
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
            State status = new State(e, m, a, s);
            GlobalModel.getInstance().addStatuses(status);
            State meanStatus = StateTools.getNonZeroMean(GlobalModel.getInstance().getStates());
            bundle.putString("status", status.toString());
            bundle.putString("mean", meanStatus.toString());
            ArrayList<State> list = GlobalModel.getInstance().getStates();
            for (State stat : list) {
                Log.d("supersovellus", stat.toString());
            }
            Log.d("supersovellus", "mean(" + GlobalModel.getInstance().getStates().size() + "):" + meanStatus.toString());
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
        } else if(Constant.DEBUG_GRAPH){
            return 1;
        } else {
            return 100;
        }
    }
}
