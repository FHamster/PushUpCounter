package client.login;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML BorderPane LoginBorder;

    @FXML Button CountBtn;
    @FXML Button MinimizedBtn;
    @FXML Button SelectBtn;
    @FXML Button CloseBtn;

    @FXML Text TimeView;
    @FXML Text SelectView;

//    DatePicker picker = new DatePicker();

    //日期
    Calendar calendar;

    double xOffset;
    double yOffset;

    /*
        private static LoginController instance;

        private LoginController()
        {
            instance = this;
        }*/
/*
    public static LoginController getInstance()
    {
        return instance;
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        /*窗口拖拽*/
        LoginBorder.setOnMousePressed(event ->
        {
            xOffset = MainLauncher.getPrimaryStageObj().getX() - event.getScreenX();
            yOffset = MainLauncher.getPrimaryStageObj().getY() - event.getScreenY();
            LoginBorder.setCursor(Cursor.CLOSED_HAND);
        });
        LoginBorder.setOnMouseDragged(event ->
        {
            MainLauncher.getPrimaryStageObj().setX(event.getScreenX() + xOffset);
            MainLauncher.getPrimaryStageObj().setY(event.getScreenY() + yOffset);
        });
        LoginBorder.setOnMouseReleased(event -> LoginBorder.setCursor(Cursor.DEFAULT));

        /*日期设置*/
        calendar = Calendar.getInstance();
        String s = String.format("%d年%02d月%02d日",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        TimeView.setText(s);

    }

    /* Terminates Application */
    public void closeSystem()
    {
        Platform.exit();
        System.exit(0);
    }

    public void minimizeWindow()
    {
        MainLauncher.getPrimaryStageObj().setIconified(true);
    }

}
