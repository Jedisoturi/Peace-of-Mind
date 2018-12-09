package theryhma.sovellus.views.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import theryhma.sovellus.R;

public class CalendarDetails extends AppCompatActivity {
    private int year;
    private int month;
    private int dayOfMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_details);

        Intent intent = getIntent();
        year = intent.getIntExtra(CalendarActivity.EXTRA_KEY_YEAR, 2018);
        month = intent.getIntExtra(CalendarActivity.EXTRA_KEY_MONTH, 1);
        dayOfMonth = intent.getIntExtra(CalendarActivity.EXTRA_KEY_DAYOFMONTH, 1);

        TextView textViewYear = findViewById(R.id.textViewYear);
        textViewYear.setText(Integer.toString(year));
        TextView textViewMonth = findViewById(R.id.textViewMonth);
        textViewMonth.setText(Integer.toString(month));
        TextView textViewDayOfMonth = findViewById(R.id.textViewDay);
        textViewDayOfMonth.setText(Integer.toString(dayOfMonth));



    }
}
