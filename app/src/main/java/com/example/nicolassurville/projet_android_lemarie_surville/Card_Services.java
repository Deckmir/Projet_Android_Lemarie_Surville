package com.example.nicolassurville.projet_android_lemarie_surville;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class Card_Services extends IntentService {
    private static final String TAG = Card_Services.class.getSimpleName();
    public static final String ACTION_CARDS = "com.example.nicolassurville.projet_android_lemarie_surville.HEARTHSTONE";



    public Card_Services() {
        super("Card_Services");
    }

    public static void startActionCards(Context context){

        Intent intent = new Intent(context,Card_Services.class);
        intent.setAction(ACTION_CARDS);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CARDS.equals(action)) {
                handleActionCards();
            }
        }
    }


    private void handleActionCards() {
        URL url = null;
        try{
            url = new URL("https://raw.githubusercontent.com/Deckmir/Projet_Android_Lemarie_Surville/master/cards.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "Hearthstone.json"));
                Log.d("tag","Hearthstone json downloaded :");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ChamanActivity.HEARTHSTONE_UPDATE));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile(InputStream in,File file){
        try{
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
