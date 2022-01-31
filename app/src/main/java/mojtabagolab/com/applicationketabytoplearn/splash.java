package mojtabagolab.com.applicationketabytoplearn;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class splash extends AppCompatActivity {


    private ProgressBar prg;

    Handler handler;

    int counter = 0;
    private SharedPreferences sharedPreferences;
    private int selectusertheme;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("mydata" , MODE_PRIVATE);
        selectusertheme = sharedPreferences.getInt("selectedTheme", 0);
        switch (selectusertheme){
            case 0:
                setTheme(R.style.splashTheme);
                setContentView(R.layout.activity_splash2);
                break;
            case 1:
                setTheme(R.style.splashThemeDark);
                setContentView(R.layout.activity_splash2_dark);
                break;
        }


        prg = findViewById(R.id.progressBar);

        handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (counter != 100) {
                    counter += 1;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            prg.setProgress(counter);

                            if (counter == 100) {
                                Intent intent = new Intent(splash.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                        }
                    });

                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}