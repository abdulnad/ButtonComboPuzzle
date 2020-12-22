import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class ComboPuzzle extends JFrame implements  ActionListener{

    ButtonNode first;
    int size=0;
    boolean pressed = false;
    ButtonNode[] bnarr = new ButtonNode[7];
    int points = 0;
    ComboPuzzle(){

        /*Frame Setup*/
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setLayout(null);
        this.setSize(500,500);
        //Grid Setup
        this.setLayout(new GridLayout(4,2,20,20));
        //LinkedList Setup
        Integer[] arr = {0,1,2,3,4,5,6,7};
        List<Integer> al = Arrays.asList(arr);
        Collections.shuffle(Arrays.asList(arr));
        //Adding first button
        first = new ButtonNode("");
        first.setBackground(Color.RED);
        first.setOpaque(true);
        first.setBorderPainted(false);

        ButtonNode og = first;
        size++;
        //Adding first button to frame
        this.add(first);
        first.addActionListener(this);
        /*
        for(int i=1;i<al.size();i++){
            Node newNode = new Node(al.get(i));
            newNode.next = null;
            this.first.next = newNode;
            first.next.prev = first;
            first = first.next;
            size++;
        }
        */
        //All Buttons Setup

        List<ButtonNode> bnlist = Arrays.asList(bnarr);
        for (int i=1;i<al.size();i++){
            ButtonNode newNode = new ButtonNode("");
            newNode.setBackground(Color.RED);
            newNode.setOpaque(true);
            newNode.setBorderPainted(false);
            newNode.next = null;
            this.first.next = newNode;
            first.next.prev = first;
            first = first.next;
            size++;
            first.addActionListener(this);
            bnarr[i-1]=first;
            //this.add(first);
        }
        bnlist.get(6).next = og;
        bnlist.get(6).next.prev = bnlist.get(6);
        Collections.shuffle(Arrays.asList(bnarr));
        for(int i=0;i<bnlist.size();i++){
            this.add(bnlist.get(i));
        }




        this.setVisible(true);

    }
    public void displayList(){
        System.out.print(first.getText());
        ButtonNode cursor = first.prev;
        for (int i=0;i<size;i++){
            System.out.print(" -> " + cursor.getText());
            cursor = cursor.prev;
        }
        System.out.println();
    }

    /*
    while(solved == false){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter in position: ");
            input = scan.nextInt();
            if(firstOne == false){
                firstOne = true;
                cursor = getNode(input);
            }
            else {
                if(input!=cursor.next.pos){
                    points=0;
                    cursor = getNode(input);
                    System.out.println("Nope! Start over");
                }
                else {
                    points++;
                    cursor = cursor.next;
                    System.out.println("Good!");
                }
            }
            if(points==7) solved = true;
            System.out.println("Points: " + points);
        }
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonNode bn = (ButtonNode) e.getSource();
        if (pressed==false){
            bn.setEnabled(false);
            pressed = true;
            bn.setBackground(Color.GREEN);
        }
        else{
            if(bn.prev.isEnabled()==false){
                bn.setEnabled(false);
                points++;
                bn.setBackground(Color.GREEN);
            }
            else{
                ButtonNode cursor = first;
                for(int i=0;i<size;i++){
                    cursor.setEnabled(true);
                    cursor.setBackground(Color.RED);
                    cursor = cursor.next;
                }
                points=0;
                pressed = false;
                this.setEnabled(true);
            }
        }
        System.out.println(points);
        if(points==7){
            JOptionPane.showMessageDialog(null,"You did it!","You win",JOptionPane.PLAIN_MESSAGE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
    }



}
