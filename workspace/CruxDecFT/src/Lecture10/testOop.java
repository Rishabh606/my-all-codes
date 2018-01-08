package Lecture10;

public class testOop {
	static int count = 0;
    int data;
    
    public testOop(int data){
    	this.data = data;
    	count++;
    }
    
    public testOop(){
    	this(10);
    }
    
    public void display(){
    	System.out.println(data);
    }
    
    public static void displayCount(){
    	System.out.println(count);
    	//System.out.println(data);
    }
    
}


