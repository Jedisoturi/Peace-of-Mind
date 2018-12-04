package theryhma.sovellus.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.question.Answer;
import theryhma.sovellus.question.Question;
import theryhma.sovellus.question.Questionnaire;

public class QuestionFragment extends Fragment {
    private TextView textView;
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        textView = view.findViewById(R.id.question);
        final int index = getArguments().getInt("index");
        Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
        Question q = questionnaire.getQuestion(index);
        textView.setText(q.getText());

        updateRadioGroup(q.getAnswer(), view);

        RadioGroup radioGroup = view.findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Questionnaire questionnaire = GlobalModel.getInstance().getQuestionnaire();
                Question q = questionnaire.getQuestion(index);
                switch(checkedId) {
                    case R.id.best:
                        q.setAnswer(Answer.BEST);
                        break;
                    case R.id.good:
                        q.setAnswer(Answer.GOOD);
                        break;
                    case R.id.neutral:
                        q.setAnswer(Answer.NEUTRAL);
                        break;
                    case R.id.bad:
                        q.setAnswer(Answer.BAD);
                        break;
                    case R.id.worst:
                        q.setAnswer(Answer.WORST);
                        break;
                }
            }
        });
        return view;
    }

    public void updateRadioGroup(Answer answer, View view) {
        switch (answer) {
            case BEST:
                ((RadioButton) view.findViewById(R.id.best)).setChecked(true);
                break;
            case GOOD:
                ((RadioButton) view.findViewById(R.id.good)).setChecked(true);
                break;
            case NEUTRAL:
                ((RadioButton) view.findViewById(R.id.neutral)).setChecked(true);
                break;
            case BAD:
                ((RadioButton) view.findViewById(R.id.bad)).setChecked(true);
                break;
            case WORST:
                ((RadioButton) view.findViewById(R.id.worst)).setChecked(true);
                break;
            default:
                break;
        }
    }
}
