package com.kishan.smsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        ContactInfo contactInfo = list.get(position);
        if (contactInfo.getFirstName().length() != 0) {
            char tempPlaceHolder = contactInfo.getFirstName().charAt(0);
            holder.tvPlaceHolder.setText(tempPlaceHolder + "");
        }
        holder.tvName.setText(contactInfo.getFirstName() + " " + contactInfo.getLastName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPlaceHolder;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPlaceHolder = (TextView) itemView.findViewById(R.id.tv_place_holder);
        }
    }
}
