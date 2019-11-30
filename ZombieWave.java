import java.util.ArrayList;
import javafx.scene.Group;
import java.util.*;
import java.io.*;
public class ZombieWave implements Serializable
{
    private int level;
    private ArrayList<Zombie> wave=new ArrayList<Zombie>();
    transient Group g;
    private static final long serialVersionUID=42L;
    public ZombieWave(Group g,int level)
    {
        this.g=g;
        this.level=level;
    }
    public ArrayList<Zombie> getWave()
    {
        return(wave);
    }
    public ArrayList<Zombie> genWave()
    {
        if(level>=1)
        {
            Normal n1=new Normal(3,14,g,1500.0,500.0);
            Normal n2=new Normal(3,14,g,2100.0,500.0);
            Normal n3=new Normal(3,14,g,2700.0,500.0);
            Cone c1=new Cone(3,14,g,3300.0,500.0);
            Cone c2=new Cone(3,14,g,3900.0,500.0);
            wave.add(n1);
            wave.add(n2);
            wave.add(n3);
            wave.add(c1);
            wave.add(c2);
        }
        if(level>1)
        {
            Normal n11=new Normal(2,14,g,1500,325);
            Normal n22=new Normal(2,14,g,2100,325);
            Normal n33=new Normal(2,14,g,2700,325);
            Cone c11=new Cone(2,14,g,3300,325);
            Cone c22=new Cone(2,14,g,3900.0,325.0);
            Normal n111=new Normal(4,14,g,1500,700);
            Normal n222=new Normal(4,14,g,2100,700);
            Normal n333=new Normal(4,14,g,2700,700);
            Cone c111=new Cone(4,14,g,3300,700);
            Cone c222=new Cone(4,14,g,3900.0,700.0);
            wave.add(n11);
            wave.add(n22);
            wave.add(n33);
            wave.add(c11);
            wave.add(c22);
            wave.add(n111);
            wave.add(n222);
            wave.add(n333);
            wave.add(c111);
            wave.add(c222);
        }
        if(level<=5 && level>3)
        {
            Normal n11=new Normal(1,14,g,1500,175);
            Normal n22=new Normal(1,14,g,2100,175);
            Normal n33=new Normal(1,14,g,2700,175);
            Cone c11=new Cone(1,14,g,3300,175);
            Cone c22=new Cone(1,14,g,3900.0,175.0);
            Normal n111=new Normal(5,14,g,1500,875);
            Normal n222=new Normal(5,14,g,2100,875);
            Normal n333=new Normal(5,14,g,2700,875);
            Cone c111=new Cone(5,14,g,3300,875);
            Cone c222=new Cone(5,14,g,3900.0,875);
            wave.add(n11);
            wave.add(n22);
            wave.add(n33);
            wave.add(c11);
            wave.add(c22);
            wave.add(n111);
            wave.add(n222);
            wave.add(n333);
            wave.add(c111);
            wave.add(c222);
        }
        for(Zombie z:wave)
        {
            z.setHealth(z.getHealth() + 50*(level-1));
            z.setDamage(z.getDamage() + 10*(level-1));
        }
        return(wave);
    }
    public void setLevel(int level)
    {
        this.level=level;
    }
}