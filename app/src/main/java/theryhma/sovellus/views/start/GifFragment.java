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
 * Fragment for the gif screen
 */
public class GifFragment extends Fragment {
    private AnimationDrawable gif;
    public GifFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        // create gif animation
        ImageView starsImage = view.findViewById(R.id.stars_image);
        starsImage.setBackgroundResource(R.drawable.waterfall);
        gif = (AnimationDrawable) starsImage.getBackground();
        gif.start();

        return view;
    }
}
