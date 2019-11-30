import javafx.scene.Group;
import java.io.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
class Wallnut extends plant
{
    private static final long serialVersionUID=42L;
    transient private StackPane s;
    private int timer;
    transient private Group g;
    transient private Image pimg;
    transient private ImageView pimgv;
    public Wallnut(int row,int column,Group g,double X,double Y)
    {
        super(50,row,column,X,Y,50000,0,"Wallnut");
        this.g=g;
        timer=0;
        s=new StackPane();
        pimg=new Image("wallnut.gif",100,100,false,false);
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        g.getChildren().add(s);
        s.setLayoutY(Y);
        s.setLayoutX(X);
    }
    @Override
    public void removeImage()
    {
        s.getChildren().remove(pimgv);
        g.getChildren().remove(s);
    }
    @Override
    public void move()
    {
        
    }
}