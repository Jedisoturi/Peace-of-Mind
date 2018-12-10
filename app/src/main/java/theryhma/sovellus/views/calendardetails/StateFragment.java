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
 * A simple {@link Fragment} subclass.
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

        status = ((CalendarDetailsActivity) getActivity()).status;

        date = status.getCalendar().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        ((TextView) v.findViewById(R.id.date)).setText(format.format(date));

        barChart = v.findViewById(R.id.barchart);
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<Attribute> attributes = status.getState().getAttributes();
        xAxes = new ArrayList<>();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            entries.add(new BarEntry(i, (float) attribute.getValue() * 100, attribute.getType()));
            xAxes.add(Double.toString(attribute.getValue()));
        }

        BarDataSet set = new BarDataSet(entries, "State");

        BarData data = new BarData(set);
        //data.setBarWidth(0.9f);
        barChart.setData(data);
        barChart.getBarData().setValueTextSize(15);
        barChart.getDescription().setEnabled(false);

        set.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                //rather than diaplaying value show label
                String s = entry.getData().toString().toLowerCase();
                return s.substring(0, 1).toUpperCase() + s.substring(1);
            }
        });

        /*barChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int index = (int) value;
                return xAxes.get(index);
            }
        });*/
        /*barChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return barChart.getBarData().get(i).Math.round(value);
            }
        });*/
        barChart.getAxisLeft().setAxisMaximum(100);
        barChart.getAxisLeft().setAxisMinimum(0);
        //barChart.setDrawValueAboveBar(false);
        //barChart.setDescription();

        set.setColors(ColorTemplate.COLORFUL_COLORS);
        //barChart.setFitBars(true);
        barChart.animateY(2000);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        //barChart.getAxisLeft().setDrawZeroLine(true);
        //barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getXAxis().setDrawLabels(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);


        return v;
    }
}
