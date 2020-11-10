package com.example.testingble;

import android.bluetooth.BluetoothDevice;

public class BTLE_Device {

    // Our device and associatied RSSI
    private BluetoothDevice bluetoothDevice;
    private int RSSI;

    // Constructor
    public BTLE_Device(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    // GETTERS AND SETTERS YUH YUH YUH
    public String getAddress() {
        return bluetoothDevice.getAddress();
    }

    public String getName() {
        return this.bluetoothDevice.getName();
    }

    public void setRSSI(int RSSI) {
        this.RSSI = RSSI;
    }

    public int getRSSI() {
        return this.RSSI;
    }
}
