package theryhma.sovellus.status;

import android.util.Log;

import java.util.ArrayList;

public class Status {
    private double energy;
    private double mood;
    private double anxiety;
    private double stress;

    public Status(double energy, double mood, double anxiety, double stress) {
        this.energy = energy;
        this.mood = mood;
        this.anxiety = anxiety;
        this.stress = stress;
        //Log.d("supergetstatus", "CREATE: " + getEnergy());
        if (!isValid()) {
            throw new IllegalArgumentException("Status values cannot be over 1 or under -1");
        }
    }

    public Status(Status reference) {
        this.energy = reference.energy;
        this.mood = reference.mood;
        this.anxiety = reference.anxiety;
        this.stress = reference.stress;
    }

    private boolean isValid() {
        if (isValidValue(this.energy) && isValidValue(this.mood) && isValidValue(this.anxiety) && isValidValue(this.stress)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidValue(double val) {
        if (-1.0 <= val && val <= 1.0) {
            return true;
        } else {
            return false;
        }
    }

    public void scale(double scale) {
        if (!isValidValue(scale)) {
            throw new IllegalArgumentException("Scale cannot be over 1 or under -1");
        }
        this.energy = this.energy * scale;
        this.mood = this.mood * scale;
        this.anxiety = this.anxiety * scale;
        this.stress = this.stress * scale;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getMood() {
        return this.mood;
    }

    public double getAnxiety() {
        return this.anxiety;
    }

    public double getStress() {
        return this.stress;
    }

    @Override
    public String toString() {
        return Double.toString(this.energy) + "\n" +
                Double.toString(this.mood) + "\n" +
                Double.toString(this.anxiety) + "\n" +
                Double.toString(this.stress) + ";";
    }
}
