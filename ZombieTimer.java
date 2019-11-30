import javafx.scene.control.*;
import javafx.scene.Group;
class ZombieTimer
{
    private ProgressBar bar;
    private Group g;
    private int X,Y;
    ZombieTimer(Group g,int X,int Y)
    {
        this.g=g;
        this.X=X;
        this.Y=Y;
        bar=new ProgressBar(0);
        bar.setLayoutX(X);
        bar.setLayoutY(Y);
        bar.setPrefWidth(350);
        bar.setPrefHeight(60);
        bar.setStyle("-fx-accent: green;");
        g.getChildren().add(bar);     
    }
    public void setProgress(double x)
    {
        bar.setProgress(x);
    }
    public double getProgress()
    {
        return(bar.getProgress());
    }
}