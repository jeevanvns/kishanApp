package com.kishan.smsapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kishan.smsapp.R;
import com.kishan.smsapp.model.ContactInfo;
import com.kishan.smsapp.util.ConstantKey;

public class ContactDetails extends BaseActivity {
    private TextView tvPlaceHolder;
    private TextView tvName;
    private TextView tvContact;
    private ContactInfo contactInfo;
    private Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_details;
    }


    @Override
    public boolean showToolbar() {
        return true;
    }

    @Override
    protected void initView() {
        contactInfo = getIntent().getParcelableExtra(ConstantKey.CONTACT_DETAILS);
        tvPlaceHolder = (TextView) findViewById(R.id.tv_name_place_holder);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvContact = (TextView) findViewById(R.id.tv_contact_no);
        btnSendMessage = (Button) findViewById(R.id.btn_send_msg);
    }

    @Override
    protected void initListener() {
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactDetails.this, SendMessageActivity.class).putExtra(ConstantKey.CONTACT_DETAILS, contactInfo));
            }
        });
    }

    @Override
    protected void bindDataWithUi() {
        if (contactInfo == null) {
            return;
        }
        if (contactInfo.getFirstName().length() != 0) {
            char tempPlaceHolder = contactInfo.getFirstName().charAt(0);
            tvPlaceHolder.setText("" + tempPlaceHolder);
        }
        tvName.setText(contactInfo.getFirstName() + " " + contactInfo.getLastName());
        tvContact.setText(contactInfo.getContactNo());
    }


    @Override
    public String setToolbarName() {
        return getResources().getString(R.string.text_toolbar_contact);
    }


}
