import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ButtonNode extends JButton{

    int pos;
    ButtonNode next;
    ButtonNode prev;

    public ButtonNode(String text){
        super(text);
        pos = Integer.parseInt(text);
    }

}
