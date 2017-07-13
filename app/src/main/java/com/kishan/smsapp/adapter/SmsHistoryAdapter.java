package com.kishan.smsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kishan.smsapp.R;
import com.kishan.smsapp.model.SmsHistoryInfo;
import com.kishan.smsapp.util.DbHelper;

import java.util.ArrayList;

/**
 * Created by Jeevan on 7/13/2017.
 */

public class SmsHistoryAdapter extends RecyclerView.Adapter<SmsHistoryAdapter.ViewHolder> {

    private DbHelper dbHelper;
    private Context mContext;
    private ArrayList<SmsHistoryInfo> list = new ArrayList<>();

    public SmsHistoryAdapter(Context mContext) {
        this.mContext = mContext;
        dbHelper = new DbHelper(mContext);
        list = dbHelper.getHistoryReport();
    }


    public void updateData() {
        list = new ArrayList<>();
        list = dbHelper.getHistoryReport();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_sms_history, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SmsHistoryInfo smsHistoryInfo = list.get(position);
        if (smsHistoryInfo.getName().length() != 0) {
            char c = smsHistoryInfo.getName().charAt(0);
            holder.tvPlaceHolderText.setText("" + c);
        }
        holder.tvName.setText(smsHistoryInfo.getName());
        holder.tvMsg.setText(smsHistoryInfo.getMsg());
        holder.tvTime.setText(smsHistoryInfo.getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMsg;
        private TextView tvPlaceHolderText;
        private TextView tvTime;

        private ViewHolder(View itemView) {
            super(itemView);
            tvPlaceHolderText = (TextView) itemView.findViewById(R.id.tv_name_place_holder);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvMsg = (TextView) itemView.findViewById(R.id.tv_msg);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
