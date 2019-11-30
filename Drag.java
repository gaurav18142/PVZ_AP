import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.Group;
import java.util.concurrent.TimeUnit;
public class Drag implements EventHandler<MouseEvent> 
{
    private StackPane s;
    private Image img;
    public Drag(StackPane s,Image img) 
    {
        this.s=s;
        this.img=img;
    }
    @Override
    public void handle(MouseEvent event) 
    {     
        ClipboardContent content=new ClipboardContent();
        content.putImage(this.img);
        Dragboard db=s.startDragAndDrop(TransferMode.MOVE);
        if (s.getId().equals("peashooter")) 
        {
            content.putString("peashooter");
        } 
        else if (s.getId().equals("sunflower"))
        {
            content.putString("sunflower");
        } 
        else if (s.getId().equals("wallnut"))
        {
            content.putString("wallnut");
        } 
        else if (s.getId().equals("potatoMine"))
        {
            content.putString("potatoMine");
        }
        else if (s.getId().equals("freeze"))
        {
            content.putString("freeze");
        }
        db.setContent(content);
    }
}