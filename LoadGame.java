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
public class LoadGame extends Application
{
    Scene scene;
    Group g=new Group();
    Group g1=new Group();
    Stage MainStage;
    BorderPane p1=new BorderPane();
    Button b1=new Button("Choose Profile");
    BorderPane p2=new BorderPane();
    Button b2=new Button("Proceed");
    Image mainscreen= new Image("level.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    String path;
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
               FileChooser f=new FileChooser();
               File defaultDirectory = new File("D:/AP_Deadline_3/Profiles");
               f.setInitialDirectory(defaultDirectory);
               FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
               f.getExtensionFilters().add(extFilter);
               File file=f.showOpenDialog(theStage);
               path=file.getPath();
               b2.setDisable(false);
               System.out.println(path);
            } 
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() 
        { 
            public void handle(ActionEvent e)
            {
                ObjectInputStream in=null;
                Player p=null;
                try
                {
                    in=new ObjectInputStream(new FileInputStream(path));
                    p=(Player)in.readObject();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not load");
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not load");
                }
                try
                {
                    in.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                    System.err.println("Can not load");
                }
                try
                {
                    yard y=new yard(p,g1,true);
                    y.start(theStage);
                    theStage.setFullScreen(true);
                }
                catch(Exception e3)
                {
                    System.out.println("ERROR3");
                }
            }
        };
        b1.setOnAction(event);
        b2.setOnAction(event2);
    }
    public Scene genScene()
    {
        b2.setDisable(true);
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
        g.getChildren().addAll(imgv,p1,p2);
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