package theryhma.sovellus.views.start;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import theryhma.sovellus.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private AnimationDrawable starsAnimation;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        return view;
    }

    public void onButtonClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.kal:

                break;
            case R.id.til:
                break;
            case R.id.kys:
                //Intent nextActivity = new Intent(getActivity(), DetailsActivity.class);
                //nextActivity.putExtra("presidentIndex", i);
                //startActivity(nextActivity);
                break;
            case R.id.tip:
                openTipsList();
                break;
        }
    }

    public void openTipsList() {
        Intent intentTips = new Intent(getContext(), TestiActivity.class);
        startActivity(intentTips);
    }

}
