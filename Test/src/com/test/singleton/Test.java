package com.test.singleton;

class SingleTon{
	private static SingleTon single = new SingleTon();
	
	private SingleTon(){}
	
	public static SingleTon getInstance(){
		return single;
	}
		
	public void hello(){}
}
/*class SingleTon2 extends SingleTon{
//	@Override
	public void hello2(){
	}
}*/
public class Test {
	public static void main(String args[]){
		
		/*SingleTon single1 = new SingleTon();
		SingleTon single2 = new SingleTon();*/
		SingleTon single1 = SingleTon.getInstance();
		SingleTon single2 = SingleTon.getInstance();
		if(single1 == single2){
			System.out.println("같다");			
		}
	}
}
