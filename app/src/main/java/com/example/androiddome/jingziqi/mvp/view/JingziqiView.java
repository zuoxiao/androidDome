package com.example.androiddome.jingziqi.mvp.view;

public interface JingziqiView {
    void showWinner(String winningPlayerDisplayLabel);
    void clearWinnerDisplay();
    void clearButtons();
    void setButtonText(int row, int col, String text);
}
