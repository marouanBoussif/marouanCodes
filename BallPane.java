/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paddlegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Marouan Boussif 
 */
public class BallPane extends Pane
{
    int sceneWidth = 500;
int sceneHeight = 500;
public double radius = 20;
private double x = radius, y = radius;
private double dx = 1, dy = 1;
private final Circle circle = new Circle(x, y, radius);
private final Timeline animation;
// Pane pane = new Pane();

public int lost = 20;
public int Streak = 0;
public int missStreak = 0;
private double length = 140;
private double width = 30;
public double paddleX = sceneWidth / 2 - length / 2;
public final double paddleY = sceneHeight - width;
public Rectangle paddle = new Rectangle(paddleX, paddleY, length, width);

public BallPane()
{
    // set color and add the cirlcle
circle.setFill(Color.ORANGE); 
getChildren().add(circle); 

paddle.setFill(Color.RED);
paddle.setStroke(Color.RED);
paddle.setOnMouseDragged(e ->
{
paddle.setX(e.getX());
}
);

getChildren().add(paddle);
// Create an animation for moving the ball
animation = new Timeline(
new KeyFrame(Duration.millis(5), e -> moveBall()));
animation.setCycleCount(Timeline.INDEFINITE);
  // animation 
animation.play();
}

public void play()
{
animation.play();
}

public void pause()
{
animation.pause();
}

public void increaseSpeed()
{
animation.setRate(animation.getRate() + 0.1);
}

public void decreaseSpeed() {
animation.setRate(
animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
}

public DoubleProperty rateProperty()
{
return animation.rateProperty();
}

public void increasePaddleLength()
{
paddle.setWidth(100 * 2);
}

protected void moveBall()
{
double circX = circle.getCenterX();
double circY = circle.getCenterY() + radius;
double padY = paddle.getY();
double padX = paddle.getX();
  
Text text = new Text();

if (x < radius || x > sceneWidth - radius)
{
dx *= -1;
}
if (y < radius || y > sceneHeight - radius)
{       dx *= -1;

    x = getWidth() / 2;
            y = 50;
            dx *= -1;
           
dy *= -1;
}

if (y > sceneHeight - radius)
{
--lost;

//   Text textscore= new Text(100, 30, STYLESHEET_MODENA);
//textscore.setText("GAME OVER");


x = (int) (radius + Math.random() * 300);
y = radius;
circle.setCenterX(x);
circle.setCenterY(y);
++missStreak;
Streak = 0;
setDifficulty(Streak, missStreak);
}

if (circY == padY && (circX >= padX && circX <= (padX + length)))
{
missStreak = 0;
++Streak;
setDifficulty(Streak, missStreak);
dy *= -1;
  
if (circX > sceneWidth / 2)
{
x -= sceneWidth / 4;
}
else
{
x += sceneWidth / 4;
}
}

x += dx;
y += dy;
circle.setCenterX(x);
circle.setCenterY(y);
}

public void setDifficulty(int hitStreak, int lossStreak)
{
switch (hitStreak)
{
case 10:
    
circle.setRadius(radius-=5);
increaseSpeed();
    
break;
case 5:    
circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
break;
}

switch (lossStreak)
{
case 3:
paddle.setWidth(length += 10);
circle.setRadius(radius +=5);
break;

}
}

public void dragMouse()
{
paddle.setOnMouseDragged(e ->
{
paddle.setX(e.getX());

if (paddle.getX() <= 0)
{
paddle.setX(0);
}

if (paddle.getX() + length >= sceneWidth)
{
paddle.setX(sceneWidth - length);
}
});
}
}

/**
* @param args the command line arguments
*/
