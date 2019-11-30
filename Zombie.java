import java.io.*;
public abstract class Zombie implements Serializable 
{
    private static final long serialVersionUID=42L;
    private int health;
    private int damage;
    private int row;
    private int column;
    private double X;
    private double Y;
    private double speed;
    private final double OriginalSpeed;
    boolean frozen;
    Zombie(int health,int damage,int row,int column,double X,double Y,double speed,double OriginalSpeed)
    {
        this.health=health;
        frozen=false;
        this.damage=damage;
        this.row=row;
        this.column=column;
        this.X=X;
        this.Y=Y;
        this.speed=speed;
        this.OriginalSpeed=OriginalSpeed;
    }
    public int getRow()
    {
        return(row);
    }
    public void setRow(int row)
    {
        this.row=row;
    }
    public int getCol()
    {
        return(column);
    }
    public void setCol(int column)
    {
        this.column=column;
    }
    public int getHealth()
    {
        return(health);
    }
    public void setHealth(int h)
    {
        health=h;
    }
    public void setPosition(double x,double y)
    {
        X=x;
        Y=y;
    }
    public int getDamage()
    {
        return(damage);
    }
    public double getSpeed()
    {
        return(speed);
    }
    abstract public void step();
    abstract public void removeImage();
    public double getX()
    {
        return(X);
    }
    public void setSpeed(double s)
    {
        speed=s;
    }
    public double getOgSpeed()
    {
        return(OriginalSpeed);
    }
    public double getY()
    {
        return(Y);
    }
    public boolean isFrozen()
    {
        return(frozen);
    }
    public void Freeze()
    {
        frozen=true;
        speed=speed/2;
    }
    public void setDamage(int d)
    {
        damage=d;
    }
}