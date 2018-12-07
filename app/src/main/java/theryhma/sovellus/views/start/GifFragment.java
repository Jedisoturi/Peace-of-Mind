package theryhma.sovellus.views.start;


import android.graphics.drawable.AnimationDrawable;
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
public class GifFragment extends Fragment {

    private AnimationDrawable starsAnimation;
    public GifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        ImageView starsImage = view.findViewById(R.id.stars_image);
        starsImage.setBackgroundResource(R.drawable.waterfall);
        starsAnimation = (AnimationDrawable) starsImage.getBackground();
        starsAnimation.start();

        return view;
    }

}