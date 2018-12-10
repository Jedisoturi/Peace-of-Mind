package theryhma.sovellus.views.calendardetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import theryhma.sovellus.Instruction.Instruction;
import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.R;
import theryhma.sovellus.state.State;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.views.Instruction.InstructionActivity;

public class InstructionFragment extends Fragment {

    View v;
    private ArrayList<Instruction> listOfInstructions;

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


        listOfInstructions = instructions.createArray();
        ArrayList<Instruction> l2 = instructions.createArray();

        ListView instructionsList = v.findViewById(R.id.ohjeetList);
        instructionsList.setAdapter(new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_list_item_1,
                l2));

        instructionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.d("supersovellus", "onItemClick(" + i + ")");
                Intent instructionDetails = new Intent(getActivity(), InstructionActivity.class);
                instructionDetails.putExtra("title", listOfInstructions.get(i).getTitle());
                instructionDetails.putExtra("text", listOfInstructions.get(i).getText());
                startActivity(instructionDetails);

            }
        });


        return v;
    }
}

