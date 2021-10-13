package com.share4happy.doctinnhantudienthoaidemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.share4happy.doctinnhantudienthoaidemo.R;
import com.share4happy.doctinnhantudienthoaidemo.model.TinNhan;

import java.util.List;

public class AdapterTinNhan extends ArrayAdapter<TinNhan> {
    Activity context;
    int resource;
    @NonNull List<TinNhan> objects;
    public AdapterTinNhan(@NonNull Activity context, int resource, @NonNull List<TinNhan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects  = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView _number = row.findViewById(R.id.txtnumber);
        TextView _time = row.findViewById(R.id.txttime);
        TextView _body = row.findViewById(R.id.txtbody);

        _number.setText(this.objects.get(position).getNumber());
        _time.setText(this.objects.get(position).getTime());
        _body.setText(this.objects.get(position).getBody());
        return row;
    }
}
