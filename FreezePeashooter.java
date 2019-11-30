import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.*;
public class FreezePeashooter extends plant
{
    transient private StackPane s;
    private int timer;
    transient private Group g;
    transient private Image pimg;
    transient private ImageView pimgv;
    Player p;
    public FreezePeashooter(int row,int column,Group g,double X,double Y,Player p)
    {
        super(175,row,column,X,Y,200000,60,"freeze");
        this.g=g;
        timer=900;
        s=new StackPane();
        pimg=new Image("SnowPea.gif",100,100,false,false);
        pimgv=new ImageView(pimg);
        s.getChildren().add(pimgv);
        g.getChildren().add(s);
        s.setLayoutY(Y);
        s.setLayoutX(X);
        this.p=p;
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
        if (timer==1000)
        {
            SnowPea pea=new SnowPea(super.getRow(),super.getCol(),g,super.getX(),super.getY());
            p.addSnow(pea);
            timer=0;
        } 
        else 
        {
            timer++;
        }
    }
}