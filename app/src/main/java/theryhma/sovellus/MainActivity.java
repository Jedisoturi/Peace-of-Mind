package theryhma.sovellus;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import theryhma.sovellus.status.Status;
import theryhma.sovellus.views.DemoFragmentCollectionAdapter;
import theryhma.sovellus.views.HorizontalViewPager;
import theryhma.sovellus.views.VerticalViewPager;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private DemoFragmentCollectionAdapter adapter;
    private AnimationDrawable starsAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        adapter = new DemoFragmentCollectionAdapter(getSupportFragmentManager());
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
