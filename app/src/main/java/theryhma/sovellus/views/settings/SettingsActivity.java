package theryhma.sovellus.views.settings;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tools.Constant;

public class SettingsActivity extends AppCompatActivity {
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        password = findViewById(R.id.password);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalModel.getInstance().getPassword().set(password.getText().toString());
                //Log.d("password", GlobalModel.getInstance().getPassword().get());
                password.setText("");
            }
        });

        Switch switch_view = findViewById(R.id.switch_view);
        if (GlobalModel.getInstance().getPassword().isActive()) {
            switch_view.setChecked(true);
        } else {
            switch_view.setChecked(false);
        }

        switch_view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    GlobalModel.getInstance().getPassword().activate();
                } else {
                    GlobalModel.getInstance().getPassword().deactivate();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));

    }
}
