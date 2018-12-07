package theryhma.sovellus.views.tipoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayConstants;

public class TipDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);

        //TipOfTheDayConstants.getTips();

        Bundle b = getIntent().getExtras();
        int i = b.getInt("showtips", 0);

        TextView tipTitle = findViewById(R.id.tipTitle);
        TextView tip = findViewById(R.id.textViewTip);

        TipOfTheDay tipOfTheDay = TipOfTheDayConstants.getTips() .get(i);

        tipTitle.setText(tipOfTheDay.getTitle());
        tip.setText(tipOfTheDay.getText());
    }
}
