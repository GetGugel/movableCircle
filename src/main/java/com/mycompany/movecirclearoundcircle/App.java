package com.mycompany.movecirclearoundcircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private double startX;
    private double startY;
   
    @Override
    public void start(Stage stage) {
        
        double radius=100.0;
        Circle centerCircle= new Circle(300,300,radius);
        centerCircle.setFill(null);
        centerCircle.setStroke(Color.BLACK);
        
        double mRadius=15.0;
        Circle moveCircle=new Circle(300+radius, 300, mRadius);
        moveCircle.setFill(Color.BEIGE);
        
//        moveCircle.setOnMousePressed((MouseEvent me) -> {
//        
//            startX = moveCircle.getCenterX();
//            startY = moveCircle.getCenterX();   
//            
//    });
         moveCircle.setOnMouseDragged((MouseEvent me) -> {
         double endX=me.getSceneX();
         moveCircle.setCenterX(endX);
         
         double endY=me.getSceneY();
         moveCircle.setCenterY(endY);  
         
         
         if(endX>300&endY>300){
               moveCircle.setFill(Color.RED);
         }
         if(endX<300&endY>300){
               moveCircle.setFill(Color.BLUE);
         }
         if(endX<300&endY<300){
               moveCircle.setFill(Color.PURPLE);
         }
         if(endX>300&endY<300){
               moveCircle.setFill(Color.YELLOW);
         }
         
         
         
         });      
        Pane pane = new Pane(centerCircle,moveCircle);
        
        var scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}