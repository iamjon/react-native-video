package com.brentvatne.service;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;

class DescriptionAdapter implements
        PlayerNotificationManager.MediaDescriptionAdapter {


    private final Context context;
    private final Application application;
    private final String title;
    public DescriptionAdapter(Context context, Application application, String title) {
       this.context = context;
       this.application = application;
       this.title = title;
    }

    @Override
    public String getCurrentContentTitle(Player player) {
        return "Player";
    }

    @Nullable
    @Override
    public String getCurrentContentText(Player player) {
        return title;
    }

    @Nullable
    @Override
    public Bitmap getCurrentLargeIcon(Player player,
                                      PlayerNotificationManager.BitmapCallback callback) {
        return Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    }

    @Nullable
    @Override
    public PendingIntent createCurrentContentIntent(Player player) {
        Intent intent = new Intent(context, application.getClass());

        PendingIntent i = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        return i;
    }


}


