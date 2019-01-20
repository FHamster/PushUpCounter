package client.login;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainLauncher extends Application
{

    private static Stage primaryStageObj;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStageObj = primaryStage;
//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("俯卧撑计数器");
        primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("img/icon.jpg").toString()));
        Scene mainScene = new Scene(root);
        mainScene.setRoot(root);
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }


    public static void main(String[] args)
    {
        launch(args);
    }

    public static Stage getPrimaryStageObj()
    {
        return primaryStageObj;
    }
}