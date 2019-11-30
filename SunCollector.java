import javafx.scene.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
class SunCollector implements EventHandler<MouseEvent>
{
       Player p;
       Group g;
       Sun s;
       public SunCollector(Player player,Group g,Sun s) 
       {
            this.g=g;
            this.p=p;
            this.s=s;
       }
       @Override
       public void handle(MouseEvent event)
       {
           s.removeImage(); 
       }
}
                        

