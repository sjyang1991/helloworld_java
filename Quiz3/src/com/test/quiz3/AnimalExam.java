package com.test.quiz3;
/*import java.util.Scanner;*/

public class AnimalExam {
	public static void main(String args[]){
/*		Animal tiger1 = new Animal();
		tiger1.strength = tiger1.weight = 310; tiger1.skin=1; 
		tiger1.speed=65; tiger1.life=26; tiger1.age=2;
		*/
		Lion lion1 = new Lion(2);
		
		//tiger1.smoking();
		lion1.smoking();
		
		Animal lion2 = lion1;
		//lion2.smoking();
		Lion lion3 = (Lion) lion2;
		lion3.smoking();
		
//		System.out.println((tiger1 instanceof Animal));
//		System.out.println((tiger1 instanceof Lion));
		System.out.println((lion1 instanceof Animal));
		System.out.println((lion1 instanceof Lion));
		System.out.println((lion2 instanceof Animal));
		System.out.println((lion2 instanceof Lion));
		
		/*System.out.println(tiger1.attack(lion1));
		System.out.println(lion1.strength);
		System.out.println(lion1.attack(tiger1));
		System.out.println(tiger1.strength);
		System.out.println("----------------------------------");
		
		System.out.println(tiger1.attack(lion1));
		System.out.println(lion1.strength);
		System.out.println(lion1.attack(tiger1));
		System.out.println(tiger1.strength);
		System.out.println("----------------------------------");*/
		
		
		
		
		
		
		
/*		Animal tiger = new Animal();
		Animal cow = new Animal();
//		tiger.feed = 1; cow.feed = 2;
		System.out.println(tiger.eat(cow));
		System.out.println(cow.eat(tiger));
		Plant carrot = new Plant();
		System.out.println(tiger.eat(carrot));
		System.out.println(cow.eat(carrot));
		///////////////////////////////////
		Animal dog = new Animal();
		dog.strength = dog.weight = 27;	dog.skin=1; dog.speed=35; dog.life=15; dog.age=8; dog.feed=3;

		tiger.strength = tiger.weight = 310; tiger.skin=1; tiger.speed=65; tiger.life=26; tiger.age=2;
		
		Animal bear = new Animal();
		bear.strength = bear.weight = 600; bear.skin=1; bear.speed=40; bear.life=20; bear.age=3; bear.feed=3;
		
		System.out.println(dog.attack(tiger));
		System.out.println(dog.strength);
		
		System.out.println(tiger.attack(bear));
		System.out.println(bear.strength);
		System.out.println(bear.attack(tiger));
		System.out.println(tiger.strength);
		*/
		
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
