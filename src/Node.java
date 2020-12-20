public class Node {
    int pos;
    Node next;
    Node prev;
    Boolean pressed = false;


    public Node(){

    }
    public Node(int pos){
        this.pos = pos;
        this.next = null;
    }
    public void addNext(Node next){
        this.next = next;
    }
    public void addPrev(Node prev){
        this.prev = prev;
    }


}
