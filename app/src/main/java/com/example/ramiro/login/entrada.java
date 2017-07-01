package com.example.ramiro.login;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class entrada extends AppCompatActivity {

    GifImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        gif = (GifImageView) findViewById(R.id.gif_image);
        new RetrieveByteArray().execute("https://media.giphy.com/media/d30mgvM8QxyQE/giphy.gif");
        gif.startAnimation();
    }



        class RetrieveByteArray extends AsyncTask<String,Void,byte[]> {

            @Override
            protected byte[] doInBackground(String... params) {
                try {
                    URL url = new URL(params[0]);
                    HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
                    if (Connection.getResponseCode() == 200) {
                        InputStream in = new BufferedInputStream(Connection.getInputStream());
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        int nread;
                        byte[] data = new byte[10240];
                        while ((nread = in.read(data,0,data.length)) != -1) {
                            buffer.write(data,0,nread);
                        }
                        buffer.flush();
                        return buffer.toByteArray();
                    }
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(byte[] bytes) {
                super.onPostExecute(bytes);
                gif.setBytes(bytes);
            }
        }

}
