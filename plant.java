import java.io.*;
public abstract class plant implements Serializable
{
    private static final long serialVersionUID=42L;
    private int row,column,health;
    private final int damage;
    private final int cost;
    private double X,Y;
    String name;
    plant(int cost,int row,int column,double X,double Y,int health,int damage,String name)
    {
        this.cost=cost;
        this.row=row;
        this.column=column;
        this.health=health;
        this.damage=damage;
        this.name=name;
        this.X=X;
        this.Y=Y;
    }
    public int getHealth()
    {
        return(health);
    }
    public void setHealth(int h)
    {
        this.health=h;
    }
    public int getDamage()
    {
        return(damage);
    }
    public int getCost()
    {
        return(cost);
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
    public double getX()
    {
        return(X);
    }
    public void setX(double X)
    {
        this.X=X;
    }
    public double getY()
    {
        return(Y);
    }
    public void setY(double Y)
    {
        this.Y=Y;
    }
    public String getPlantName()
    {
        return(name);
    }
    abstract public void move();
    abstract public void removeImage();
}