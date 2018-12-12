package theryhma.sovellus.views.Instruction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import theryhma.sovellus.R;

/** This class includes the main code for the Instruction activity.*/
public class InstructionActivity extends AppCompatActivity {

    /** This method sets the Title and Text wiews to show a certain Instruction to a user
     * depending on the results the user gets from answered questions. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        String title = getIntent().getExtras().getString("title", "");
        String text = getIntent().getExtras().getString("text", "");

        ((TextView) findViewById(R.id.titleView)).setText(title);
        ((TextView) findViewById(R.id.textView)).setText(text);

    }
}
