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

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.question.AnswerType;
import theryhma.sovellus.question.Question;
import theryhma.sovellus.question.Questionnaire;

public class QuestionFragment extends Fragment {
    private View v;
    private int index;
    private Boolean isLast;
    private Question q;
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_question, container, false);

        index = getArguments().getInt("index");
        isLast = getArguments().getBoolean("isLast");
        Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
        q = questionnaire.getQuestion(index);

        if (!isLast) {
            v.findViewById(R.id.exit).setVisibility(View.GONE);
        }
        updateRadioGroup();
        updateUI();

        v.findViewById(R.id.exit).setOnClickListener(buttonListener);

        RadioGroup radioGroup = v.findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
                Question q = questionnaire.getQuestion(index);
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

                    break;
            }
        }
    };


    public void updateUI() {
        TextView questionText = v.findViewById(R.id.question);
        questionText.setText(q.getQuestionText());

        RadioButton veryPositive = v.findViewById(R.id.best);
        veryPositive.setText(q.getAnswerMap().get(AnswerType.VERY_POSITIVE));
        RadioButton positive = v.findViewById(R.id.good);
        positive.setText(q.getAnswerMap().get(AnswerType.POSITIVE));
        RadioButton neutral = v.findViewById(R.id.neutral);
        neutral.setText(q.getAnswerMap().get(AnswerType.NEUTRAL));
        RadioButton negative = v.findViewById(R.id.bad);
        negative.setText(q.getAnswerMap().get(AnswerType.NEGATIVE));
        RadioButton veryNegative = v.findViewById(R.id.worst);
        veryNegative.setText(q.getAnswerMap().get(AnswerType.VERY_NEGATIVE));

        ConstraintLayout constraintLayout = v.findViewById(R.id.tausta);

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
            default:
                break;
        }
    }

    public void updateRadioGroup() {
        AnswerType answerType = q.getAnswer();
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
            default:
                break;
        }
    }
}
