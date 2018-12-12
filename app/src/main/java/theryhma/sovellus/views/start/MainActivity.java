package theryhma.sovellus.views.start;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.R;
import theryhma.sovellus.tipoftheday.TipOfTheDay;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;
import theryhma.sovellus.tools.Constant;
import theryhma.sovellus.tools.Tools;

/** This class includes the main code for the Main Activity.*/
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private StartFragmentCollectionAdapter adapter;
    private TipOfTheDayGenerator generator;

    public TipOfTheDay tipOfTheDay;
    private Context context;

    /** This onCreate method includes the code which is shown and happens, when the application has been opened.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup viewpager
        viewPager = findViewById(R.id.pager);
        adapter = new StartFragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        context = this; // this is used in password pop up

        GlobalModel.getInstance().load(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE)); // load data

        // tip of the day
        generator = GlobalModel.getInstance().getTipOfTheDayGenerator();
        generator.invalidate();
        tipOfTheDay = GlobalModel.getInstance().getTipOfTheDayGenerator().getCurrentTip();

        // password
        if (GlobalModel.getInstance().getPassword().isActive()) {
            passwordPopUp();
        }
    }

    /** This method shows the Password pop up for the user, and compares the given password to the saved one.*/
    public void passwordPopUp() {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.popup_window, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = promptsView.findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                if (userInput.getText().toString().equals(GlobalModel.getInstance().getPassword().get())) {
                                    // you can pass
                                } else {
                                    passwordPopUp();
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                finish();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    /** This onPause method includes the code for when the Main activity has been closed.*/
    @Override
    protected void onPause() {
        super.onPause();
        GlobalModel.getInstance().save(getSharedPreferences(Constant.PREF_DATA, Context.MODE_PRIVATE)); // save data
    }
}
