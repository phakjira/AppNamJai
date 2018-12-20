package com.example.phakjira.namjai;

import android.content.ClipData;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> arrayListName=new ArrayList<>();
    ArrayList<String> arrayListDescription = new ArrayList<>();
    //String a;
    //String b;
    ArrayList<Integer> flags;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, ArrayList<String> arrayListName, ArrayList<String> arrayListDescription , ArrayList<Integer> flags) {
        this.context = applicationContext;
        this.arrayListName = arrayListName;
        this.arrayListDescription = arrayListDescription;
        this.flags = flags;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return arrayListName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_list_view, null);
        TextView name = (TextView) view.findViewById(R.id.nameGoldie);
        TextView description = (TextView) view.findViewById(R.id.description);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        name.setText(arrayListName.get(i));
        description.setText(arrayListDescription.get(i));
        image.setImageResource(flags.get(i));
        return view;
    }
}
