import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
import java.io.*;
import java.util.Timer;
public class gamemenu extends Application
{
    Scene scene;
    Button b1=new Button("Save and Exit");
    Button b2=new Button("Exit");
    Button b3=new Button("Restart Level");
    BorderPane p1=new BorderPane();
    BorderPane p2=new BorderPane();
    BorderPane p3=new BorderPane();
    Image mainscreen= new Image("gamemenu.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    Group g=new Group();
    Group g1=new Group();
    Player p;
    GamePlay gp;
    gamemenu(Player p,GamePlay gp)
    {
        this.p=p;
        this.gp=gp;
        gp.t.cancel();
    }
    @Override
    public void start(Stage theStage) throws IOException
    {
        Scene s=getScene();
        theStage.setFullScreen(true);
        theStage.setTitle("Main Menu");
        theStage.getIcons().add(mainscreen);
        theStage.setScene(s);
        EventHandler<ActionEvent> event=new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            {          
                try
                {
                    Player p1=new Player(p.getName(),p.getLevel(),g1);
                    yard y=new yard(p1,g1,false);
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
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {
                try
                { 
                    MainMenu w=new MainMenu();
                    w.start(theStage);
                    theStage.setFullScreen(true);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not initiate game");
                }
            } 
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {
                ObjectOutputStream out=null;
                try
                {
                    out=new ObjectOutputStream(new FileOutputStream("Profiles/"+p.getName()+".txt"));
                    out.writeObject(p);
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not SAVE");
                }
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not SAVE");
                }
                try
                { 
                    MainMenu w=new MainMenu();
                    w.start(theStage);
                    theStage.setFullScreen(true);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not initiate game");
                }
            } 
        };
        b1.setOnAction(event2);
        b2.setOnAction(event1);
        b3.setOnAction(event);
        theStage.show();
    }
    public Scene getScene()
    {
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p2.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p3.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        imgv.setImage(mainscreen);
        b1.setPrefWidth(350);
        b1.setPrefHeight(60);
        p1.setCenter(b1);
        p2.setLayoutX(830);
        p2.setLayoutY(930);
        b2.setPrefWidth(350);
        b2.setPrefHeight(60);
        p2.setCenter(b2);
        p1.setLayoutX(830);
        p1.setLayoutY(800);
        b3.setPrefWidth(350);
        b3.setPrefHeight(60);
        p3.setCenter(b3);
        p3.setLayoutX(830);
        p3.setLayoutY(670);
        g.getChildren().addAll(imgv,p1,p2,p3);
        scene=new Scene(g,550,550,Color.BLACK);
        return(scene);
    }
}