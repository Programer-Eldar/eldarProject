package com.isac.eldarproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // You can start an activity, display a notification, etc.

        // Clear the selected time from the TextView
        TextView selectedTimeTextView = ((ReminderActivity) context).findViewById(R.id.selectedTimeTextView);
        selectedTimeTextView.setText("");

        // Do other actions like showing a notification, playing a sound, etc.
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show();
    }
}
