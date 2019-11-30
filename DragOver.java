import javafx.event.EventHandler;
import javafx.scene.input.*;
public class DragOver implements EventHandler<DragEvent> 
{
    @Override
    public void handle(DragEvent event) 
    {
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        event.consume();
    }
}