import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.io.*;
public class Normal extends Zombie
{
    private static final long serialVersionUID=42L;
    transient private StackPane s;
    transient private Group g;
    transient private Image zimg;
    transient private ImageView zimgv;
    public Normal(int row,int column,Group g,double X,double Y)
    {
        super(1200,30,row,column,X,Y,0.05,0.05);
        s=new StackPane();
        this.g=g;
        zimg=new Image("Normal.gif",100,100,false,false);
        zimgv=new ImageView(zimg);
        s.getChildren().add(zimgv);
        g.getChildren().add(s);
        s.setTranslateY((int)Y);
        s.setTranslateX((int)X);
    }
    public boolean isFrozen()
    {
        return(frozen);
    }
    @Override
    public void step()
    {
        double imageX=super.getX()-super.getSpeed();
        super.setPosition(imageX,super.getY());
        s.setTranslateY(super.getY());
        s.setTranslateX(imageX);
    }
    @Override
    public void removeImage()
    {
        s.getChildren().remove(zimgv);
        g.getChildren().remove(s);
    }

}