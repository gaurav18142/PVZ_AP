import java.util.*;
import java.io.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.*;
public class Player implements Serializable
{
    private static final long serialVersionUID=42L;
    private int sun;
    private ArrayList<plant> plants=new ArrayList<plant>();
    private ArrayList<LawnMover> mowers=new ArrayList<LawnMover>(5);
    transient Group g;
    transient Label amount;
    private final String name;
    private int level;
    private ZombieWave wave;
    transient public ArrayList<Pea> bullets=new ArrayList<Pea>();
    transient public ArrayList<SnowPea> snow=new ArrayList<SnowPea>();
    public Player(String name,int level,Group g)
    {
        this.g=g;
        sun=2000;
        this.name=name;
        this.level=level;
    }
    public void setGroup(Group g)
    {
        this.g=g;
    }
    public void setLabel(Label l)
    {
        amount=l;
    }
    public int getSun()
    {
        return(sun);
    }
    public ArrayList<plant> getPlants()
    {
        return(plants);
    }
    public ArrayList<LawnMover> getMowers()
    {
        return(mowers);
    }
    public ArrayList<Pea> getBullets()
    {
        return(bullets);
    }
    public ArrayList<SnowPea> getSnow()
    {
        return(snow);
    }
    public void setSun(int s)
    {
        sun=s;
        g.getChildren().remove(amount);
        Label sunL=new Label(Integer.toString(sun));
        amount=sunL;
        sunL.setFont(new Font(20));
        g.getChildren().add(sunL);
        sunL.setLayoutX(25);
        sunL.setLayoutY(63);
        sunL.setPrefWidth(105);
        sunL.setPrefHeight(20);
        sunL.setAlignment(Pos.CENTER);
        sunL.setStyle("-fx-background-color:WHITE");
    }
    public String getName()
    {
        return(name);
    }
    public int getLevel()
    {
        return(level);
    }
    public void setLevel(int level)
    {
        this.level=level;
    }
    public void addPlant(plant p)
    {
        plants.add(p);
    }
    public void addMower(LawnMover l)
    {
        mowers.add(l);
    }
    public ZombieWave getWave()
    {
        return(wave);
    }
    public void setWave(ZombieWave wave)
    {
        this.wave=wave;
    }
    public void addBullet(Pea pea)
    {
        bullets.add(pea);
    }
    public void addSnow(SnowPea s)
    {
        snow.add(s);
    }
}