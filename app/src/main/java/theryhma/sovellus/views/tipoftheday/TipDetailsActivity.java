package theryhma.sovellus.views.tipoftheday;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayConstants;
import theryhma.sovellus.tools.Constant;

/**
 * Show the full text of a tip
 */
public class TipDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);

        Bundle b = getIntent().getExtras();
        int i = b.getInt("showtips", 0);

        TipOfTheDay tipOfTheDay = TipOfTheDayConstants.createArray().get(i); // get the tip from tipConstants

        // update ui
        TextView tipTitle = findViewById(R.id.tipTitle);
        TextView tip = findViewById(R.id.textViewTip);
        tipTitle.setText(tipOfTheDay.getTitle());
        tip.setText(tipOfTheDay.getText());
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }
}
