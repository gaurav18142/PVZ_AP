import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
public class MainMenu extends Application
{
    Scene scene;
    BorderPane p1=new BorderPane();
    BorderPane p2=new BorderPane();
    BorderPane p3=new BorderPane();
    BorderPane p4=new BorderPane();
    final double CANVAS_WIDTH=550;
    final double CANVAS_HEIGHT=550;
    Image mainscreen= new Image( "wall.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    Button b1=new Button("Start Game");
    Button b2=new Button("Load Game");
    Button b3=new Button("Exit");
    Button b4=new Button("Choose Level");
    Group g=new Group();
    static Stage MainStage;
    String name="";
    int level=1;
    @Override
    public void start(Stage theStage) throws Exception 
    {
        Scene s=genScene();
        theStage.setFullScreen(true);
        theStage.setTitle("Main Menu");
        theStage.getIcons().add(mainscreen);
        theStage.setScene(s);
        MainStage=theStage;
        MainStage.show();
    }
    Scene genScene()
    {
        Scene scene1; 
        imgv.setImage(mainscreen);
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p2.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p3.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        p4.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        b1.setPrefWidth(350);
        b1.setPrefHeight(60);
        p1.setCenter(b1);
        p1.setLayoutX(830);
        p1.setLayoutY(880);
        b2.setPrefWidth(350);
        b2.setPrefHeight(60);
        p2.setCenter(b2);
        p2.setLayoutX(460);
        p2.setLayoutY(930);
        b3.setPrefWidth(350);
        b3.setPrefHeight(60);
        p3.setCenter(b3);
        p3.setLayoutX(1200);
        p3.setLayoutY(930);
        b4.setPrefWidth(350);
        b4.setPrefHeight(60);
        p4.setCenter(b4);
        p4.setLayoutX(830);
        p4.setLayoutY(980);
        g.getChildren().addAll(imgv,p1,p2,p3,p4);
        scene=new Scene(g,550,550,Color.BLACK);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                Name n=new Name(1);
                n.start(MainStage);
                MainStage.setFullScreen(true);
            } 
        };        
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                LevelScreen l=new LevelScreen();
                l.start(MainStage);
                MainStage.setFullScreen(true);
            } 
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                MainStage.close();
            } 
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e) 
            { 
                LoadGame l=new LoadGame();
                l.start(MainStage);
                MainStage.setFullScreen(true);
            } 
        };
        b1.setOnAction(event);
        b4.setOnAction(event1);
        b3.setOnAction(event2);
        b2.setOnAction(event3);
        return(scene);
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}