package theryhma.sovellus.views.debug;

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
import theryhma.sovellus.state.State;
import theryhma.sovellus.state.StateTools;

public class DebugQuestionResults extends Fragment {
    private View v;
    public DebugQuestionResults() {
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
        State result = StateTools.createMeanState(questionnaire.getResults());
        textView.setText(result.toString());

        TextView instructions = v.findViewById(R.id.instructions);
        instructions.setText(InstructionTools.instructionArrayToString(InstructionTools.generateRandomInstructions(result)));
        GlobalModel.getInstance().addStatuses(result);


    }
}