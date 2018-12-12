package theryhma.sovellus.views.questions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.R;
import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.state.State;
import theryhma.sovellus.state.StateTools;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.views.calendar.CalendarActivity;
import theryhma.sovellus.views.calendardetails.CalendarDetailsActivity;

/**
 * This activity is for the Questionnaire of five Questions
 */
public class QuestionActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private QuestionFragmentCollectionAdapter adapter;
    private Questionnaire questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionnaire = new Questionnaire();    // initialize questionnaire

        // initialize viewpager
        viewPager = findViewById(R.id.pager);
        adapter = new QuestionFragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    /**
     * Return the current questionnaire
     */
    public Questionnaire getQuestionnaire() {
        return this.questionnaire;
    }

    /**
     * Calculate final state and go to details
     */
    public void done() {
        State state = StateTools.createMeanState(questionnaire.createResultStates());
        Date date = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Status status = GlobalModel.getInstance().getStatus(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        if (status == null) {
            InstructionContainer instructions = new InstructionContainer(state);
            status = new Status(date, state, instructions);
            GlobalModel.getInstance().getStatuses().add(status);
        } else {
            status.update(state);
        }

        goToDetails(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }

    private void goToDetails(int y, int m, int d) {
        Intent calendarDetailIntent = new Intent(this, CalendarDetailsActivity.class);

        // send date data as extra
        calendarDetailIntent.putExtra(CalendarActivity.EXTRA_KEY_YEAR, y);
        calendarDetailIntent.putExtra(CalendarActivity.EXTRA_KEY_MONTH, m);
        calendarDetailIntent.putExtra(CalendarActivity.EXTRA_KEY_DAYOFMONTH, d);
        startActivity(calendarDetailIntent);
        finish();   // close this, because we want to return to the main menu from details
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }
}