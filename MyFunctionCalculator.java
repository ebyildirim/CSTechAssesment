
public class MyFunctionCalculator extends BaseFunctionCalculator {

    private int size;
    private MyDataStructure dataStructure;

    public void setCacheSize(int size){
        this.size=size;
        dataStructure=new MyDataStructure(size);
    }
    public double calculate(int n){
        return dataStructure.add(n);
    }
    public int getCacheElement(int index){
        if(index < 0 || index > size-1)
            return -1;

        return dataStructure.getCacheElement(index);

    }
    public void display(){
        dataStructure.display();
    }




}
