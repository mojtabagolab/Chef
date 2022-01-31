package mojtabagolab.com.applicationketabytoplearn;
import android.app.Application;

import java.util.ArrayList;

public class G extends Application{

    public static ArrayList<ObjectOfList> fulllist;

    @Override
    public void onCreate() {
        super.onCreate();
        fulllist = new ArrayList<>();





        //irany
        fulllist.add(new ObjectOfList("خورشت قیمه", "خورش قیمه این خورش در میان ...", R.drawable.gheymeh));
        fulllist.add(new ObjectOfList("خورشت قرمه سبزی", "خورشت سبزی از خورشت های ...", R.drawable.ghorme));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));

        //kharegy
        fulllist.add(new ObjectOfList("غذای های ایرانی", "لیست غذای ایرانی", R.drawable.gheymeh));
        fulllist.add(new ObjectOfList("غذای های خارجی", "لیست غذا های خارجی", R.drawable.ghorme));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
        fulllist.add(new ObjectOfList("empty","item is empty",R.drawable.error));
    }
}
