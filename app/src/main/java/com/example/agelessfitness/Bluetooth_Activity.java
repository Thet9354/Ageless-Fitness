package com.example.agelessfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Bluetooth_Activity extends AppCompatActivity {

    private static  final int REQUEST_ENABLE_BT = 0;
    private static  final int REQUEST_DISCOVER_BT = 1;

    TextView mStatusBlueTv, mPairedTv;
    ImageView mBlueIv;
    Button mOnBtn, mOffbtn, mDiscoverBtn, mPairedBtn, btn_done;
    BluetoothAdapter mBlueAdapter;

    private String workouts;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        intent = getIntent();

        initWidget();

        getIntentData();

        initUI();

        pageDirectories();
    }

    private void getIntentData() {
        workouts = intent.getStringExtra("Workout");
        System.out.println(workouts);
    }

    private void pageDirectories() {
        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBlueAdapter.isEnabled()){
                    showToast("Turning ON Bluetooth...");

                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,REQUEST_ENABLE_BT);
                }else{
                    showToast("Bluetooth is already ON");
                }

            }
        });

        mDiscoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBlueAdapter.isDiscovering()){
                    showToast("Make your Device Discoverabble");
                    Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,REQUEST_DISCOVER_BT);
                }

            }
        });
        mOffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBlueAdapter.isEnabled()){
                    mBlueAdapter.disable();
                    showToast("Turning Bluetooth Off");
                    mBlueIv.setImageResource(R.drawable.ic_action_off);
                }else{
                    showToast("Bluetooth is already Off");
                }

            }
        });
        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mBlueAdapter.isEnabled()){
                    mPairedTv.setText("Paired Devices");
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for (BluetoothDevice device: devices){
                        mPairedTv.append("\nDevice: " + device.getName()+ "," +device);
                    }
                }else{
                    showToast("Turn On Bluetooth to get paired devices");
                }

            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Workout_timer.class);
                intent.putExtra("Workout", workouts);
                startActivity(intent);
            }
        });
    }


    private void initUI() {
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        // ngecek apabila bluetooth tersedia atau tida
        if (mBlueAdapter==null){
            mStatusBlueTv.setText("Bluetooth is Not available");
        }else{
            mStatusBlueTv.setText("Bluetooth is  available");
        }

        //pembuatan icon/gambar status bluetooth on atau off

        if (mBlueAdapter.isEnabled()){
            mBlueIv.setImageResource(R.drawable.ic_action_on);
        }else{
            mBlueIv.setImageResource(R.drawable.ic_action_off);
        }

    }

    private void initWidget() {
        mStatusBlueTv   = findViewById(R.id.statusBluetoothTv);
        mPairedBtn      = findViewById(R.id.pairedBtn);
        mBlueIv         = findViewById(R.id.bluetoothIv);
        mOnBtn          = findViewById(R.id.onBtn);
        mOffbtn         = findViewById(R.id.offBtn);
        mDiscoverBtn    = findViewById(R.id.discoverableBtn);
        mPairedTv       = findViewById(R.id.pairedTv);
        btn_done = findViewById(R.id.btn_done);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if (resultCode==RESULT_OK){
                    //keaadaan bluetooth ON
                    mBlueIv.setImageResource(R.drawable.ic_action_on);
                    showToast("Bluetooth is ON");
                }else{
                    showToast("Bluetooth tidak dapat di Aktifkan");
                }
                break;
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}