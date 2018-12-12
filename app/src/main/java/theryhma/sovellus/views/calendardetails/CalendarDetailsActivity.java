package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.GregorianCalendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.R;
import theryhma.sovellus.state.State;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.views.calendar.CalendarActivity;

public class CalendarDetailsActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int dayOfMonth;
    public Status status;

    private ViewPager viewPager;
    private CalendarDetailsCollectionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_details);

        Intent intent = getIntent();
        year = intent.getIntExtra(CalendarActivity.EXTRA_KEY_YEAR, 2018);
        month = intent.getIntExtra(CalendarActivity.EXTRA_KEY_MONTH, 1);
        dayOfMonth = intent.getIntExtra(CalendarActivity.EXTRA_KEY_DAYOFMONTH, 1);

        status = GlobalModel.getInstance().getStatus(year, month, dayOfMonth);
        if (status == null) {
            status = new Status(new GregorianCalendar(year, month, dayOfMonth).getTime(), new State(), new InstructionContainer());
            GlobalModel.getInstance().getStatuses().add(status);
        }


        viewPager = findViewById(R.id.pager);
        adapter = new CalendarDetailsCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);



        /*TextView textViewYear = findViewById(R.id.textViewYear);
        textViewYear.setText(Integer.toString(year));
        TextView textViewMonth = findViewById(R.id.textViewMonth);
        textViewMonth.setText(Integer.toString(month));
        TextView textViewDayOfMonth = findViewById(R.id.textViewDay);
        textViewDayOfMonth.setText(Integer.toString(dayOfMonth));

        for (Status s : GlobalModel.getInstance().getStatuses()) {
            Log.d("tulokset", s.toString());
        }*/

    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }

}
