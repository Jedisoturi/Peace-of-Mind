package theryhma.sovellus;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import theryhma.sovellus.status.Answer;
import theryhma.sovellus.status.Question;
import theryhma.sovellus.status.Questionnaire;
import theryhma.sovellus.views.DemoFragmentCollectionAdapter;

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
    }
}
