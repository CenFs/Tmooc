package cn.edu.scu.tmooc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;

public class Exit extends Activity {

    private List<Activity> list = new ArrayList<Activity>();
    private static Exit exit;

    private Exit() {
    }

    public static Exit getInstance() {
        if (null == exit) exit = new Exit();
        return exit;
    }

    public void addActivity(Activity activity) {
        list.add(activity);
    }

    public void exit(Context context) {
        for (Activity activity : list) {
            activity.finish();
        }
        System.exit(0);
    }
}
