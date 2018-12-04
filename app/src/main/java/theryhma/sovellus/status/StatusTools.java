package theryhma.sovellus.status;

import android.util.Log;

import java.util.ArrayList;

import theryhma.sovellus.GlobalModel;
import theryhma.sovellus.tools.Maths;

public class StatusTools {
    public static Status getNonZeroMeanStatus(ArrayList<Status> statuses) {
        final double IS_ZERO_THRESHOLD = 0.01;
        double absEnergy = 0;
        double absMood = 0;
        double absAnxiety = 0;
        double absStress = 0;
        int amountEnergy = 0;
        int amountMood = 0;
        int amountAnxiety = 0;
        int amountStress = 0;
        double meanEnergy = 0;
        double meanMood = 0;
        double meanAnxiety = 0;
        double meanStress = 0;

        for (Status s : statuses) {
            if (!Maths.isZero(s.getEnergy(), IS_ZERO_THRESHOLD)) {
                absEnergy += s.getEnergy();
                amountEnergy++;
            }
            if (!Maths.isZero(s.getMood(), IS_ZERO_THRESHOLD)) {
                absMood += s.getMood();
                amountMood++;
            }
            if (!Maths.isZero(s.getAnxiety(), IS_ZERO_THRESHOLD)) {
                absAnxiety += s.getAnxiety();
                amountAnxiety++;
            }
            if (!Maths.isZero(s.getStress(), IS_ZERO_THRESHOLD)) {
                absStress += s.getStress();
                amountStress++;
            }
        }
        if (amountEnergy != 0) {
            meanEnergy = absEnergy / amountEnergy;
        }
        if (amountMood != 0) {
            meanMood = absMood / amountMood;
        }
        if (amountAnxiety != 0) {
            meanAnxiety = absAnxiety / amountAnxiety;
        }
        if (amountStress != 0) {
            meanStress = absStress / amountStress;
        }



        Status status = new Status(meanEnergy, meanMood, meanAnxiety, meanStress);
        for (Status stat : statuses) {
            Log.d("supertesti", stat.toString());
        }
        Log.d("supertesti", "mean(" + statuses.size() + "):" + status.toString());
        return status;
    }

    public static Status getMeanStatus(ArrayList<Status> statuses) {
        double absEnergy = 0;
        double absMood = 0;
        double absAnxiety = 0;
        double absStress = 0;

        for (Status s : statuses) {
            absEnergy += s.getEnergy();
            absMood += s.getMood();
            absAnxiety += s.getAnxiety();
            absStress += s.getStress();
        }

        double meanEnergy = absEnergy / statuses.size();
        double meanMood = absMood / statuses.size();
        double meanAnxiety = absAnxiety / statuses.size();
        double meanStress = absStress / statuses.size();

        Status status = new Status(meanEnergy, meanMood, meanAnxiety, meanStress);
        return status;
    }
}
