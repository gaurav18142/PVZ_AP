import javafx.scene.Group;
import javafx.scene.image.*;
import java.io.*;
import javafx.scene.layout.*;
public class Sunflower extends plant
{
    transient private StackPane s;
    private int timer;
    transient private Group g;
    transient private Image pimg;
    transient private ImageView pimgv;
    Player p;
    public Sunflower(int row,int column,Group g,double X,double Y,Player p)
    {
        super(50,row,column,X,Y,50000,0,"sunflower");
        this.p=p;
        s=new StackPane();
        timer=0;
        this.g=g;
        pimg=new Image("sunflower.gif",100,100,false,false);
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        g.getChildren().add(s);
        s.setLayoutX(X);
        s.setLayoutY(Y);
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
        if (timer==5000)
        {
            timer=0;
            Sun s=new Sun(super.getRow(),super.getCol(),g,super.getX(),super.getY(),p);
            p.setSun(p.getSun()+50);
        } 
        else 
        {
            timer++;
        }
    }
}