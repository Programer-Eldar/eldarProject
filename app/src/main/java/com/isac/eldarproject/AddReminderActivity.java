package com.isac.eldarproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class AddReminderActivity extends AppCompatActivity {

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        // Retrieve the selected hour and minute from the intent
        int selectedHour = getIntent().getIntExtra("hourOfDay", 0); // 0 is the default value if key is not found
        int selectedMinute = getIntent().getIntExtra("minute", 0);

        // Display the selected time to the user
        TextView selectedTimeTextView = findViewById(R.id.selectedTimeTextView);
        selectedTimeTextView.setText(String.format("Alarm set for %02d:%02d", selectedHour, selectedMinute));

        // Set up the AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Create an Intent to start the AlarmReceiver
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent,PendingIntent.FLAG_MUTABLE);

        // Set the alarm to trigger at the specified time
        long currentTimeMillis = System.currentTimeMillis();
        long alarmTimeMillis = calculateAlarmTimeMillis(currentTimeMillis, selectedHour, selectedMinute);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
    }

    private long calculateAlarmTimeMillis(long currentTimeMillis, int selectedHour, int selectedMinute) {
        // Calculate the alarm time based on the selected hour and minute
        // Convert selected time to milliseconds
        long selectedTimeMillis = currentTimeMillis +
                ((selectedHour * 60 + selectedMinute) * 60 * 1000);

        // If the selected time has already passed today, set the alarm for the same time tomorrow
        if (selectedTimeMillis <= currentTimeMillis) {
            selectedTimeMillis += AlarmManager.INTERVAL_DAY;
        }

        return selectedTimeMillis;
    }
}
