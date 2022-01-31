package mojtabagolab.com.applicationketabytoplearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class kharej extends AppCompatActivity {

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
        setContentView(R.layout.activity_kharej);


        RecyclerView recyclerView = findViewById(R.id.rvkharej);
        recyclerView.setLayoutManager(new LinearLayoutManager(kharej.this));

        ArrayList<ObjectOfList> lists = new ArrayList<>();

        lists.add(new ObjectOfList("غذای های ایرانی", "لیست غذای ایرانی", R.drawable.gheymeh));
        lists.add(new ObjectOfList("غذای های خارجی", "لیست غذا های خارجی", R.drawable.ghorme));
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