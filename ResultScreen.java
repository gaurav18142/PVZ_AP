import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.stage.FileChooser; 
import javafx.geometry.*;
import java.io.*;
import javafx.scene.text.*;
public class ResultScreen extends Application
{
    Scene scene;
    Group g=new Group();
    Group g1=new Group();
    Stage MainStage;
    BorderPane p1=new BorderPane();
    Button b1=new Button("Exit");
    BorderPane p2=new BorderPane();
    Button b2=new Button("Proceed");
    Image mainscreen= new Image("level.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    String path;
    Player p;
    boolean res;
    Text title;
    ResultScreen(Player p,boolean res)
    {
        this.p=p;
        this.res=res;
    }
    @Override
    public void start(Stage theStage) 
    {
        Scene s=genScene();
        theStage.setFullScreen(true);
        theStage.setTitle("Main Menu");
        theStage.getIcons().add(mainscreen);
        theStage.setScene(s);
        theStage.show();
        MainStage=theStage;
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        { 
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
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            {
                try
                { 
                    String name=p.getName();
                    int level=p.getLevel()+1;
                    Player p=new Player(name,level,g1);
                    yard y=new yard(p,g1,false);
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
        b1.setOnAction(event);
        b2.setOnAction(event2);
    }
    public Scene genScene()
    {
        imgv.setImage(mainscreen);
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p2.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        b1.setPrefWidth(350);
        b1.setPrefHeight(60);
        p1.setCenter(b1);
        p2.setLayoutX(730);
        p2.setLayoutY(680);
        b2.setPrefWidth(350);
        b2.setPrefHeight(60);
        p2.setCenter(b2);
        p1.setLayoutX(730);
        p1.setLayoutY(580);
        if(res && p.getLevel()!=5)
        {
            title= new Text("YOU WIN");
            title.setFont(Font.font("Verdana",85));
            title.setFill(Color.RED);
            title.setLayoutX(580);
            title.setLayoutY(280);
            g.getChildren().addAll(imgv,p1,p2,title);
        }
        else if(p.getLevel()==5 && res)
        {
            title= new Text("GAME COMPLETED");
            title.setFont(Font.font("Verdana",85));
            title.setFill(Color.RED);
            title.setLayoutX(580);
            title.setLayoutY(280);
            g.getChildren().addAll(imgv,p1,title);
        }
        else
        {
            title= new Text("YOU LOSE");
            title.setFont(Font.font("Verdana",85));
            title.setFill(Color.RED);
            title.setLayoutX(580);
            title.setLayoutY(280);
            g.getChildren().addAll(imgv,p1,title);
        }
        scene=new Scene(g,550,550,Color.BLACK);
        return(scene);
    }
    public Stage getInStage()
    {
        return(MainStage);
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}