package theryhma.sovellus.views.calendar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import theryhma.sovellus.R;

public class CalendarActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.sovellus.MESSAGE";

    CalendarView calendarView;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        v = findViewById(R.id.kalenteri);


        calendarView = (CalendarView)findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), +dayOfMonth, 0).show();


                    gotToActivity(year, month + 1, dayOfMonth);
            }
        });

    }

    public void gotToActivity(int y, int m , int d) {
        Intent calendarDetailIntent = new Intent(this, CalendarDetails.class);
        Intent message = calendarDetailIntent;
      //  calendarDetailIntent.putExtra(EXTRA_MESSAGE, message);
        Log.d("TÄMÄ TESTAUS JEE JEE", Integer.toString(y) + " " + Integer.toString(m) + " " + Integer.toString(d));
        startActivity(calendarDetailIntent);
    }
}
