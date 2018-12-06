package theryhma.sovellus;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

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

    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }
}
