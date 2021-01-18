package android.ke.darklightmodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {

    ImageView sun, day, night;
    View dayTime, nightTime;
    DayNightSwitch dayNightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        create hooks
        sun = findViewById(R.id.sun_bg);
        day = findViewById(R.id.day_image);
        night = findViewById(R.id.night_image);
        dayTime = findViewById(R.id.day_bg);
        nightTime = findViewById(R.id.night_bg);
        dayNightSwitch = findViewById(R.id.dn_switch);

        sun.setTranslationY(-110);

        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night){
                    sun.animate().translationY(110).setDuration(2000);
                    day.animate().alpha(0).setDuration(1300);
                    dayTime.animate().alpha(0).setDuration(1300);
                }
                else {

                    sun.animate().translationY(-110).setDuration(2000);
                    day.animate().alpha(1).setDuration(1300);
                    dayTime.animate().alpha(1).setDuration(1300);

                }
            }
        });


    }
}