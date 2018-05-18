package org.avm.lesson3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.avm.lesson3.model.MainModelImpl;
import org.avm.lesson3.presenter.MainPresenter;
import org.avm.lesson3.presenter.MainPresenterImpl;
import org.avm.lesson3.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private EditText editText;
    private Button btnLoadText;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnLoadText = findViewById(R.id.button);
        btnLoadText.setOnClickListener(this);
        mainPresenter = new MainPresenterImpl(this, new MainModelImpl());
    }

    @Override
    public void showMessage(String message) {
        editText.setText(message);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Text was not uploaded", Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void onClick(View view) {
        mainPresenter.loadText();
    }
}
