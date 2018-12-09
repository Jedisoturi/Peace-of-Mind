package theryhma.sovellus.views.calendar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.time.Year;

import androidx.annotation.NonNull;
import theryhma.sovellus.R;
import theryhma.sovellus.question.Questionnaire;

public class CalendarActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_YEAR = "year";
    public static final String EXTRA_KEY_MONTH = "month";
    public static final String EXTRA_KEY_DAYOFMONTH = "dayOfMonth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), +dayOfMonth, 0).show();
                goToDetails(year, month + 1, dayOfMonth);
            }
        });

    }
    // todo: combine this method with question fragment's go to details
    private void goToDetails(int y, int m , int d) {
        Intent calendarDetailIntent = new Intent(this, CalendarDetails.class);

        calendarDetailIntent.putExtra(EXTRA_KEY_YEAR, y);
        calendarDetailIntent.putExtra(EXTRA_KEY_MONTH, m);
        calendarDetailIntent.putExtra(EXTRA_KEY_DAYOFMONTH, d);
        //Log.d("TÄMÄ TESTAUS JEE JEE", Integer.toString(y) + " " + Integer.toString(m) + " " + Integer.toString(d));
        startActivity(calendarDetailIntent);
    }
}
