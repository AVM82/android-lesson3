package org.avm.lesson3.model;

import android.content.Context;

import org.avm.lesson3.R;
import org.avm.lesson3.tasks.ReadTextFromAssetsTask;

import java.util.concurrent.ExecutionException;

public class MainModelImpl implements MainModel {

    public void readText(Context context, MainModel.OnAssetsTextReadListener onAssetsTextReadListener) {
        try {
            String text = new ReadTextFromAssetsTask(context)
                    .execute(context.getString(R.string.file_name))
                    .get();
            if (text != null) {
                onAssetsTextReadListener.onSuccess(text);
            }
            else {
                onAssetsTextReadListener.onError();
            }
        } catch (InterruptedException | ExecutionException e) {
            onAssetsTextReadListener.onError();
        }
    }
}
