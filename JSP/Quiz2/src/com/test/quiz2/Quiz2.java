package com.test.quiz2;

public class Quiz2 {
	public static void main(String args[]) throws Exception{
		
		int keyCode = 0;
		while(true){
			System.out.print("숫자를 입력하세요>");
			
			keyCode = System.in.read();
			switch(keyCode){
				case 49:
					for(int i=0; i<5; i++){
						for(int j=0; j<5; j++){
							if(j<=i){
								System.out.print("*");

							}else{
								System.out.print(" ");
							}
							if(j==4){
								System.out.println("");
							}
						}
					}
					break;
				case 50:
					for(int i=0; i<5; i++){
						for(int j=0; j<5; j++){
							if(j<4-i){
								System.out.print(" ");

							}else{
								System.out.print("*");
							}
							if(j==4){
								System.out.println("");
							}
						}
					}
					break;
				case 51:
					for(int i=0; i<5; i++){
						for(int j=0; j<5; j++){
							if(j<i){
								System.out.print(" ");

							}else{
								System.out.print("*");
							}
							if(j==4){
								System.out.println("");
							}
						}
					}
					break;
				case 52:
					for(int i=0; i<5; i++){
						for(int j=0; j<5; j++){
							if(j>4-i){
								System.out.print(" ");

							}else{
								System.out.print("*");
							}
							if(j==4){
								System.out.println("");
							}
						}
					}
					break;		
			}
		}
	}
}
