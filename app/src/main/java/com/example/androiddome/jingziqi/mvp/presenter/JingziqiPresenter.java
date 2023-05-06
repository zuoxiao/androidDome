package com.example.androiddome.jingziqi.mvp.presenter;


import com.example.androiddome.jingziqi.mvp.model.Board;
import com.example.androiddome.jingziqi.mvp.model.Player;
import com.example.androiddome.jingziqi.mvp.view.JingziqiView;

public class JingziqiPresenter {

    private JingziqiView view;
    private Board model;

    public JingziqiPresenter(JingziqiView view) {
        this.view = view;
        this.model = new Board();
    }

    public void onButtonSelected(int row, int col) {
        Player playerThatMoved = model.mark(row, col);

        if(playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString());

            if (model.getWinner() != null) {
                view.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSelected() {
        model.restart();
        view.clearWinnerDisplay();
        view.clearButtons();
    }
}
