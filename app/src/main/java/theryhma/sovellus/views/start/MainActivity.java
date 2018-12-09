package theryhma.sovellus.views.start;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.status.Status;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private StartFragmentCollectionAdapter adapter;
    private AnimationDrawable starsAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        adapter = new StartFragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString("statuses", null);
        Type type = new TypeToken<ArrayList<Status>>() {}.getType();
        ArrayList<Status> newData = gson.fromJson(json, type);
        if (json == null) {
            newData = new ArrayList<>();
        }
        GlobalModel.getInstance().setStatuses(newData);

        for (Status s : GlobalModel.getInstance().getStatuses()) {
            Log.d("statukset", s.toString());
        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(GlobalModel.getInstance().getStatuses());
        editor.putString("statuses", json);
        editor.apply();
    }
}
