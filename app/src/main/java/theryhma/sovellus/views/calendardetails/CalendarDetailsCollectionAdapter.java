package theryhma.sovellus.views.calendardetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import theryhma.sovellus.views.questions.QuestionFragment;
/** This class includes the adapter used in calendar details view*/
public class CalendarDetailsCollectionAdapter extends FragmentStatePagerAdapter {

    public CalendarDetailsCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            StateFragment stateFragment = new StateFragment();
            return stateFragment;
        } else if (i == 1) {
            InstructionFragment instructionFragment = new InstructionFragment();
            return instructionFragment;
        } else {
            TextFragment textFragment = new TextFragment();
            return textFragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
