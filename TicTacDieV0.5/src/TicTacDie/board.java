package TicTacDie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class board extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root =new Pane();
        Scene scene = new Scene(root,230,230, Color.SILVER);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("TicTACDIE");
        stage.setResizable(false);



        Image boardImage = new Image("TicTacDie/TicTackToe.png");
        ImageView board =new ImageView(boardImage);
        board.setX(5/2);
        board.setY(5/2);
        root.getChildren().add(board);
        
        Button a1= new Button("");
        a1.setLayoutX(2);
        a1.setLayoutY(5);
        a1.setOpacity(0);
        root.getChildren().add(a1);




        stage.show();
    }
}
