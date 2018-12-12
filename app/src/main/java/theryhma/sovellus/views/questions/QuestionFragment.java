package theryhma.sovellus.views.questions;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import theryhma.sovellus.R;
import theryhma.sovellus.question.AnswerType;
import theryhma.sovellus.question.Question;
import theryhma.sovellus.question.Questionnaire;

/**
 * Fragment that contains a single question and radio group for answers
 */
public class QuestionFragment extends Fragment {
    private View v;
    private int index;
    private Boolean isLast;
    private Questionnaire questionnaire;
    private Question q;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_question, container, false);

        // get extras
        index = getArguments().getInt("index");
        isLast = getArguments().getBoolean("isLast");

        // get question
        questionnaire = ((QuestionActivity)getActivity()).getQuestionnaire();
        q = questionnaire.getQuestion(index);

        // add "done" button if last question
        if (!isLast) {
            v.findViewById(R.id.exit).setVisibility(View.GONE);
        }
        
        updateUI();

        v.findViewById(R.id.exit).setOnClickListener(buttonListener);

        // radiobutton listeners
        RadioGroup radioGroup = v.findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.best:
                        q.setAnswer(AnswerType.VERY_POSITIVE);
                        break;
                    case R.id.good:
                        q.setAnswer(AnswerType.POSITIVE);
                        break;
                    case R.id.neutral:
                        q.setAnswer(AnswerType.NEUTRAL);
                        break;
                    case R.id.bad:
                        q.setAnswer(AnswerType.NEGATIVE);
                        break;
                    case R.id.worst:
                        q.setAnswer(AnswerType.VERY_NEGATIVE);
                        break;
                }
            }
        });
        return v;
    }

    private final View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.exit:
                    ((QuestionActivity) getActivity()).done();  // go to done method
                    break;
            }
        }
    };

    private void updateUI() {
        updateUIText();
        updateUIBackground();
        updateUIRadioGroup();
    }

    private void updateUIText() {
        ((TextView) v.findViewById(R.id.question)).setText(q.getQuestionText());    // question

        // answers
        ((RadioButton) v.findViewById(R.id.best)).setText(q.getAnswerMap().get(AnswerType.VERY_POSITIVE));
        ((RadioButton) v.findViewById(R.id.good)).setText(q.getAnswerMap().get(AnswerType.POSITIVE));
        ((RadioButton) v.findViewById(R.id.neutral)).setText(q.getAnswerMap().get(AnswerType.NEUTRAL));
        ((RadioButton) v.findViewById(R.id.bad)).setText(q.getAnswerMap().get(AnswerType.NEGATIVE));
        ((RadioButton) v.findViewById(R.id.worst)).setText(q.getAnswerMap().get(AnswerType.VERY_NEGATIVE));
    }
    
    private void updateUIBackground() {
        ConstraintLayout constraintLayout = v.findViewById(R.id.tausta);    // find the layout view

        // set background based on fragment index
        switch (index) {
            case 0:
                constraintLayout.setBackgroundResource(R.drawable.panorama1);
                break;
            case 1:
                constraintLayout.setBackgroundResource(R.drawable.panorama2);
                break;
            case 2:
                constraintLayout.setBackgroundResource(R.drawable.panorama3);
                break;
            case 3:
                constraintLayout.setBackgroundResource(R.drawable.panorama4);
                break;
            case 4:
                constraintLayout.setBackgroundResource(R.drawable.panorama5);
                break;
        }
    }

    private void updateUIRadioGroup() {
        AnswerType answerType = q.getAnswer();  // get fragment's question and its answer
        switch (answerType) {
            case VERY_POSITIVE:
                ((RadioButton) v.findViewById(R.id.best)).setChecked(true);
                break;
            case POSITIVE:
                ((RadioButton) v.findViewById(R.id.good)).setChecked(true);
                break;
            case NEUTRAL:
                ((RadioButton) v.findViewById(R.id.neutral)).setChecked(true);
                break;
            case NEGATIVE:
                ((RadioButton) v.findViewById(R.id.bad)).setChecked(true);
                break;
            case VERY_NEGATIVE:
                ((RadioButton) v.findViewById(R.id.worst)).setChecked(true);
                break;
        }
    }
}
