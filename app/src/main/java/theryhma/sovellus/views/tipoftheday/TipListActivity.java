package theryhma.sovellus.views.tipoftheday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayConstants;

public class TipListActivity extends AppCompatActivity {

    ListView tipsList;
    ArrayList<String> listOfTips;

    private Activity thisAcvitity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        thisAcvitity = this;

        ArrayList<TipOfTheDay> listOfTips = TipOfTheDayConstants.getTips();

        ListView tipsList = findViewById(R.id.tipsListView);
        tipsList.setAdapter(new ArrayAdapter<TipOfTheDay>(this,
                        android.R.layout.simple_list_item_1,
                        TipOfTheDayConstants.getTips())

        );

        tipsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.d("supersovellus", "onItemClick(" + i + ")");
                Intent tipDetails = new Intent(thisAcvitity, TipDetailsActivity.class);
                tipDetails.putExtra("showtips", i);
                startActivity(tipDetails);
            }
        });
    }
}
