import java.lang.Math;


public class MyDataStructure {
    private Node root;
    private final int size;
    private int capacity;
    public MyDataStructure(int size){
        this.size=size;
        this.capacity=0;
    }

    public void swapNode(Node x,Node y){     // it switch nodes place. For root we need extra control.
                                             // If we don't control the root, we lose priority node(y).

        if(x.getN() == root.getN()){

            x.setNext(y.getNext());
            x.setPrev(y);
            y.setPrev(null);
            y.setNext(x);

            root=y;

        }
        else {
            Node tmp = x.getPrev();
            tmp.setNext(y);
            x.setPrev(y);
            x.setNext(y.getNext());

            y.setNext(x);
            y.setPrev(tmp);

        }



    }
    public double add(int n){               // this function is main function for cache.
        Node tmp=new Node(n);


        if(root == null){                   // if root is empty. We dont have calculatedN. we should calculate here and
                                            // we add a node.
            root=tmp;
            capacity++;
            tmp.setCalculate(calculate(n));
            return calculate(n);

        }
        else
        {
            double result=search(n);        //search function return 0.999 if we cant find n in cache.If it finds n in cache,
            if( result == 0.999 ) {         //it will return calculeted value of n.
                                            //my assumption here is that the calculated value of n can never be equal to 0.999.
                                            //If it is not in the cache, we calculate n and add it to the cache from the first priority
                tmp.setNext(root);
                result=calculate(n);
                tmp.setCalculate(result);

                if(root != null)
                    root.setPrev(tmp);

                root = tmp;
                capacity++;


                if (capacity > size) {        //after adding node if our capacity is bigger than size we should delete last node.
                    Node curr = root;
                    for (int i = 0; i < size-1; i++) {

                        curr = curr.getNext();
                    }
                    curr.setNext(null);
                    capacity = size;
                }

            }
            return result;

        }
    }

    public double search(int n){            //we search given n value in cache. If we find it in the cache,
        Node curr=root;                     //we increase its priority and return the result without calculating.
                                            //if we dont find it in the cache, we return 0.999
        if(curr.getN()==n)
            return curr.getCalculate();
        Node prev=curr;
        curr=curr.getNext();


        for(int i=1;i<capacity;i++){

            if( curr.getN() == n ){
                swapNode(prev,curr);         //swapNode function is for switching nodes. It means changing priority of 2 nodes.
                return curr.getCalculate();
            }

            prev=curr;
            curr=curr.getNext();
        }
        return 0.999;
    }

    public int getCacheElement(int index){       //this function is for returning value for given index in cache.
        Node curr=root;
        for(int i=0;i<index;i++){
            curr=curr.getNext();
        }
        if(curr == null)
            return -1;

        return curr.getN();


    }



    public void display(){
        Node curr=root;
      for(int i=0;i<capacity;i++){
          if(curr != null) {
              System.out.print(" " + curr.getN() + " ");
              curr = curr.getNext();
          }
        }
        System.out.println();


    }
    private double calculate(int n){
        double sum=0;


        for(int i=0;i<=n;i++){
            sum = sum + ( i * Math.sin(Math.toRadians(i)) );
        }

        return sum;
    }




}
class Node{
    private double calculate;
    private int n;
    private Node next;
    private Node prev;

    Node(int n){
        this.n=n;
    }
    void setNext(Node tmp){
        next=tmp;
    }
    Node getNext(){
        return next;
    }
    void setPrev(Node tmp){
        prev=tmp;
    }
    Node getPrev(){
        return prev;
    }
    void setN(int n){
        this.n=n;
    }
    int getN(){
        return n;
    }
    void setCalculate(double calculate){
        this.calculate=calculate;
    }
    double getCalculate(){
        return calculate;
    }
}
