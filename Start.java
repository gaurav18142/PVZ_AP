import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.util.Duration;
public class Start extends Application
{
    Scene scene;
    Button delayedButton=new Button("");
    Image loadscreen=new Image( "wall.jpg",1920,1080,false,false );
    Image btnimg=new Image(getClass().getResourceAsStream("start.gif"));
    ImageView imgv=new ImageView();
    Group g=new Group();
    ProgressBar bar=new ProgressBar();
    @Override
    public void start(Stage theStage)
    {
        theStage.setScene(getScene());
        theStage.getIcons().add(loadscreen);
        theStage.setTitle("Loading");
        theStage.setFullScreen(true);
        delayedButton.setOnAction(new EventHandler<ActionEvent>()   
        {
            public void handle(ActionEvent t)
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
       });
        PauseTransition pt = new PauseTransition(Duration.seconds(15));
        pt.setOnFinished(e -> 
        {
            delayedButton.setVisible(true);
            bar.setVisible(false);
        }
        );
        pt.play();
        theStage.show();            
    }
    public Scene getScene()
    {
        delayedButton.setStyle("-fx-base: rgb("+(9)+","+(161)+","+(23)+");");
        delayedButton.setVisible(false);
        delayedButton.setPrefWidth(350);
        delayedButton.setPrefHeight(120);
        delayedButton.setLayoutX(720);
        delayedButton.setLayoutY(880);
        delayedButton.setGraphic(new ImageView(btnimg));
        imgv.setImage(loadscreen);     
        bar.setPrefWidth(350);
        bar.setPrefHeight(120);
        bar.setLayoutX(830);
        bar.setLayoutY(930);
        g.getChildren().addAll(imgv,bar,delayedButton);
        scene=new Scene(g,550,550,Color.BLACK);
        return(scene);
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}