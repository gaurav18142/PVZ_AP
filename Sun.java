import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.io.*;
import java.util.*;
class Sun
{
    private double X;
    private double Y;
    private double speed;
    transient private Image pimg;
    transient private ImageView pimgv;
    transient private Group g;
    transient private StackPane s;
    private int row;
    private int column;
    Player p;
    public Sun(int row,int column,Group g,double X,double Y,Player p)
    {
        s=new StackPane();
        this.p=p;
        this.row=row;
        this.column = column;
        pimg=new Image("sun.png");
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        this.X=X;
        this.Y=Y;
        this.g=g;
        g.getChildren().add(s);
        s.setLayoutY(this.Y);
        s.setLayoutX(this.X);
        speed=0.4;
        s.setOnMouseClicked(new SunCollector(p,g,this));
    }
    public void removeImage()
    {
        s.getChildren().remove(pimgv);
        g.getChildren().remove(s);
    }
    public int getRow()
    {
        return(row);
    }
    public int getColumn()
    {
        return(column);
    }
    public void setImagePosition(double x,double y)
    {
        X=x;
        Y=y;
    }
    public double getX()
    {
        return(this.X);
    }
    public double getY()
    {
        return(this.Y);
    }
    public void step() 
    {
        if(getY()>=1000.0)
        {
            speed=0.0;
        }
        double newY=getY()+speed;
        setImagePosition(this.X,newY);
        s.setLayoutY(this.Y);
    }
}