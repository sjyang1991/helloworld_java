package com.test.quiz3;
/*import java.util.Scanner;*/

public class AnimalExam {
	public static void main(String args[]){
		Animal tiger = new Animal();
		Animal cow = new Animal();
		tiger.feed = 1; cow.feed = 2;
		System.out.println(tiger.eat(cow));
		System.out.println(cow.eat(tiger));
		Plant carrot = new Plant();
		System.out.println(tiger.eat(carrot));
		System.out.println(cow.eat(carrot));
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Animal myani = new Animal();
		Scanner scanner = new Scanner(System.in);
		
		int a,b;
		myani.type = "사자";
		System.out.println(myani.type);
		
		myani.type = scanner.nextLine();
		a = myani.sleep();
		System.out.println(a+"만큼 개운해졌습니다");
		
		b = myani.eat("고기");
		System.out.println(a);
		if(b<5){
			System.out.println("잘 먹었습니다");
		}else{
			System.out.println("체했습니다");
		}*/
}
