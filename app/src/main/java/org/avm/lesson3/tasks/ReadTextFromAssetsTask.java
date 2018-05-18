package org.avm.lesson3.tasks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;

public class ReadTextFromAssetsTask extends AsyncTask<String, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private Context context;

    public ReadTextFromAssetsTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... fileName) {
        try (InputStream inputStream = context.getAssets().open(fileName[0], AssetManager.ACCESS_BUFFER)) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String text) {
        super.onPostExecute(text);

    }
}
