package myjavafx.experiments;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LifeDisplay extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        
        String url = getClass().getResource("/tabletop.png").toString();
        ImageView tabletop = new ImageView(new Image(url));
        tabletop.setPreserveRatio(true);
        tabletop.setFitWidth(scene.getWidth());
        
        
        
        
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
