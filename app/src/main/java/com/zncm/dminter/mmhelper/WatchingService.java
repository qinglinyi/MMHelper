package com.zncm.dminter.mmhelper;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;

import com.zncm.dminter.mmhelper.utils.Xutils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WatchingService extends Service {

	private Handler mHandler = new Handler();
	private  ActivityManager mActivityManager;
	private String text = null;
	private Timer timer;

	@Override
	public void onCreate() {
		super.onCreate();
		mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (timer == null) {
			timer = new Timer();
			timer.scheduleAtFixedRate(new RefreshTask(), 0, 500);
		}
	    return super.onStartCommand(intent, flags, startId);
	}

	class RefreshTask extends TimerTask {

		@Override
		public void run() {
			List<RunningTaskInfo> rtis = mActivityManager.getRunningTasks(1);
            if (Xutils.listNotNull(rtis)) {
                String act = rtis.get(0).topActivity.getPackageName() + "\n"
                        + rtis.get(0).topActivity.getClassName();
                if (!act.equals(text)) {
                    text = act;
                    if (SPHelper.isAcFloat(WatchingService.this)) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                TasksWindow.show(WatchingService.this, text);
                            }
                        });
                    }
                }
			}
		}
	}
	
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	public void onTaskRemoved(Intent rootIntent) {
	    Intent restartServiceIntent = new Intent(getApplicationContext(),
	            this.getClass());
	    restartServiceIntent.setPackage(getPackageName());
	    PendingIntent restartServicePendingIntent = PendingIntent.getService(
	            getApplicationContext(), 1, restartServiceIntent,
	            PendingIntent.FLAG_ONE_SHOT);
	    AlarmManager alarmService = (AlarmManager) getApplicationContext()
	            .getSystemService(Context.ALARM_SERVICE);
	    alarmService.set(AlarmManager.ELAPSED_REALTIME,
	            SystemClock.elapsedRealtime() + 500,
	            restartServicePendingIntent);
	    super.onTaskRemoved(rootIntent);
	}

}
