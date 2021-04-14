


public class Applicant_Assesment {
    public static void main(String[]args){

        MyFunctionCalculator myCalculator=new MyFunctionCalculator();
        myCalculator.setCacheSize(3);
        myCalculator.calculate(5);
        myCalculator.display();
        myCalculator.calculate(20);
        myCalculator.display();
        myCalculator.calculate(10);
        myCalculator.display();
        myCalculator.calculate(5);
        myCalculator.display();
        myCalculator.calculate(5);
        myCalculator.display();
        myCalculator.calculate(5);
        myCalculator.display();
        myCalculator.calculate(2);
        myCalculator.display();
        myCalculator.calculate(3);
        myCalculator.display();
        System.out.println(myCalculator.getCacheElement(0));
        System.out.println(myCalculator.getCacheElement(1));
        System.out.println(myCalculator.getCacheElement(2));
        System.out.println(myCalculator.getCacheElement(3));
        System.out.println(myCalculator.getCacheElement(4));
        System.out.println(myCalculator.getCacheElement(-1));






    }
}
