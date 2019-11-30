import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;
public class Name extends Application
{
    Scene scene;
    Group g=new Group();
    Group g1=new Group();
    Stage MainStage;
    BorderPane p1=new BorderPane();
    Button b1=new Button("Proceed");
    int level=1;
    String name="";
    TextField b=new TextField();
    StackPane r=new StackPane();
    Image mainscreen= new Image("level.jpg",1920,1080,false,false );
    ImageView imgv=new ImageView();
    Text title= new Text("Enter Your Name");
    Name(int l)
    {
        level=l;
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
                    name=b.getText();
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
    }
    public Scene genScene()
    {
        title.setFont(Font.font("Verdana",125));
        title.setFill(Color.RED);
        b.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        imgv.setImage(mainscreen);
        b.setAlignment(Pos.CENTER);
        b.setPrefWidth(350);
        b.setPrefHeight(60);
        r.getChildren().add(b);
        p1.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        b1.setPrefWidth(350);
        b1.setPrefHeight(60);
        p1.setCenter(b1);
        p1.setLayoutX(730);
        p1.setLayoutY(580);
        r.setLayoutX(730);
        r.setLayoutY(400);
        title.setLayoutX(580);
        title.setLayoutY(280);
        r.setPrefWidth(350);
        r.setPrefHeight(160);
        g.getChildren().addAll(imgv,p1,r,title);
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