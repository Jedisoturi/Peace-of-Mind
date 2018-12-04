package theryhma.sovellus.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.status.StatusTools;

public class DebugQuestionResults extends Fragment {
    private View v;
    public DebugQuestionResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
               Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_debug_question_results, container, false);

                Button button = v.findViewById(R.id.calc);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView textView = v.findViewById(R.id.results);
        Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
        Status result = StatusTools.getNonZeroMean(questionnaire.getResults());
        textView.setText(result.toString());
    }
}