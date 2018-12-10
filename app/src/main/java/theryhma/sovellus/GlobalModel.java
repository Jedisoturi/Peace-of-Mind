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

public class GlobalModel {
    private ArrayList<Integer> indicesOfTipsSeen;
    private ArrayList<Status> statuses;
    private Questionnaire questionnaire;
    private static final GlobalModel ourInstance = new GlobalModel();

    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        indicesOfTipsSeen = new ArrayList<>();
        statuses = new ArrayList<>();
        questionnaire = new Questionnaire();
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

    public ArrayList<Integer> getIndicesOfTipsSeen() {
        return this.indicesOfTipsSeen;
    }
    public ArrayList<Status> getStatuses() { return this.statuses; }
    public Questionnaire getQuestionnaire() { return this.questionnaire; }

    public void addToIndicesOfTipsSeen(int i) {
        if (!this.indicesOfTipsSeen.contains(i)) {
            this.indicesOfTipsSeen.add(i);
        }
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public void addStatus(Status s) {
        this.statuses.add(s);
    }

    public void clearIndicesOfTipsSeen() {
        this.indicesOfTipsSeen.clear();
    }

    public void load(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("statukset", null);
        Type type = new TypeToken<ArrayList<Status>>() {}.getType();
        ArrayList<Status> newData = gson.fromJson(json, type);
        if (json == null) {
            newData = new ArrayList<>();
        }
        GlobalModel.getInstance().setStatuses(newData);
    }

    public void save(SharedPreferences pref) {

        SharedPreferences.Editor  editor = pref.edit();
        Gson gson = new Gson();
        ArrayList<Status> statuses = GlobalModel.getInstance().getStatuses();
        String json = gson.toJson(statuses);
        editor.putString("statukset", json);
        editor.commit();
    }
}
