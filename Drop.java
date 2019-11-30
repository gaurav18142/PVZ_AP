import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
public class Drop implements EventHandler<DragEvent> 
{
    Group g;
    Player p;
    public Drop(Group g,Player p)
    {
        this.g=g;
        this.p=p;
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
                    switch(Name) 
                    {
                        case "peashooter":
                                if(p.getSun()>=100)
                                {
                                    plant ps=new Peashooter(row,column,g,X,Y,p);
                                    p.addPlant(ps);
                                    p.setSun(p.getSun()-ps.getCost());
                                }
                        break;
                        case "sunflower":
                                if(p.getSun()>=100)
                                {
                                    plant s=new Sunflower(row,column,g,X,Y,p);
                                    p.addPlant(s);
                                    p.setSun(p.getSun()-s.getCost());
                                }
                        break;
                        case "wallnut":
                                if(p.getSun()>=100)
                                {
                                    plant w=new Wallnut(row,column,g,X,Y);
                                    p.addPlant(w);
                                    p.setSun(p.getSun()-w.getCost());
                                }
                        break;
                        case "potatoMine":
                                if(p.getSun()>=100)
                                {
                                    plant pm=new PotatoMine(row,column,g,X,Y);
                                    p.addPlant(pm);
                                    p.setSun(p.getSun()-pm.getCost());
                                }
                        break;
                        case "freeze":
                                if(p.getSun()>=100)
                                {
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
