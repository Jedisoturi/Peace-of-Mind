package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.R;
import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.state.State;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.views.calendar.CalendarActivity;

/**
 * Display State bar chart
 */
public class StateFragment extends Fragment {

    private View v;
    private BarChart barChart;
    private Status status;
    private Date date;
    private ArrayList<String> xAxes;

    public StateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_state, container, false);

        status = ((CalendarDetailsActivity) getActivity()).status;  // get status

        // print date
        date = status.getCalendar().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        ((TextView) v.findViewById(R.id.date)).setText(format.format(date));

        // create bar data
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<Attribute> attributes = status.getState().getAttributes();
        xAxes = new ArrayList<>();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            entries.add(new BarEntry(i, (float) attribute.getValue() * 100, attribute.getType().toFinnish()));
            xAxes.add(Double.toString(attribute.getValue()));
        }
        BarDataSet set = new BarDataSet(entries, "State");
        BarData data = new BarData(set);

        // add data barchart view
        barChart = v.findViewById(R.id.barchart);
        barChart.setData(data);

        // parameters
        barChart.getBarData().setValueTextSize(13);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisLeft().setAxisMaximum(100);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.animateY(2000);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getXAxis().setDrawLabels(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        set.setColors(ColorTemplate.COLORFUL_COLORS);

        // display label instead of value
        set.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                //rather than displaying value show label
                String s = entry.getData().toString().toLowerCase();
                return s.substring(0, 1).toUpperCase() + s.substring(1);
            }
        });

        return v;
    }
}
