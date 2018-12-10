package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import theryhma.sovellus.R;
import theryhma.sovellus.status.Status;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    private View v;
    private Status status;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_text, container, false);
        status = ((CalendarDetailsActivity) getActivity()).status;
        ((EditText) v.findViewById(R.id.teksti)).setText(status.getText());

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        String text = ((EditText) v.findViewById(R.id.teksti)).getText().toString();
        status.setText(text);
    }
}

