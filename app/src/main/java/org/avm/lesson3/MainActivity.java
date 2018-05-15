package org.avm.lesson3;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "[MainActivity]";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText.setText(readTextFromAssets(getString(R.string.file_name)));
    }

    private String readTextFromAssets(String filename) {
        String text;
        try(InputStream inputStream = getAssets().open(filename, AssetManager.ACCESS_BUFFER)){
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            text = new String(buffer);
        } catch (IOException e) {
            String errorMessage = getString(R.string.error);
            Log.d(TAG, errorMessage);
            text = errorMessage;
        }
        return text;
    }
}
