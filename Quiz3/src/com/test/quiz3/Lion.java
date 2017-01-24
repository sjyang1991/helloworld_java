package com.test.quiz3;

public class Lion extends Animal //lion은 동물이다
	implements Eatable, Attackable, GroundHabitable	//lion은 먹을 수 있고 공격할 수 있다.
	{ 
	
	//생성자
	@Override
	public void living(){}	
	public Lion(int age){
		super(); //Animal(상위)의 생성자 호출
		this.strength = this.weight = 190; 
		this.skin=1; this.speed=80; 
		this.life=14; this.age=age;
		
		/*Animal a = new Animal();
		this.eat(a);
		super.eat(a);
		a.eat(a);*/
		
	}
	
	@Override
	public boolean eat(Animal feed){
		if (this.alive == true) {
			int satiety = feed.weight /5;
			this.weight += satiety;
			this.strength += satiety * 3;
			return true;
		}
		return false;
	}
	@Override
	public boolean eat(Plant feed){
		return false;
	}
	@Override
	public boolean attack(Animal enemy){
		if (this.alive == true && enemy.alive == true) {
			//방어력
			int defence = enemy.weight;
			defence = defence /(enemy.age*100/enemy.life);
			defence += enemy.speed * (Math.random()*10);
			if(enemy.skin == 3) defence += defence*0.2;
			else if(enemy.skin == 4) defence += defence*0.3;
			System.out.println("방어력:"+defence);		//debug 코드
			
			//공격력
			int attack = (int)(this.weight*(1.2));
			attack += attack*0.3;
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
	void smoking(){
		System.out.println("뻐끔뻐끔");
	}

}
