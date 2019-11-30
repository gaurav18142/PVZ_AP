import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import java.net.URL;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.util.*;
import java.util.Timer;
import java.util.ArrayList;  
import java.io.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
public class yard extends Application 
{
    Scene scene;
    BorderPane p1=new BorderPane();
    private TextField Sun;
    Image mainscreen=new Image("h1.jpg",1920,1080,false,false );
    Image peacard=new Image("card_peashooter.png",100,100,false,false );
    Image suncard=new Image("card_sunflower.png",100,100,false,false );
    Image nutcard=new Image("card_wallnut.png",100,100,false,false );
    Image bombcard=new Image("card_potato.png",100,100,false,false );
    Image freezecard=new Image("card_freezepeashooter.png",100,100,false,false );
    Image pea=new Image("shooter.gif",100,100,false,false );
    Image sun=new Image("sunflower.gif",100,100,false,false );
    Image nut=new Image("wallnut.gif",100,100,false,false );
    Image bomb=new Image("potato.png",100,100,false,false );
    Image freeze=new Image("SnowPea.gif",100,100,false,false );
    Image sidebar= new Image("bar.png",600,95,false,false );
    Image barricade=new Image("noentry.png",100,100,false,false);
    ImageView imgv=new ImageView();   
    ImageView imgv1=new ImageView();
    ImageView imgv2=new ImageView();
    ImageView imgv3=new ImageView();
    ImageView imgv4=new ImageView();
    ImageView imgv5=new ImageView();
    ImageView imgv6=new ImageView();
    ImageView imgv7=new ImageView();
    ImageView imgv8=new ImageView();
    ImageView imgv9=new ImageView();
    ImageView imgv10=new ImageView();
    private StackPane Slot1=new StackPane();
    private StackPane Slot2=new StackPane();
    private StackPane Slot3=new StackPane();
    private StackPane Slot4=new StackPane();
    private StackPane Slot5=new StackPane();
    private StackPane Bar1=new StackPane();
    private StackPane Bar2=new StackPane();
    private StackPane Bar3=new StackPane();
    private StackPane Bar4=new StackPane();
    private StackPane woodlabel=new StackPane();
    Button Menu=new Button("Menu");
    ProgressBar bar=new ProgressBar();
    Group g;
    Label amount=new Label();
    Text title;
    Player p;
    boolean saved;
    yard(Player p,Group g,boolean s)
    {
        saved=s;
        this.g=g;
        this.p=p;
        p.setLabel(amount);
        p.setGroup(g);
        title=new Text("Level "+p.getLevel()+"    "+p.getName()+"'s Lawn");
    }
    @Override
    public void start(Stage theStage) throws Exception 
    {
        Scene s=getScene();
        Timer t=new Timer();
        theStage.setFullScreen(true);
        theStage.setTitle("Main Menu");
        theStage.getIcons().add(mainscreen);
        theStage.setScene(s);
        Slot1.setOnDragDetected(new Drag(Slot1,pea));
        Slot2.setOnDragDetected(new Drag(Slot2,sun));
        Slot3.setOnDragDetected(new Drag(Slot3,nut));
        Slot4.setOnDragDetected(new Drag(Slot4,bomb));
        Slot5.setOnDragDetected(new Drag(Slot5,freeze));
        if(!saved)
        {
            LawnMover lm1=new LawnMover(1,0,g,250,175);
            LawnMover lm2=new LawnMover(2,0,g,250,350);
            LawnMover lm3=new LawnMover(3,0,g,250,500);
            LawnMover lm4=new LawnMover(4,0,g,250,700);
            LawnMover lm5=new LawnMover(5,0,g,250,875);
            p.addMower(lm1);
            p.addMower(lm2);
            p.addMower(lm3);
            p.addMower(lm4);
            p.addMower(lm5);
            ZombieWave w=new ZombieWave(g,p.getLevel());
            w.genWave();
            p.setWave(w);
        }
        else
        {
            ArrayList<plant> plants=p.getPlants();
            ArrayList<Zombie> zombies=p.getWave().getWave();
            ArrayList<LawnMover> m=p.getMowers();
            for (plant pl:plants) 
            {
                double x=pl.getX();
                double y=pl.getY();
                int row=pl.getRow();
                int col=pl.getCol();
                if(pl.getPlantName().equals("peashooter"))
                {
                    pl=new Peashooter(row,col,g,x,y,p);
                }
                if(pl.getPlantName().equals("sunflower"))
                {
                    pl=new Sunflower(row,col,g,x,y,p);
                }if(pl.getPlantName().equals("Wallnut"))
                {
                    pl=new Wallnut(row,col,g,x,y);
                }
                if(pl.getPlantName().equals("PotatoMine"))
                {
                    pl=new PotatoMine(row,col,g,x,y);
                }
                if(pl.getPlantName().equals("freeze"))
                {
                    pl=new FreezePeashooter(row,col,g,x,y,p);
                }
            }
            for (Zombie z:zombies) 
            {
                double x=z.getX();
                double y=z.getY();
                int row=z.getRow();
                if(z instanceof Normal)
                {
                    z=new Normal(row,14,g,x,y);
                }
                else
                {
                    z=new Cone(row,14,g,x,y);
                }
            }
            for (LawnMover lm:m) 
            {
                if(!lm.isUsed())
                {
                    double x=lm.getX();
                    double y=lm.getY();
                    int row=lm.getRow();
                    int col=lm.getColumn();
                    lm=new LawnMover(row,col,g,x,y);
                }
            }
        }
        s.setOnDragOver(new DragOver());
        s.setOnDragDropped(new Drop(g,p));
        theStage.show();         
        GamePlay gp=new GamePlay(p,theStage,g,t);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            {
                t.cancel();
                try
                {
                    gamemenu y=new gamemenu(p,gp);
                    y.start(theStage);
                } 
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not initiate game");
                }
                theStage.setFullScreen(true);
            } 
        };
        Menu.setOnAction(event);
        gp.startTimer();
    }
    Scene getScene()
    {
        title.setFont(Font.font("Verdana",40));
        title.setFill(Color.RED);
        title.setLayoutX(580);
        title.setLayoutY(1070);
        Slot1.setId("peashooter");
        Slot2.setId("sunflower");
        Slot3.setId("wallnut");
        Slot4.setId("potatoMine");
        Slot5.setId("freeze");
        IntegerProperty seconds = new SimpleIntegerProperty();
        imgv.setImage(mainscreen);
        imgv1.setImage(sidebar);
        imgv2.setImage(peacard);
        imgv3.setImage(suncard);
        imgv4.setImage(nutcard);
        imgv5.setImage(bombcard);
        imgv6.setImage(freezecard);
        imgv7.setImage(barricade);
        imgv8.setImage(barricade);
        imgv9.setImage(barricade);
        imgv10.setImage(barricade);
        Slot1.getChildren().add(imgv2);
        Slot2.getChildren().add(imgv3);
        Slot3.getChildren().add(imgv4);
        Slot4.getChildren().add(imgv5);
        Slot5.getChildren().add(imgv6);
        Bar1.getChildren().add(imgv7);
        Bar2.getChildren().add(imgv8);
        Bar3.getChildren().add(imgv9);
        Bar4.getChildren().add(imgv10);
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        Menu.setPrefWidth(355);
        Menu.setPrefHeight(65);
        p1.setCenter(Menu);
        p1.setLayoutX(1550);
        p1.setLayoutY(1); 
        amount.setFont(Font.font("Cambria", 20));
        amount.setLayoutX(25);
        amount.setLayoutY(63);
        amount.setPrefWidth(105);
        amount.setPrefHeight(20);
        amount.setText(""+p.getSun());
        amount.setAlignment(Pos.CENTER);
        amount.setStyle("-fx-background-color:WHITE");
        title.setStyle("-fx-background-color:WHITE");
        Slot1.setLayoutX(150);
        Slot2.setLayoutX(250);
        Slot3.setLayoutX(350);
        Slot4.setLayoutX(450);
        Slot5.setLayoutX(550);
        Bar1.setLayoutX(1250);
        Bar1.setLayoutY(175);
        Bar2.setLayoutX(1250);
        Bar2.setLayoutY(325);
        Bar3.setLayoutX(1250);
        Bar3.setLayoutY(700);
        Bar4.setLayoutX(1250);
        Bar4.setLayoutY(875);
        if(p.getLevel()==1)
        {
            g.getChildren().addAll(imgv,amount,imgv1,p1,Slot1,Slot2,title,Bar1,Bar2,Bar3,Bar4);
        }
        if(p.getLevel()==2)
        {
            g.getChildren().addAll(imgv,amount,imgv1,p1,Slot1,Slot2,title,Bar1,Bar4);
        }
        if(p.getLevel()==3)
        {
            g.getChildren().addAll(imgv,amount,imgv1,p1,Slot1,Slot2,Slot3,title,Bar1,Bar4);
        }
        if(p.getLevel()==4)
        {
            g.getChildren().addAll(imgv,amount,imgv1,p1,Slot1,Slot2,Slot3,Slot4,title);
        }
        if(p.getLevel()==5)
        {
            g.getChildren().addAll(imgv,amount,imgv1,p1,Slot1,Slot2,Slot3,Slot4,Slot5,title);
        }
        scene=new Scene(g,1920,1080,Color.BLACK);
        return(scene);
    }
    void runfight()
    {
        
        
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}