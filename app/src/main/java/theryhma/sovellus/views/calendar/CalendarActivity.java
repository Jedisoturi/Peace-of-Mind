package theryhma.sovellus.views.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.views.calendardetails.CalendarDetailsActivity;
/** This class includes the main code for the Calendar activity.*/
public class CalendarActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_YEAR = "year";
    public static final String EXTRA_KEY_MONTH = "month";
    public static final String EXTRA_KEY_DAYOFMONTH = "dayOfMonth";

    /** This method includes the things happening when the activity is opened.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                goToDetails(year, month, dayOfMonth);
            }
        });

    }

    private void goToDetails(int y, int m , int d) {
        Intent calendarDetailIntent = new Intent(this, CalendarDetailsActivity.class);
        // put the date selected as extra
        calendarDetailIntent.putExtra(EXTRA_KEY_YEAR, y);
        calendarDetailIntent.putExtra(EXTRA_KEY_MONTH, m);
        calendarDetailIntent.putExtra(EXTRA_KEY_DAYOFMONTH, d);
        startActivity(calendarDetailIntent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }
}
