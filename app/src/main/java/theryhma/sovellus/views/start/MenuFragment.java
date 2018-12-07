package theryhma.sovellus.views.start;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

        view.findViewById(R.id.tip).setOnClickListener(buttonListener);
        view.findViewById(R.id.til).setOnClickListener(buttonListener);
        view.findViewById(R.id.kys).setOnClickListener(buttonListener);
        view.findViewById(R.id.kal).setOnClickListener(buttonListener);

        return view;
    }

    private final View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
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
                    //Intent intent = new Intent(getActivity(), TestiAktiviteetti.class);
                    //startActivity(intent);
                    break;
            }
        }
    };

}
