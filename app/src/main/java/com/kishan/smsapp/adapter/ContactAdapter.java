package com.kishan.smsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kishan.smsapp.R;
import com.kishan.smsapp.model.ContactInfo;
import com.kishan.smsapp.util.SampleJsonData;

import java.util.ArrayList;

/**
 * Created by SurvivoR on 13-07-2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ContactInfo> list = new ArrayList<>();


    public ContactAdapter(Context mContext) {
        this.mContext = mContext;
        SampleJsonData data = new SampleJsonData();
        list.addAll(data.getData());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
