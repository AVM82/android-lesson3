package org.avm.lesson3.model;

import android.content.Context;

public interface MainModel {
    interface OnAssetsTextReadListener {

        void onSuccess(final String text);

        void onError();
    }

    void readText(Context context, MainModel.OnAssetsTextReadListener onAssetsTextReadListener);
}
