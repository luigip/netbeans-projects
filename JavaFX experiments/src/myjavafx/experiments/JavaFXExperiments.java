package myjavafx.experiments;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * My variation on the Colorful Circles demo... with Triangles
 */
public class JavaFXExperiments extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        
        Group triangles = new Group();
        for (int i = 0; i < 100; i++) {
            double ofs = i * 1.0;
            double scale = 1 + i / 50.0;
            Polygon p = new Polygon(20.0 + ofs, 40.0, 100.0 + ofs, 30.0, 43.0 + ofs, 110.0);
            p.setScaleX(scale); p.setScaleY(scale);
            p.setFill(Color.web("pink", 0.2));
            p.setStroke(Color.web("gold", 0.3));
            p.setStrokeWidth(0.5);
            p.setStrokeType(StrokeType.INSIDE);
            
            triangles.getChildren().add(p);
        }
        
        triangles.setEffect(new BoxBlur(8, 8, 2));
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(), new LinearGradient(
                0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.DARKKHAKI),
                new Stop(0.5, Color.web("blue")),
                new Stop(1, Color.BLACK)));
        
        Group blendGroup = 
            new Group(
                new Group(
                    new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), 
                    triangles
                ), 
                colors
            );
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendGroup);
       
        Timeline timeline = new Timeline();
        Timeline spin = new Timeline();
        
        for (Node tri : triangles.getChildren()) {
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, 
                    new KeyValue(tri.translateXProperty(), Math.random() * 1200 - 400),
                    new KeyValue(tri.translateYProperty(), Math.random() * 800 - 200)),
                new KeyFrame(new Duration(20000),
                    new KeyValue(tri.translateXProperty(), Math.random() * 1200 - 400),
                    new KeyValue(tri.translateYProperty(), Math.random() * 800 - 200))
            );
            spin.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(tri.rotateProperty(), 0)),
                new KeyFrame(new Duration(20000), new KeyValue(tri.rotateProperty(), Math.random() * 1440 - 720))
            );
        }
        timeline.play();
        spin.play();
        String[] a = {"1","2","3"};
        System.out.println(a.getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
