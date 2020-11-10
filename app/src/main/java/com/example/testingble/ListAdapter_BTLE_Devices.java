package com.example.testingble;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter_BTLE_Devices extends ArrayAdapter<BTLE_Device> {

    // Just a random Activity, doing this to test things out hehe
    private Activity activity;
    private int layoutResourceID;
    private ArrayList<BTLE_Device> devices;

    public ListAdapter_BTLE_Devices(Activity activity, int layoutResourceID, ArrayList<BTLE_Device> devices) {
        super(activity.getApplicationContext(), layoutResourceID, devices);

        // Then do the normal things
        this.activity = activity;
        this.layoutResourceID = layoutResourceID;
        this .devices = devices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceID, parent, false);
        }

        // Get the associated device and all information out of that device.
        BTLE_Device device = devices.get(position);
        String name = device.getName();
        String address = device.getAddress();
        int rssi = device.getRSSI();

        // TextView associated with this given device. This is for a single device
        TextView tv = null;

        tv = (TextView) convertView.findViewById(R.id.tv_name);
        if (name != null && name.length() > 0) {
            tv.setText(device.getName());
        }
        else {
            tv.setText("No Name");
        }

        tv = (TextView) convertView.findViewById(R.id.tv_rssi);
        tv.setText("RSSI: " + Integer.toString(rssi));

        tv = (TextView) convertView.findViewById(R.id.tv_macaddr);
        if (address != null && address.length() > 0) {
            tv.setText(device.getAddress());
        }
        else {
            tv.setText("No Address");
        }

        return convertView;
    }
}
