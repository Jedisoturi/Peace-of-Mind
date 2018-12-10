package theryhma.sovellus.views.stats;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.status.Status;

public class StatActivity extends AppCompatActivity {
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        lineChart = findViewById(R.id.lineChart);

        // creating list of entry<br />
        ArrayList<Status> statuses = GlobalModel.getInstance().getStatuses();
        ArrayList<Status> unsorted = new ArrayList<>();
        for (Status s : statuses) {
            unsorted.add(new Status(s));
        }

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.compareTo(c2);


        for (int i = 0; i < unsorted.size(); i++) {
            
        }
        ArrayList<Status> sorted = new ArrayList<>();

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4f));
        entries.add(new Entry(1, 8f));
        entries.add(new Entry(2, 6f));
        entries.add(new Entry(3, 2f));
        entries.add(new Entry(4, 18f));
        entries.add(new Entry(5, 9f));

        LineDataSet set = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");


        LineData data = new LineData(set);
        lineChart.setData(data); // set the data and list of lables into chart<br />


    }
}
