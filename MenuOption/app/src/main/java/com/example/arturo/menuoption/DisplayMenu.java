package com.example.arturo.menuoption;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class DisplayMenu extends ActionBarActivity implements View.OnClickListener {

    //ArrayList<String> Account = new ArrayList<String>();
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);

    String Nombre;
    String Precio;

    Button Allavodka;
    Button Rigatonni;
    Button OrderAccount;


    ArrayList<Food> aListClass = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);


        Rigatonni = (Button) findViewById(R.id.button1);
        Rigatonni.setOnClickListener(this);
        Allavodka = (Button) findViewById(R.id.button2);
        Allavodka.setOnClickListener(this);
        OrderAccount = (Button) findViewById(R.id.button3);
        OrderAccount.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_menu, menu);
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
            case R.id.button1:
                    Nombre = "Riggatoni a la Florentina";
                    Precio = "$94";
                    nameValuePairs.add(new BasicNameValuePair(Nombre, Precio));
                // Create Array List of custom Class and add the Created object
                   // aListClass.add(object1);
                    Toast.makeText(getApplicationContext(), "Riggatoni a la Florentina Added" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.button2:
                    Nombre = "Penne a la Vodka";
                    Precio = "$90";
                    nameValuePairs.add(new BasicNameValuePair(Nombre, Precio));
                // Create Array List of custom Class and add the Created object
                    //aListClass.add(object2);
                    Toast.makeText(getApplicationContext(), "Penne a la Vodka Added" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.button3:
                new PostDataAsyncTask().execute();

                break;
        }
    }

    public class PostDataAsyncTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            // do stuff before posting data
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                // 1 = post text data, 2 = post file
                int actionChoice = 1;

                // post a text data
                if(actionChoice==1){
                    postText();
                }

                // post a file
                else{
                    //postFile();
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private void postText(){
            try{
                // url where the data will be posted
                String postReceiverUrl = "http://makingprojects.com.mx/restaurant/mesas.php";
                //Log.v(TAG, "postURL: " + postReceiverUrl);
                //Toast.makeText(getApplicationContext(), "postURL" + postReceiverUrl , Toast.LENGTH_SHORT).show();

                // HttpClient
                HttpClient httpClient = new DefaultHttpClient();

                // post header
                HttpPost httpPost = new HttpPost(postReceiverUrl);

                // add your data

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // execute HTTP post request
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    //Log.d(TAG, "Response: " + responseStr);
                    //Toast.makeText(getApplicationContext(), "Response" + responseStr , Toast.LENGTH_SHORT).show();

                    // you can add an if statement here and do other actions based on the response
                }

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void onPostExecute(String lenghtOfFile) {
            // do stuff after posting data
        }
    }

}
