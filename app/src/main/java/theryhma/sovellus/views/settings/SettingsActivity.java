package theryhma.sovellus.views.settings;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tools.Constant;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE));
    }
}
