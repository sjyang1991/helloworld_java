package com.test.quiz3;

public class Animal{
	//필드
	int length;	//몸 길이
	int weight;//무게
	int speed;//이동속도
	int age;//나이
	int life;//수명
	int skin;//표면 (1=털, 2=깃털, 3=딱딱, 4=미끈)
	int legs;//다리 수
	int wings;//날개쌍
	int feed;//먹이(1=동물, 2=식물, 3=잡식)
	int breathe;//숨쉬는 방법
	int habitat;//사는 곳
	int horns;//뿔개수
	int strength;//체력
	boolean alive;//생존
	
	//생성자
	public Animal() {
		length =0; weight=0; speed=0; life=0; skin=0; legs=0; wings=0; feed=0; breathe=0; habitat=0; horns=0; alive=true; /*strength=weight;*/
	}
	
	//메소드
	boolean eat(Animal feed){
		if(this.feed ==1 || this.feed ==3){
			if (this.alive == true) {
				int satiety = feed.weight /10;
				this.weight += satiety;
				this.strength += satiety * 2;
				return true;
			}
			
		}
		return false;
	}
	boolean eat(Plant feed){
		if(this.feed ==2 || this.feed ==3){
			if (this.alive == true) {
				return true;
			}
		}
		return false;
	}
	boolean attack(Animal enemy){
		if (this.alive == true && enemy.alive == true) {
			//방어력
			int defence = enemy.weight;
			defence = defence /(enemy.age*100/enemy.life);
			defence += enemy.speed * (Math.random()*10);
			if(enemy.skin == 3) defence += defence*0.2;
			else if(enemy.skin == 4) defence += defence*0.3;
			System.out.println("방어력:"+defence);		//debug 코드
			
			//공격력
			int attack = this.weight;
			if(this.feed ==1) attack += attack*0.3;
			attack += this.speed * (Math.random()*10);
			attack += this.horns * (Math.random()*5);
			if(this.wings > 0) attack *= 2;
			System.out.println("공격력:"+attack);		//debug 코드
			
			//데미지
			int demage = attack - defence;
			if(demage > 0) {
				enemy.strength -= demage;
				if(enemy.strength < 0) enemy.alive = false;
				return true;
			}
			else if(demage < 0)	{
				this.strength += demage;
				if(this.strength < 0) this.alive = false;
			}
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

