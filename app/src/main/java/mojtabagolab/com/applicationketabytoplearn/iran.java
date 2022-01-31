package mojtabagolab.com.applicationketabytoplearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class iran extends AppCompatActivity {

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
        setContentView(R.layout.activity_iran);

        RecyclerView recyclerView = findViewById(R.id.rvirean);
        recyclerView.setLayoutManager(new LinearLayoutManager(iran.this));

        ArrayList<ObjectOfList> lists = new ArrayList<>();

        lists.add(new ObjectOfList("خورشت قیمه", "خورش قیمه این خورش در میان ...", R.drawable.gheymeh));
        lists.add(new ObjectOfList("خورشت قرمه سبزی", "خورشت سبزی از خورشت های ...", R.drawable.ghorme));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        lists.add(new ObjectOfList("empty","item is empty",R.drawable.error));

        myadapter myadapter = new myadapter(lists, this);
        recyclerView.setAdapter(myadapter);
    }
}