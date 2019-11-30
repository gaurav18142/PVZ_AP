import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
public class LevelScreen extends Application
{
    Scene scene;
    Button b1=new Button("Level 1");
    Button b2=new Button("Level 2");
    Button b3=new Button("Level 3");
    Button b4=new Button("Level 4");
    Button b5=new Button("Level 5");
    BorderPane p1=new BorderPane();
    BorderPane p2=new BorderPane();
    BorderPane p3=new BorderPane();
    BorderPane p4=new BorderPane();
    BorderPane p5=new BorderPane();
    Image mainscreen= new Image( "level.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    Group g=new Group();
    Group g1=new Group();
    @Override
    public void start(Stage theStage)
    {
        Scene s=getScene();
        theStage.setFullScreen(true);
        theStage.setTitle("Main Menu");
        theStage.getIcons().add(mainscreen);
        theStage.setScene(s);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            {
                Player p=new Player("Anonymous",1,g1);
                yard y=new yard(p,g1,false);  
                try
                {
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
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                Player p=new Player("Anonymous",2,g1);
                yard y=new yard(p,g1,false);   
                try
                {
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
        b2.setOnAction(event1);
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                Player p=new Player("Anonymous",3,g1);
                yard y=new yard(p,g1,false);    
                try
                {
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
        b3.setOnAction(event2);
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                Player p=new Player("Anonymous",4,g1);
                yard y=new yard(p,g1,false);   
                try
                {
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
        b4.setOnAction(event3);
        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                Player p=new Player("Anonymous",5,g1);
                yard y=new yard(p,g1,false);    
                try
                {
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
        b5.setOnAction(event4);
        theStage.show();
    }
    public Scene getScene()
    {
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p2.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p3.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p4.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p5.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        imgv.setImage(mainscreen);
        b1.setPrefWidth(350);
        b1.setPrefHeight(60);
        p1.setCenter(b1);
        p1.setLayoutX(780);
        p1.setLayoutY(130);
        b2.setPrefWidth(350);
        b2.setPrefHeight(60);
        p2.setCenter(b2);
        p2.setLayoutX(780);
        p2.setLayoutY(280);
        b3.setPrefWidth(350);
        b3.setPrefHeight(60);
        p3.setCenter(b3);
        p3.setLayoutX(780);
        p3.setLayoutY(430);
        b4.setPrefWidth(350);
        b4.setPrefHeight(60);
        p4.setCenter(b4);
        p4.setLayoutX(780);
        p4.setLayoutY(580);
        b5.setPrefWidth(350);
        b5.setPrefHeight(60);
        p5.setCenter(b5);
        p5.setLayoutX(780);
        p5.setLayoutY(730);
        g.getChildren().addAll(imgv,p1,p2,p3,p4,p5);
        scene=new Scene(g,550,550,Color.BLACK);
        return(scene);
    }
}