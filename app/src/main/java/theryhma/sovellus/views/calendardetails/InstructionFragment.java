package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.R;
import theryhma.sovellus.state.State;
import theryhma.sovellus.status.Status;

public class InstructionFragment extends Fragment {

    View v;

    public InstructionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_instruction, container, false);
        Status status = ((CalendarDetailsActivity) getActivity()).status;
        Date date = status.getCalendar().getTime();
        State state = status.getState();
        InstructionContainer instructions = status.getInstructions();
        int entries = status.getEntries();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ((TextView) v.findViewById(R.id.date)).setText(format.format(date));
        ((TextView) v.findViewById(R.id.state)).setText(state.toString());
        ((TextView) v.findViewById(R.id.instructions)).setText(instructions.toString());
        ((TextView) v.findViewById(R.id.entries)).setText(Integer.toString(entries));

        return v;
    }
}

