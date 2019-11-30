import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import java.io.*;
class Pea 
{
    private double X;
    private static final long serialVersionUID=42L;
    private double Y;
    private double speed;
    transient private Image pimg;
    transient private ImageView pimgv;
    transient private Group g;
    transient private StackPane s;
    private int row;
    private int column;
    public Pea(int row, int column, Group g,double X,double Y)
    {
        s=new StackPane();
        this.row=row;
        this.column = column;
        pimg=new Image("pea.png");
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        this.X=X;
        this.Y=Y;
        this.g=g;
        this.g.getChildren().add(s);
        s.setLayoutY(this.Y);
        s.setLayoutX(this.X);
        speed=0.5;
    }
    public void LoadContents(Group g)
    {
        s=new StackPane();
        this.g=g;
        pimg=new Image("pea.png");
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        g.getChildren().add(s);
        s.setLayoutY(this.Y);
        s.setLayoutX(this.X);
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
        return(X);
    }
    public double getY()
    {
        return(Y);
    }
    public void step() 
    {
        if(getX()>=1350.0)
        {
            removeImage();
        }
        double newX=getX()+speed;
        setImagePosition(newX,Y);
        s.setLayoutY(this.Y);
        s.setLayoutX(this.X);
    }
}