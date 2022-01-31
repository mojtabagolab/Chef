package mojtabagolab.com.applicationketabytoplearn;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class StudyActivity extends AppCompatActivity {

    private ToggleButton tgl;
    private SharedPreferences mydatasave;
    private SharedPreferences.Editor edit;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (MainActivity.selectusertheme){
            case 0:
                setTheme(R.style.AppTheme);
                break;
            case 1:
                setTheme(R.style.AppThemeDark);
                break;
        }
        setContentView(R.layout.activity_study);

        ImageView imageView = findViewById(R.id.img_ghza);
        TextView textView1 = findViewById(R.id.tx_title);
        TextView textView2 = findViewById(R.id.tx_des);
        tgl =findViewById(R.id.tgl);

        final String stringdata = getIntent().getStringExtra("data");

        mydatasave = getSharedPreferences("mydata",MODE_PRIVATE);
        Boolean togglemode = mydatasave.getBoolean(stringdata,false);
        if (togglemode){
            tgl.toggle();
        }

        tgl.setOnTouchListener((v, event) -> {
            if(tgl.getText().equals("افزودن به علاقه مندی ها")){
                edit = mydatasave.edit();
                edit.putBoolean(stringdata,true);
                edit.apply();

                Toast.makeText(StudyActivity.this, "به لیست علاقه مندی ها اضافه شد !!", Toast.LENGTH_SHORT).show();
            }
            else {
                edit = mydatasave.edit();
                edit.putBoolean(stringdata,false);
                edit.apply();

                Toast.makeText(StudyActivity.this, "از لیست علاقه مندی ها حذف شد !!", Toast.LENGTH_SHORT).show();

                ForwardList.reCreate = true;
            }
            return false;
        });

        switch (stringdata){
            case "ghorme" :
                textView1.setText("قورمه سبزی");
                textView2.setText("این خورشت با سبزی قرمه (دربرگیرندهٔ: تره، جعفری، شنبلیله و گشنیز، اسفناج یا برگ چغندر - زمستان که فصل اسفناج است از اسفناج و هنگامی که برگ چغندر فراهم است، برگ چغندر بکار می\u200Cرود)، لوبیا (قرمز یا چیتی)، گوشت قرمز پخته می\u200Cشود. مزّهٔ این خورشت باید کمی ترش باشد، از این رو، به آن کمی لیمو عمانی خشک یا آب لیموی تازه می\u200Cافزایند که پوست لیمو عمانی، اندکی مزهٔ تلخ خوشایندی به خورش می\u200Cدهد. البته لیمو عمانی را قبل از اضافه کردن به خورش، چند دقیقه در آب جوش قرار می\u200Cدهند تا تلخی\u200Cاش کمی گرفته شود. برای جا افتادن قرمه\u200Cسبزی زمان زیادی نیاز است. نکتهٔ مهم این است که در صورت عدم استفاده از لوبیای قرمز در این خورشت، می\u200Cتوان مقدار کمی زعفران برای خوش رنگ شدن غذا اضافه کرد.\n" +
                        "\n" +
                        "این خورشت چنانچه برای ۴ نفر پخته شود نزدیک ۱۵۵۰ کیلو کالری انرژی دارد.");
                imageView.setImageResource(R.drawable.ghorme);
                break;
            case "gheyme":
                textView1.setText("خورشت قیمه");
                textView2.setText("خورش قیمه از غذاهای آشپزی ایرانی است. این خورش در میان ایرانیان و عراقی\u200Cها غذایی پرطرفدار است و برای پخت آن از رب گوجه فرنگی و پیاز سرخ شده، لپه، گوشت قرمز، سیب زمینی به همراه لیموی خشک (لیمو عمانی) به عنوان طعم دهنده استفاده می\u200Cشود. ادویه\u200Cای که معمولاً در اواخر زمان طبخ به آن اضافه می\u200Cشود دارچین است، برای دادن عطر ویژه به آن مقداری هل و گلاب می\u200Cتوان اضافه کرد. این خورش به همراه پلو سرو می\u200Cشود.\n" +
                        "\n" +
                        "همچنین در برخی مناسبت\u200Cهای مذهبی در کشور ایران نیز به عنوان نذری تهیه و توزیع می\u200Cشود.");
                imageView.setImageResource(R.drawable.gheymeh);
                break;
        }
    }
}