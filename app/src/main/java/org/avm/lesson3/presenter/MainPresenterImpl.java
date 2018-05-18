package org.avm.lesson3.presenter;

import org.avm.lesson3.model.MainModel;
import org.avm.lesson3.view.MainView;

public class MainPresenterImpl implements MainPresenter, MainModel.OnAssetsTextReadListener {
    private MainView mainView;
    private MainModel mainModel;

    public MainPresenterImpl(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void loadText() {
        mainModel.readText(mainView.getContext(), this);
    }

    @Override
    public void onSuccess(String text) {
        mainView.showMessage(text);
    }

    @Override
    public void onError() {
        mainView.showError();
    }
}
