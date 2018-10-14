package com.brentvatne.service;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.util.NotificationUtil;


public class MusicControlNotification {

    private  final ThemedReactContext themeContext;
    private  final Context context;
    private final Application application;
    private final String packageName;



    public static final String channelId = "react_native_video";
    public static final String channelName = "React Video";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;


    public MusicControlNotification(ThemedReactContext context, Application application) {
        this.context = context.getApplicationContext();
        this.themeContext = context;
        this.packageName = context.getPackageName();
        this.application = application;


    }

    public PlayerNotificationManager getPlayerNotificationManager(String title) {
        NotificationUtil.createNotificationChannel(context, channelId, android.R.string.ok, NotificationUtil.IMPORTANCE_LOW);
        PlayerNotificationManager playerNotificationManager = new PlayerNotificationManager( context,channelId,42, new DescriptionAdapter(context, application, title));
        return playerNotificationManager;
    }

    public static class NotificationService extends Service {
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            return START_NOT_STICKY;
        }

        @Override
        public void onTaskRemoved(Intent rootIntent) {
            stopSelf(); // Stop the service as we won't need it anymore
        }

    }


}