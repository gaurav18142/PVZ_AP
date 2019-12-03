import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;
import javafx.scene.image.*;
public class Drop implements EventHandler<DragEvent> 
{
    Group g;
    Player p;
    StackPane s1;
    StackPane s2;
    StackPane s3;
    StackPane s4;
    StackPane s5;
    public Drop(Group g,Player p,StackPane s1,StackPane s2,StackPane s3,StackPane s4,StackPane s5)
    {
        this.g=g;
        this.p=p;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
        this.s5=s5;
    }
    public void handle(DragEvent event) 
    {
        int row=0;
        int column=0;
        String Name=event.getDragboard().getString();
        boolean addX=false;
        boolean addY=false;
        int X=0,Y=0;
        if (event.getX()>=350 && event.getX() <= 1400) 
        {
            if (event.getY() >= 150 && event.getY()<=1050) 
            {
                if (event.getY() >= 150 && event.getY() <= 250 && p.getLevel()>3)
                {
                    row=1;
                    Y=175;
                    addY = true;
                }
                else if (event.getY() >= 325 && event.getY() <= 450 && p.getLevel()>1)
                {
                    row=2;
                    Y=325;
                    addY = true;
                }
                else if (event.getY() >= 451 && event.getY() <= 625)
                {
                    row=3;
                    Y=500;
                    addY=true;
                }
                else if (event.getY() >= 650 && event.getY() <= 750 && p.getLevel()>1)
                {
                    row=4;
                    Y=700;
                    addY=true;
                }
                else if (event.getY() >= 800 && event.getY() <= 1050 && p.getLevel()>3)
                {
                    row=5;
                    Y=875;
                    addY=true;
                }
                if (event.getX() >= 300 && event.getX() <= 450)
                {
                    column=1;
                    X=350;
                    addX=true;
                }
                else if (event.getX() <= 550)
                {
                    column=2;
                    X=475;
                    addX=true;
                }
                else if (event.getX() <= 650)
                {
                    column=3;
                    X=575;
                    addX=true;
                }
                else if (event.getX() <= 750)
                {
                    column=4;
                    X=675;
                    addX=true;
                }
                else if (event.getX() <= 900)
                {
                    column=5;
                    X=800;
                    addX=true;
                }
                else if (event.getX() <= 1000)
                {
                    column=6;
                    X=900;
                    addX=true;
                }
                else if (event.getX()<=1100)
                {
                    column=7;
                    X=1000;
                    addX=true;
                }
                else if (event.getX()<=1200)
                {
                    column=8;
                    X=1125;
                    addX=true;
                }
                else if (event.getX()<=1300)
                {
                    column=9;
                    X=1250;
                    addX=true;
                }
                boolean add=true;
                for (plant p1 : p.getPlants()) 
                {
                    if (p1.getRow()==row && p1.getCol()==column) 
                    {
                        add=false;
                    }
                }
                if (addX && addY && add) 
                {
                    StackPane d1=new StackPane();
                    StackPane d2=new StackPane();
                    StackPane d3=new StackPane();
                    StackPane d4=new StackPane();
                    StackPane d5=new StackPane();
                    ImageView imgv6=new ImageView();
                    ImageView imgv2=new ImageView();
                    ImageView imgv3=new ImageView();
                    ImageView imgv4=new ImageView();
                    ImageView imgv5=new ImageView();
                    Image peacard=new Image("card_peashooter_low.png",100,100,false,false );
                    Image suncard=new Image("card_sunflower_low.png",100,100,false,false );
                    Image nutcard=new Image("card_wallnut_low.png",100,100,false,false );
                    Image bombcard=new Image("card_potato_low.png",100,100,false,false );
                    Image freezecard=new Image("SnowButD.png",100,100,false,false );
                    imgv2.setImage(peacard);
                    imgv3.setImage(suncard);
                    imgv4.setImage(nutcard);
                    imgv5.setImage(bombcard);
                    imgv6.setImage(freezecard);
                    d1.getChildren().add(imgv2);
                    d2.getChildren().add(imgv3);
                    d3.getChildren().add(imgv4);
                    d4.getChildren().add(imgv5);
                    d5.getChildren().add(imgv6);
                    d1.setLayoutX(150);
                    d2.setLayoutX(250);
                    d3.setLayoutX(350);
                    d4.setLayoutX(450);
                    d5.setLayoutX(550);
                    switch(Name) 
                    {
                        case "peashooter":
                                if(p.getSun()>=100)
                                {
                                    g.getChildren().add(d1);
                                    s1.setVisible(false);
                                    PauseTransition pt = new PauseTransition(Duration.seconds(7));
                                    pt.setOnFinished(e -> 
                                    {
                                        d1.setVisible(false);
                                        s1.setVisible(true);
                                    }
                                    );
                                    pt.play();
                                    plant ps=new Peashooter(row,column,g,X,Y,p);
                                    p.addPlant(ps);
                                    p.setSun(p.getSun()-ps.getCost());
                                }
                        break;
                        case "sunflower":
                                if(p.getSun()>=50)
                                {
                                    s2.setVisible(false);
                                    g.getChildren().add(d2);
                                    PauseTransition pt = new PauseTransition(Duration.seconds(5));
                                    pt.setOnFinished(e -> 
                                    {
                                        s2.setVisible(true);
                                        d2.setVisible(false);
                                    }
                                    );
                                    pt.play();
                                    plant s=new Sunflower(row,column,g,X,Y,p);
                                    p.addPlant(s);
                                    p.setSun(p.getSun()-s.getCost());
                                }
                        break;
                        case "wallnut":
                                if(p.getSun()>=50)
                                {
                                    s3.setVisible(false);
                                    g.getChildren().add(d3);
                                    PauseTransition pt = new PauseTransition(Duration.seconds(10));
                                    pt.setOnFinished(e -> 
                                    {
                                        s3.setVisible(true);
                                        d3.setVisible(false);
                                    }
                                    );
                                    pt.play();
                                    plant w=new Wallnut(row,column,g,X,Y);
                                    p.addPlant(w);
                                    p.setSun(p.getSun()-w.getCost());
                                }
                        break;
                        case "potatoMine":
                                if(p.getSun()>=25)
                                {
                                    s4.setVisible(false);
                                    g.getChildren().add(d4);
                                    PauseTransition pt = new PauseTransition(Duration.seconds(5));
                                    pt.setOnFinished(e -> 
                                    {
                                        s4.setVisible(true);
                                        d4.setVisible(false);
                                    }
                                    );
                                    pt.play();
                                    plant pm=new PotatoMine(row,column,g,X,Y);
                                    p.addPlant(pm);
                                    p.setSun(p.getSun()-pm.getCost());
                                }
                        break;
                        case "freeze":
                                if(p.getSun()>=175)
                                {
                                    s5.setVisible(false);
                                    g.getChildren().add(d5);
                                    PauseTransition pt = new PauseTransition(Duration.seconds(5));
                                    pt.setOnFinished(e -> 
                                    {
                                        s5.setVisible(true);
                                        d5.setVisible(false);
                                    }
                                    );
                                    pt.play();
                                    plant fp=new FreezePeashooter(row,column,g,X,Y,p);
                                    p.addPlant(fp);
                                    p.setSun(p.getSun()-fp.getCost());
                                }
                        break;
                    }
                }
            }
        }
    }

}
