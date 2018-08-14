package com.example.duongtainhan555.retrofit.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.retrofit.Model.Monan;
import com.example.duongtainhan555.retrofit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MonanAdapter extends ArrayAdapter<Monan> {
    public MonanAdapter(@NonNull Context context, int resource, @NonNull List<Monan> objects) {
        super(context, resource, objects);
    }
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        if(view==null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.layout_monan,null);
        }
        Monan monan = getItem(position);
        if(monan !=null)
        {
            ImageView imageView = view.findViewById(R.id.imgEating);
            Picasso.get().load(monan.getHinhanh()).into(imageView);
            TextView txtPrice = view.findViewById(R.id.txtPrice);
            txtPrice.setText(monan.getGiamonan());
            TextView txtName = view.findViewById(R.id.txtName);
            txtName.setText(monan.getTenmonan());
        }
        return view;
    }
}
