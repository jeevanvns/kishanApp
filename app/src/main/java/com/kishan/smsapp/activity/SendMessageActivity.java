package com.kishan.smsapp.activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kishan.smsapp.R;
import com.kishan.smsapp.model.ContactInfo;
import com.kishan.smsapp.model.SmsHistoryInfo;
import com.kishan.smsapp.util.ConstantKey;
import com.kishan.smsapp.util.DbHelper;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SendMessageActivity extends BaseActivity {
    private TextView tvOtp;
    private Button btnSend;
    private TextView tvTo;
    private ContactInfo contactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean showToolbar() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_send_message;
    }

    @Override
    protected void initView() {
        contactInfo = getIntent().getParcelableExtra(ConstantKey.CONTACT_DETAILS);
        tvOtp = (TextView) findViewById(R.id.tv_otp_text);
        btnSend = (Button) findViewById(R.id.btn_send_msg);
        tvTo = (TextView) findViewById(R.id.tv_to);

    }

    @Override
    protected void initListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contactInfo != null) {
                    sendSms(contactInfo.getContactNo(), (getResources().getString(R.string.text_otp) + tvOtp.getText().toString()));
                }
            }
        });
    }

    @Override
    protected void bindDataWithUi() {
        int randomNumber = getRandomNumber(900000, 100000);
        tvOtp.setText("" + randomNumber);
        if (contactInfo != null) {
            tvTo.setText(contactInfo.getContactNo());
        }

    }


    private void sendSms(String toPhoneNumber, String message) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        OkHttpClient client = new OkHttpClient();
        String url = "https://control.msg91.com/api/sendhttp.php?authkey=" +
                ConstantKey.API_KEY_MSG91 +
                "&mobiles=" + toPhoneNumber +
                "&message=+" + message +
                "&sender=" + ConstantKey.ORIGIN +
                "&route=4&country=91";
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                DbHelper dbHelper = new DbHelper(SendMessageActivity.this);
                SmsHistoryInfo smsHistoryInfo = new SmsHistoryInfo((contactInfo.getFirstName() + contactInfo.getLastName()), toPhoneNumber, message);
                dbHelper.addAction(smsHistoryInfo);
                bindDataWithUi();
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
