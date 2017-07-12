package com.kishan.smsapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kishan.smsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContact extends Fragment {
    private RecyclerView rvContact;

    public FragmentContact() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_contact, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvContact = (RecyclerView) view.findViewById(R.id.rv_contact);
        rvContact.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
