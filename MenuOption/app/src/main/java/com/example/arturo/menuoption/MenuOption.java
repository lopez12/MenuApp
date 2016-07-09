package com.example.arturo.menuoption;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MenuOption extends ActionBarActivity implements View.OnClickListener{

    Button Boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option);

        Boton = (Button) findViewById(R.id.button);
        Boton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
                String SSID = wifiInfo.getSSID();

                if (SSID.equals("\"UAGEDU\"")) {
                    Toast.makeText(getApplicationContext(), "Connected to: "+SSID, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, DisplayMenu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot Login to WiFi: "+SSID, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
