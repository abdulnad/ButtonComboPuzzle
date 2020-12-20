import java.util.*;
import java.io.*;

public class CircularLinkedList{

    Node first;
    Boolean firstOne=false;
    int size=0;

    public CircularLinkedList(){
        //Generate a random combo
        Integer[] arr = {0,1,2,3,4,5,6,7};
        List<Integer> al = Arrays.asList(arr);
        Collections.shuffle(Arrays.asList(arr));
        first = new Node(al.get(0));
        Node og = first;
        size++;

        for(int i=1;i<al.size();i++){
            Node newNode = new Node(al.get(i));
            newNode.next = null;
            this.first.next = newNode;
            first.next.prev = first;
            first = first.next;
            size++;
        }
        first.next = og;


    }


    public void displayList(){
        System.out.print(first.pos);
        Node cursor = first.next;
        for (int i=0;i<size;i++){
            System.out.print(" -> " + cursor.pos);
            cursor = cursor.next;
        }
        System.out.println();
    }

    public Node getNode(int dPos){
        Node cursor = first;
        for (int i=0;i<size;i++){
            if(cursor.pos == dPos) return cursor;
            cursor = cursor.next;
        }
            return null;
    }
    public void unPress(){
        Node cursor = first;
        for (int i=0;i<size;i++){
            cursor.pressed = false;
            cursor = cursor.next;
        }
    }

    public void solve(){
        boolean solved = false;
        int input=0;
        int points=0;
        Node cursor = first;
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

    }



}
