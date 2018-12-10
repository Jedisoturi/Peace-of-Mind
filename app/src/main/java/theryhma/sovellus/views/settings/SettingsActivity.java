package theryhma.sovellus.views.settings;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tools.Constant;

public class SettingsActivity extends AppCompatActivity {
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button save = findViewById(R.id.save);
        password = findViewById(R.id.password);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalModel.getInstance().getPassword().set(password.getText().toString());
                GlobalModel.getInstance().getPassword().activate();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));

    }
}
