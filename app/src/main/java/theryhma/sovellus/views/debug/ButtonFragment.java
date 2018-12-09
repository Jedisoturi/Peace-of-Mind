package theryhma.sovellus.views.debug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import theryhma.sovellus.R;

public class ButtonFragment extends Fragment {
    private TextView textView;
    private Button button;
    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        textView = view.findViewById(R.id.txt_display);
        String message = getArguments().getString("status") + "\n\n" + getArguments().getString("mean");
        textView.setText(message);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Pressed");
            }
        });
        return view;
    }
}
