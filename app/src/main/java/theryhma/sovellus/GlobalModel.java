package theryhma.sovellus;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import theryhma.sovellus.password.Password;
import theryhma.sovellus.status.Status;
import theryhma.sovellus.tipoftheday.TipOfTheDayGenerator;

/**
 * Contains all the data that needs to be saved after the app is closed. Also the list of statuses is used
 * in many different activities.
 */
public class GlobalModel {
    private TipOfTheDayGenerator tipOfTheDayGenerator;
    private ArrayList<Status> statuses;
    private Password password;

    private static final GlobalModel ourInstance = new GlobalModel();

    /**
     * Returns the singleton instance
     */
    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() { // initialize all objects
        tipOfTheDayGenerator = new TipOfTheDayGenerator();
        statuses = new ArrayList<>();
        password = new Password();
    }

    /**
     * Returns a status that has the date specified by the arguments.
     */
    public Status getStatus(int year, int month, int dayOfMonth) {
        for (Status s : statuses) {
            if (s.isDate(year, month, dayOfMonth)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns the Password object
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Returns the list of statuses
     */
    public ArrayList<Status> getStatuses() { return this.statuses; }

    /**
     * Returns the TipOfTheDayGenerator object
     */
    public TipOfTheDayGenerator getTipOfTheDayGenerator() {
        return tipOfTheDayGenerator;
    }

    /**
     * Loads data from preferences
     */
    public void load(SharedPreferences pref) {
        loadStatuses(pref);
        loadTipOfTheDayGenerator(pref);
        loadPassword(pref);
    }

    private void loadPassword(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("password", null);
        Type type = new TypeToken<Password>() {}.getType();
        Password newPassword = gson.fromJson(json, type);
        if (json == null) {
            newPassword = new Password();
        }
        this.password = newPassword;
    }

    private void loadStatuses(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("statuses", null);
        Type type = new TypeToken<ArrayList<Status>>() {}.getType();
        ArrayList<Status> newStatuses = gson.fromJson(json, type);
        if (json == null) {
            newStatuses = new ArrayList<>();
        }
        this.statuses = newStatuses;
    }

    private void loadTipOfTheDayGenerator(SharedPreferences pref) {
        Gson gson = new Gson();
        String json = pref.getString("generator", null);
        Type type = new TypeToken<TipOfTheDayGenerator>() {}.getType();
        TipOfTheDayGenerator newTipOfTheDayGenerator = gson.fromJson(json, type);
        if (json == null) {
            newTipOfTheDayGenerator = new TipOfTheDayGenerator();
        }
        this.tipOfTheDayGenerator = newTipOfTheDayGenerator;
    }

    /**
     * Saves data to preferences
     */
    public void save(SharedPreferences pref) {
        saveStatuses(pref);
        saveTipOfTheDayGenerator(pref);
        savePassword(pref);
    }

    private void savePassword(SharedPreferences pref) {
        SharedPreferences.Editor  editor = pref.edit();
        Gson gson = new Gson();
        Password password = GlobalModel.getInstance().getPassword();
        String json = gson.toJson(password);
        editor.putString("password", json);
        editor.commit();
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
