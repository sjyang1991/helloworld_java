package com.test.quiz3;

public class Animal{
	int length;	//몸 길이
	int weight;//무게
	int speed;//이동속도
	int life;//수명
	int skin;//표면
	int legs;//다리 수
	int wings;//날개쌍
	int feed;//먹이(1=동물, 2=식물, 3=잡식)
	int breathe;//숨쉬는 방법
	int habitat;//사는 곳
	int horns;//뿔개수
	
	public Animal() {
		length =0; weight=0; speed=0; 
		life=0; skin=0; legs=0; wings=0; 
		feed=0; breathe=0; habitat=0; horns=0;
	}
	
	boolean eat(Animal feed){
		if(this.feed ==1 || this.feed ==3){
			int satiety = feed.weight /10;
			this.weight += satiety;
			return true;
		}
		return false;
	}
	boolean eat(Plant feed){
		if(this.feed ==2 || this.feed ==3){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*//필드
	String type;
	int age;
	
	//생성자
	Animal(String type){
		this.type = "사자";
		this.age = (int) Math.random()*10;
	}
	//메소드
	int eat(String food){
		int result = Integer.parseInt(food) % 2;
		return result;
	}
	int sleep(){
		return (int) Math.random()*10;
	}
	*/
}

