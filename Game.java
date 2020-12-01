/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paddlegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 *
 * @Marouan Boussif 
 */

public class Game extends Application
{
int sceneWidth = 500;
int sceneHeight = 500;

@Override
public void start(Stage primaryStage)
{

BallPane ballPane = new BallPane();

Scene scene = new Scene(ballPane, 500, 500);

primaryStage.setTitle("paddle for one "); // Set the stage title
primaryStage.setScene(scene);
primaryStage.show();

ballPane.requestFocus();

}
public static void main(String[] args)
{
launch(args);
}
}
