package theryhma.sovellus.views.questions;

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
import theryhma.sovellus.views.start.StartFragmentCollectionAdapter;

public class QuestionActivity extends AppCompatActivity {
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
