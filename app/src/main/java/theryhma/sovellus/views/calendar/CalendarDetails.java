package theryhma.sovellus.views.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import theryhma.sovellus.R;

public class CalendarDetails extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_details);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        TextView textViewDate = findViewById(R.id.textViewYear);
        textViewDate.setText(message);



    }
}
