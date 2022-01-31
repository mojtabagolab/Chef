package mojtabagolab.com.applicationketabytoplearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class ForwardList extends AppCompatActivity {

    private RecyclerView listforward;
    private SharedPreferences datasave;
    public static boolean reCreate=false;

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
        setContentView(R.layout.activity_forward_list);

        datasave = getSharedPreferences("mydata" , MODE_PRIVATE);

        boolean ghorme = datasave.getBoolean("ghorme",false);
        boolean gheyme = datasave.getBoolean("gheyme",false);

        RecyclerView listforward = findViewById(R.id.listforward);
        listforward.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ObjectOfList> lists = new ArrayList<>();

        if (ghorme){
            lists.add(new ObjectOfList("خورشت قرمه سبزی", "خورشت سبزی از خورشت های ...", R.drawable.ghorme));
        }
        if (gheyme){
            lists.add(new ObjectOfList("خورشت قیمه", "خورش قیمه این خورش در میان ...", R.drawable.gheymeh));
        }

        myadapter myadapter = new myadapter(lists,this);
        listforward.setAdapter(myadapter);



    }

    @Override
    protected void onResume() {
        super.onResume();
        if (reCreate){
            recreate();
            reCreate = false;
        }

    }
}