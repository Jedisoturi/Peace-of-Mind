package theryhma.sovellus.views.Instruction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import theryhma.sovellus.R;

public class InstructionActivity extends AppCompatActivity {

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
