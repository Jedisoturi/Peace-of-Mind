package theryhma.sovellus.views.tipoftheday;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayConstants;
import theryhma.sovellus.tools.Constant;

/**
 * Show tips in a listView
 */
public class TipListActivity extends AppCompatActivity {
    private ListView tipsList;
    private ArrayList<TipOfTheDay> listOfTips;

    private Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        thisActivity = this;    // get this activity, used in click listener

        listOfTips = TipOfTheDayConstants.createArray();

        // create listView
        tipsList = findViewById(R.id.tipsListView);
        tipsList.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        TipOfTheDayConstants.createArray())
        );
        // set a click listener
        tipsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.d("supersovellus", "onItemClick(" + i + ")");
                Intent tipDetails = new Intent(thisActivity, TipDetailsActivity.class);
                tipDetails.putExtra("showtips", i);
                startActivity(tipDetails);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }
}
