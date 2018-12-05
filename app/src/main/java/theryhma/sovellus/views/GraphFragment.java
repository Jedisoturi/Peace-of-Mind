package theryhma.sovellus.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.Instruction.InstructionTools;
import theryhma.sovellus.R;
import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.status.StatusTools;

public class GraphFragment extends Fragment {
    private View v;
    public GraphFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_debug_question_results, container, false);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView textView = v.findViewById(R.id.results);
        Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
        Status result = StatusTools.createMeanStatus(questionnaire.getResults());
        textView.setText(result.toString());

        TextView instructions = v.findViewById(R.id.instructions);
        instructions.setText(InstructionTools.instructionArrayToString(InstructionTools.generateRandomInstructions(result)));
    }
}
