import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.*;
public class Peashooter extends plant
{
    transient private StackPane s;
    private int timer;
    transient private Group g;
    transient private Image pimg;
    transient private ImageView pimgv;
    Player p;
    public Peashooter(int row,int column,Group g,double X,double Y,Player p)
    {
        super(100,row,column,X,Y,200000,80,"peashooter");
        this.g=g;
        timer=900;
        s=new StackPane();
        pimg=new Image("shooter.gif",100,100,false,false);
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
            Pea pea=new Pea(super.getRow(),super.getCol(),g,super.getX(),super.getY());
            p.addBullet(pea);
            timer=0;
        } 
        else 
        {
            timer++;
        }
    }
}