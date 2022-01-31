package mojtabagolab.com.applicationketabytoplearn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> {

    private final ArrayList<ObjectOfList> list;
    private final Activity activity;
    private View view;

    public myadapter(ArrayList<ObjectOfList> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (MainActivity.selectusertheme){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_dark, parent, false);
                break;
        }
        return new viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myadapter.viewholder holder, int position) {

        ObjectOfList item = list.get(position);

        holder.textView_item1.setText(item.text);
        holder.textView_item2.setText(item.text2);
        holder.imageView_item.setImageResource(item.resitem);

        if (item.text.equals("لیست علاقه مندی ها")) {
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, ForwardList.class);
                    activity.startActivity(intent);
                }
            });

        }
        if (item.text.equals("غذا های ایرانی")) {
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, iran.class);
                    activity.startActivity(intent);
                }
            });

        }
        if (item.text.equals("غذا های خارجی")) {
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, kharej.class);
                    activity.startActivity(intent);
                }
            });

        }

        switch (item.text) {

            case "خورشت قرمه سبزی":
                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, StudyActivity.class);
                        intent.putExtra("data", "ghorme");
                        activity.startActivity(intent);
                    }
                });

                break;
            case "خورشت قیمه":
                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, StudyActivity.class);
                        intent.putExtra("data", "gheyme");
                        activity.startActivity(intent);
                    }
                });

                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView textView_item1, textView_item2;
        ViewGroup root;
        ImageView imageView_item;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            imageView_item = itemView.findViewById(R.id.imageView_item);
            textView_item1 = itemView.findViewById(R.id.textView_item1);
            textView_item2 = itemView.findViewById(R.id.textView_item2);

        }
    }

    private Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ObjectOfList> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {

                //harchi dos dary ezafe kon
            } else {
                String userInput = constraint.toString().toLowerCase().trim();
                for (ObjectOfList item : G.fulllist) {
                    if (item.text.toLowerCase().contains(userInput)) {
                        filteredList.add(item);
                    }

                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public Filter getFilter() {
        return filter;
    }
}
