package org.avm.lesson3.view;

import android.content.Context;

public interface MainView {

    void showMessage(String message);

    void showError();

    Context getContext();
}
