package com.example.user.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }  static int id = 70000;

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("KEY_MSG");
        Intent newintent = new Intent();
        newintent.setClass(context, ActivityNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newintent, 0);
        Notification notify = newNotification(context, pendingIntent, "(New) Broadcast is received.",msg);
        NotificationManager notificationManager =(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++, notify);
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
