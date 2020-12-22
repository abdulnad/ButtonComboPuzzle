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
        first = new ButtonNode(al.get(0)+"");
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
        ButtonNode[] bnarr = new ButtonNode[7];
        List<ButtonNode> bnlist = Arrays.asList(bnarr);
        for (int i=1;i<al.size();i++){
            ButtonNode newNode = new ButtonNode(al.get(i)+"");
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
        bnlist.get(0).prev = bnlist.get(6);
        Collections.shuffle(Arrays.asList(bnarr));
        for(int i=0;i<bnlist.size();i++){
            this.add(bnlist.get(i));
        }




        this.setVisible(true);

    }
    public void displayList(){
        System.out.print(first.pos);
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
        }
        else{
            if(bn.prev.isEnabled()==false){
                bn.setEnabled(false);
                System.out.println("Good!");
            }
            else{
                System.out.println("NOPE!");
            }
        }
    }


}
