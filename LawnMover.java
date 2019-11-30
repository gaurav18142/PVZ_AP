import javafx.scene.Group;
import javafx.scene.image.*;
import java.io.*;
import javafx.scene.layout.StackPane;
class LawnMover implements Serializable
{
    private static final long serialVersionUID=42L;
    private boolean used;
    private double X;
    private double Y;
    private final double speed;
    transient private Image lmimg;
    transient private ImageView lmimgv;
    transient private Group g;
    transient private StackPane s;
    private int row;
    private int column;
    LawnMover(int row,int column,Group g,double X,double Y)
    {
        this.g=g;
        this.row=row;
        this.column=column;
        this.X=X;
        this.Y=Y;
        speed=1;
        used=false;
        s=new StackPane();
        lmimg=new Image("mower.png",100,100,false,false);
        lmimgv=new ImageView(lmimg);
        s.getChildren().add(lmimgv);
        g.getChildren().add(s);
        s.setLayoutY(Y);
        s.setLayoutX(X); 
    }
    public void removeImage()
    {
        s.getChildren().remove(lmimgv);
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
        return(X);
    }
    public double getY()
    {
        return(Y);
    }
    public boolean isUsed()
    {
        return(used);
    }
    public void setUsed()
    {
        used=true;
    }
    public void step() 
    {
        used=true;
        if(X>=1100.0)
        {
            removeImage();
        }
        double imageX=getX()+speed;
        setImagePosition(imageX,Y);
        s.setTranslateX(X);
    }
}