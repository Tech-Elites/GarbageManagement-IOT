package com.example.garbageiot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class custom_dustbin_arrayAdaptor extends ArrayAdapter<dustbin_info>
{

    custom_dustbin_arrayAdaptor(Context c, ArrayList<dustbin_info> n)
    {
        super(c,0,n);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_layout, parent, false);
        }
        try {
            dustbin_info d=getItem(position);
            TextView dustbinN=view.findViewById(R.id.dustbinName);
            TextView percentFilled=view.findViewById(R.id.percentFilled);

            dustbinN.setText(d.getDustbinname());
            percentFilled.setText(d.getPercentfilled());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}