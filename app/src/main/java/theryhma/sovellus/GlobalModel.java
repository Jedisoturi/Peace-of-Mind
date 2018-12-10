package theryhma.sovellus;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import theryhma.sovellus.question.Questionnaire;
import theryhma.sovellus.state.State;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;

public class GlobalModel {
    private TipOfTheDayGenerator tipOfTheDayGenerator;
    private ArrayList<Status> statuses;
    private static final GlobalModel ourInstance = new GlobalModel();

    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        tipOfTheDayGenerator = new TipOfTheDayGenerator();
        statuses = new ArrayList<>();
        // init tipsSeen (what tips have been seen?)
    }

    public Status getStatus(int year, int month, int dayOfMonth) {
        for (Status s : statuses) {
            if (s.isDate(year, month, dayOfMonth)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Status> getStatuses() { return this.statuses; }

    public TipOfTheDayGenerator getTipOfTheDayGenerator() {
        return tipOfTheDayGenerator;
    }


    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public void setTipOfTheDayGenerator(TipOfTheDayGenerator generator) {
        this.tipOfTheDayGenerator = generator;
    }

    public void addStatus(Status s) {
        this.statuses.add(s);
    }

    public void load(SharedPreferences pref) {
        loadStatuses(pref);
        loadTipOfTheDayGenerator(pref);
    }

    private void loadStatuses(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("statuses", null);
        Type type = new TypeToken<ArrayList<Status>>() {}.getType();
        ArrayList<Status> newData = gson.fromJson(json, type);
        if (json == null) {
            newData = new ArrayList<>();
        }
        GlobalModel.getInstance().setStatuses(newData);
    }

    private void loadTipOfTheDayGenerator(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("generator", null);
        Type type = new TypeToken<TipOfTheDayGenerator>() {}.getType();
        TipOfTheDayGenerator newData = gson.fromJson(json, type);
        if (json == null) {
            newData = new TipOfTheDayGenerator();
        }
        GlobalModel.getInstance().setTipOfTheDayGenerator(newData);
    }

    public void save(SharedPreferences pref) {
        saveStatuses(pref);
        saveTipOfTheDayGenerator(pref);

    }

    private void saveStatuses(SharedPreferences pref) {
        SharedPreferences.Editor  editor = pref.edit();
        Gson gson = new Gson();
        ArrayList<Status> statuses = GlobalModel.getInstance().getStatuses();
        String json = gson.toJson(statuses);
        editor.putString("statuses", json);
        editor.commit();
    }

    private void saveTipOfTheDayGenerator(SharedPreferences pref) {
        SharedPreferences.Editor  editor = pref.edit();
        Gson gson = new Gson();
        TipOfTheDayGenerator generator = GlobalModel.getInstance().getTipOfTheDayGenerator();
        String json = gson.toJson(generator);
        editor.putString("generator", json);
        editor.commit();
    }
}
