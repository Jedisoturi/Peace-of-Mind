package theryhma.sovellus.views.Instruction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import theryhma.sovellus.R;

/** This class includes the main code for the Instruction activity.*/
public class InstructionActivity extends AppCompatActivity {

    /** This method gets the users values and compares it to Instructions values.
     * After that the method sets instruction activity's textViews to show a certain
     * Instruction's title and text. */
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
