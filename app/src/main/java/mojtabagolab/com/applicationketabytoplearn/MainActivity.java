package mojtabagolab.com.applicationketabytoplearn;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

//ghesmat implements baraye sery dovome code menu ast
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    private int selectedTheme;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static int selectusertheme;
    private boolean doubleback = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("mydata" , MODE_PRIVATE);
        selectusertheme = sharedPreferences.getInt("selectedTheme", 0);
        switch (selectusertheme){
            case 0:
                setTheme(R.style.MainActivitytheme);
            break;
            case 1:
                setTheme(R.style.MainActivitythemeDark);
                break;
        }
        setContentView(R.layout.activity_main);

//sery code aval menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation);


//
        RecyclerView recyclerView = findViewById(R.id.Rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ArrayList<ObjectOfList> lists = new ArrayList<>();
        lists.add(new ObjectOfList("لیست علاقه مندی ها", "...", R.drawable.like));
        lists.add(new ObjectOfList("غذا های ایرانی", "لیست غذای ایرانی", R.drawable.gheymeh));
        lists.add(new ObjectOfList("غذا های خارجی", "لیست غذا های خارجی", R.drawable.ghorme));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));
        lists.add(new ObjectOfList("empty", "item is empty", R.drawable.error));

        myadapter myadapter = new myadapter(lists, this);
        recyclerView.setAdapter(myadapter);


//sery code dovom menu
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                //search
                Intent intentsearch = new Intent(MainActivity.this,Search.class);
                MainActivity.this.startActivity(intentsearch);
                break;
            case R.id.changetheme:
                //changetheme
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setTitle("Select your theme");
                CharSequence[] charSequences = new CharSequence[]{"Main" , "Dark"};
                builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        selectedTheme = which;
                    }
                });
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        editor = sharedPreferences.edit();
                        editor.putInt("selectedTheme" , selectedTheme);
                        editor.apply();
                        Intent intentTheme = new Intent(MainActivity.this , splash.class);
                        MainActivity.this.startActivity(intentTheme);
                        finishAffinity();
                    }
                });
                builder.setNegativeButton("cancel" , null);
                builder.show();
                break;
            case R.id.likeus:
                //likeus
                Uri uri = Uri.parse("https://github.com/mojtabagolab");
                Intent intentlikeus = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intentlikeus);
                break;
            case R.id.aboutus:
                //about us
                Intent intentaboutus = new Intent(MainActivity.this, Aboutus.class);
                MainActivity.this.startActivity(intentaboutus);
                break;
            case R.id.exit:
                //exit
                finishAffinity();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            if (doubleback){
                finishAffinity();
                return;
            }
            doubleback = true;
            Toast.makeText(this, "برای خروج مجدد دکمه بازگشت را فشار دهید", 0).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    doubleback = false;

                }
            },2000);
        }

    }
}