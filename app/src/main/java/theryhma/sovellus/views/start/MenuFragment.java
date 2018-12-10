package theryhma.sovellus.views.start;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.views.calendar.CalendarActivity;
import theryhma.sovellus.views.questions.QuestionActivity;
import theryhma.sovellus.views.settings.SettingsActivity;
import theryhma.sovellus.views.stats.StatActivity;
import theryhma.sovellus.views.tipoftheday.TipListActivity;



/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private View v;
    private TipOfTheDay tipOfTheDay;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false);

        tipOfTheDay = ((MainActivity) getActivity()).tipOfTheDay;
        ((TextView) v.findViewById(R.id.tipTitle)).setText(tipOfTheDay.getTitle());
        ((TextView) v.findViewById(R.id.tipText)).setText(tipOfTheDay.getText());
        v.findViewById(R.id.tip).setOnClickListener(buttonListener);
        v.findViewById(R.id.til).setOnClickListener(buttonListener);
        v.findViewById(R.id.kys).setOnClickListener(buttonListener);
        v.findViewById(R.id.kal).setOnClickListener(buttonListener);
        v.findViewById(R.id.settings).setOnClickListener(buttonListener);

        return v;
    }

    private final View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.settings:
                    Intent settings = new Intent(getActivity(), SettingsActivity.class);
                    //nextActivity.putExtra("presidentIndex", i);
                    startActivity(settings);
                    break;
                case R.id.kal:
                    Intent calendarActivity = new Intent(getActivity(), CalendarActivity.class);
                    startActivity(calendarActivity);

                    break;
                case R.id.til:
                    Intent statActivity = new Intent(getActivity(), StatActivity.class);
                    startActivity(statActivity);
                    break;
                case R.id.kys:
                    Intent nextActivity = new Intent(getActivity(), QuestionActivity.class);
                    //nextActivity.putExtra("presidentIndex", i);
                    startActivity(nextActivity);
                    break;
                case R.id.tip:
                    Intent intent = new Intent(getActivity(), TipListActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
