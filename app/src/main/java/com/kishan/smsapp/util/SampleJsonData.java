package com.kishan.smsapp.util;

import com.kishan.smsapp.model.ContactInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jeevan on 13-07-2017.
 *
 * @link jsonDataUtil
 */

public class SampleJsonData {

    private String data = "[{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"},{\"firstName\":\"Roshan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"},{\"firstName\":\"Kisan\",\"lastName\":\"Network\",\"contactNo\":\"9971792703\"},{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9140654947\"},{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"},{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"},{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"},{\"firstName\":\"Jeevan\",\"lastName\":\"Gupta\",\"contactNo\":\"9794051780\"}]";

    public SampleJsonData() {
    }

    public ArrayList<ContactInfo> getData() {
        ArrayList<ContactInfo> temp = new ArrayList<>();
        try {
            JSONArray contactJson = new JSONArray(data);
            for (int i = 0; i < contactJson.length(); i++) {
                JSONObject contactObject = new JSONObject(String.valueOf(contactJson.get(i)));
                ContactInfo info = new ContactInfo(contactObject.getString("firstName"), contactObject.getString("lastName"), contactObject.getString("contactNo"));
                temp.add(info);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
