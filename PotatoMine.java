import javafx.scene.Group;
import javafx.scene.image.*;
import java.io.*;
import javafx.scene.layout.*;
class PotatoMine extends plant
{
    transient private StackPane s;
    private int timer;
    transient private Group g;
    transient private Image pimg;
    transient private ImageView pimgv;
    public PotatoMine(int row,int column,Group g,double X,double Y)
    {
        super(25,row,column,X,Y,50000,0,"PotatoMine");
        this.g=g;
        timer=0;
        s=new StackPane();
        pimg=new Image("potato.png",100,100,false,false);
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