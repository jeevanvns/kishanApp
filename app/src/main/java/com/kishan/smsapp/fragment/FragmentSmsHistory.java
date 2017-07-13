package com.kishan.smsapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kishan.smsapp.R;
import com.kishan.smsapp.adapter.SmsHistoryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSmsHistory extends Fragment {


    private SmsHistoryAdapter historyAdapter;

    public FragmentSmsHistory() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_sms_history, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView rvSmsHistory = (RecyclerView) view.findViewById(R.id.rv_sms_history);
        rvSmsHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        historyAdapter = new SmsHistoryAdapter(getContext());
        rvSmsHistory.setAdapter(historyAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (historyAdapter != null) {
            historyAdapter.updateData();
        }
    }
}
