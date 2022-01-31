package mojtabagolab.com.applicationketabytoplearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private RecyclerView recyclerViewlistsearch;

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
        setContentView(R.layout.activity_search);
        RecyclerView recyclerView = findViewById(R.id.recyclerviewsearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(Search.this));
        ArrayList<ObjectOfList> lists = new ArrayList<>();
        myadapter myadapter = new myadapter(lists, this);
        recyclerView.setAdapter(myadapter);

        SearchView searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {

                myadapter.getFilter().filter(newtext);

                return false;
            }
        });

    }
}