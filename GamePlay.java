import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class GamePlay
{
    final private double FRAMES_PER_SECOND = 60.0;
    private Player p;
    private boolean zomvictory;
    private boolean planvictory;
    private Stage st;
    public Timer t;
    private Group g;
    int i;
    Sun s;
    Random rand=new Random();
    ZombieTimer zt;
    public GamePlay(Player p,Stage st,Group g,Timer t)
    {
        s=null;
        i=0;
        this.p=p;
        this.st=st;
        zomvictory=false;
        planvictory=false;
        t=new Timer();
        this.g=g;
        this.t=t;
        zt=new ZombieTimer(g,850,0);
    }
    public void startTimer()
    {
        t=new Timer();
        TimerTask tt=new TimerTask()
        {
            public void run()
            {
                Platform.runLater(new Runnable()
                {
                    public void run()
                    {
                        posUpdate();
                    }
                });
            }
        };
        t.schedule(tt,0,1L);
    }
    public void posUpdate()
    {
        int x=0; 
        ArrayList<plant> plants=p.getPlants();
        ArrayList<Zombie> zombies=p.getWave().getWave();
        ArrayList<Pea> bullets=p.getBullets();
        ArrayList<LawnMover> m=p.getMowers();
        ArrayList<SnowPea> snow=p.getSnow();  
        if(i==10000)
        {
            i=0;
            int sX=rand.nextInt((800-400)+1)+400;
            s=new Sun(0,0,g,sX,0,p);
            p.setSun(p.getSun()+50);
        }
        else
        {
            i++;
        }
        if(s!=null)
        {
            s.step();
        } 
        zt.setProgress(zt.getProgress()+(1/50000.0));
        
        for (plant pl:plants) 
        {
            pl.move();
        }
        for (Zombie z:zombies) 
        {
            z.step();
        }
        for (LawnMover lm:m) 
        {
            if(lm.isUsed())
            {
                lm.step();
            }
        }
        for (Pea pea:bullets) 
        {
            pea.step();
        }
        for (SnowPea pea:snow) 
        {
            pea.step();
        }
        Fight(plants,zombies,bullets,m,snow);
    }
    public void useMower(LawnMover m)
    {
        m.step();
    }
    public void Fight(ArrayList<plant> plants,ArrayList<Zombie> zombies,ArrayList<Pea> bullets,ArrayList<LawnMover> m,ArrayList<SnowPea> snow)
    {
        int d=0;
        ArrayList<Zombie> blockZombie=new  ArrayList<Zombie>();
        for (Iterator<Zombie> i2=zombies.iterator();i2.hasNext();) 
        {
            Zombie zombie=i2.next();   
            if (zombie.getX()<270)
            {
                if(!m.get(zombie.getRow()-1).isUsed())
                {
                    m.get(zombie.getRow()-1).setUsed();
                    for (Iterator<Zombie> i3=zombies.iterator();i3.hasNext();) 
                    {
                        Zombie z=i3.next();
                        if(z.getX()<1200 && z.getRow()==zombie.getRow())
                        {
                            z.removeImage();
                            i3.remove();
                        }
                    }
                }
                else
                {  
                    zomvictory=true;
                }
            }
             for (Iterator<plant> i=plants.iterator();i.hasNext();) 
             {
                 plant pl=i.next();
                 int prow=pl.getRow();
                 double pX=pl.getX();
                 int zrow=zombie.getRow();
                 double zX=zombie.getX();
                 if(pl.getPlantName().equals("peashooter"))
                 {
                     for (Iterator<Pea> i4=bullets.iterator();i4.hasNext();)
                     {
                         Pea pea=i4.next();
                         int peaRow=pea.getRow();
                         double peaX=pea.getX();
                         if(prow==peaRow && peaRow==zrow && (-1*pea.getX()+zombie.getX())<=20 && zombie.getX()<1200)
                         {
                             System.out.println("d");
                             pea.removeImage();
                             zombie.setHealth(zombie.getHealth()-pl.getDamage());
                             i4.remove();
                             if(zombie.getHealth()<=0)
                             {
                                 zombie.removeImage();
                                 i2.remove();
                             }
                         }
                     }
                 }
                 if(pl.getPlantName().equals("freeze"))
                 {
                     for (Iterator<SnowPea> i4=snow.iterator();i4.hasNext();)
                     {
                         SnowPea pea=i4.next();
                         int peaRow=pea.getRow();
                         double peaX=pea.getX();
                         if(prow==peaRow && peaRow==zrow && (-1*pea.getX()+zombie.getX())<=20 && zombie.getX()<1330)
                         {
                             System.out.println("d");
                             pea.removeImage();
                             zombie.setHealth(zombie.getHealth()-pl.getDamage());
                             if(!zombie.isFrozen())
                             {
                                 zombie.Freeze();
                             }
                             i4.remove();
                             if(zombie.getHealth()<=0)
                             {
                                 zombie.removeImage();
                                 i2.remove();
                             }
                         }
                     }
                 }
                  if(pl.getY()==zombie.getY() && pX==(int)zX)
                  {
                      if(pl.getPlantName().equals("PotatoMine"))
                      {
                          pl.removeImage();
                          i.remove();
                          zombie.removeImage();
                          i2.remove();
                      }
                      else
                      {
                      zombie.setSpeed(0);
                      blockZombie.add(zombie);
                      pl.setHealth(pl.getHealth()-zombie.getDamage());
                      if(pl.getHealth()<=0)
                      {
                          d=1;
                          zombie.setSpeed(zombie.getOgSpeed());
                      }
                    }
                  }
                  if(d==1)
                  {
                      pl.removeImage();
                      i.remove();
                  }
                  d=0;
                }
            }
            if (p.getWave().getWave().isEmpty())
            {
                planvictory=true;
            }  
            Result();
    }
    public void Result()
    {
        if (planvictory) 
        {
            ResultScreen r=new ResultScreen(p,true);
            try 
            {
                t.cancel();
                r.start(st);
                st.setFullScreen(true);
            } 
            catch (Exception e) 
            {

            }
        }
        if (zomvictory)
        {
            ResultScreen r=new ResultScreen(p,false);
            try
            {
                t.cancel();
                r.start(st);
                st.setFullScreen(true);
            } catch (Exception e)
            {

            }
        }
    }
}