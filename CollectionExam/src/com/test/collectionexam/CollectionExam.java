package com.test.collectionexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class PersonInfo {
	private String name;
	private String tel;
	PersonInfo(){		name = " "; tel = " ";	}
	public void setName(String name){	this.name = name;	}
	public String getName(){	return this.name;	}
	public void setTel(String tel){	this.tel = tel;	}
	public String getTel(){		return this.tel;	}
}

public class CollectionExam {
	public static final int MAX = 10;
	public static void main(String[] args){
		String[] name = new String[MAX];//------------------부반장
		String[] tel = new String[MAX];
		
		PersonInfo[] addressBook = new PersonInfo[MAX];//------------------------초롱양 버전
		
		ArrayList<PersonInfo> addressBook2 = new ArrayList<PersonInfo>();//-------------콜렉션 버전
		
		//1. 데이터를 저장한다
		int index = 0;
		while(true){ //-------부반장 버전과 초롱양 버전만 위해서 필요
			if(index < MAX){
				//1.1 부반장 버전
				name[index] = "김우성"+index;
				tel[index] = "01011112222";
				
				//1.2 초롱양 버전
				addressBook[index] = new PersonInfo(); //클래스 배열 안에 객채를 생성
				addressBook[index].setName("박초롱"+index);
				addressBook[index].setTel("01099998888");
				index++;
				
				//1.3 최종보스 버전
				PersonInfo info = new PersonInfo();
				info.setName("박컬렉션"+addressBook2.size());
				info.setTel("01066666666");
				addressBook2.add(info);
			}else{		break;		}
		}
		//2. 데이터를 조회한다.
		//2.1 부반장 버전
		for(int i=0 ; i < MAX ; i++){
			System.out.print(name[i]);
			System.out.println(", "+tel[i]);
		}
		
		//2.2 초롱양 버전
		for( int i=0 ; i < MAX ; i++){
			System.out.println(addressBook[i].getName()+", "+addressBook[i].getTel());
		}
		
		//2.3 최종보스 버전
		for (int i=0 ; i < addressBook2.size() ; i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+", "+info.getTel());
		}
		
		//3. 데이터를 섞는다.
		//3.1 배열 섞기(초롱양)
		System.out.println("---------------------------------------------------------");
		PersonInfo[] shuffleBook = new PersonInfo[10];
		for (int i=0 ; i < MAX ; i++){
			while(true){
				int targetIndex = (int) (Math.random()*MAX);
				if(shuffleBook[targetIndex] == null) {
					shuffleBook[targetIndex] = addressBook[i];
					break;
				}
			}
		}
		addressBook = shuffleBook;
		for( int i=0 ; i < MAX ; i++){
			System.out.println(addressBook[i].getName()+", "+addressBook[i].getTel());
		}
		
		//3.2 리스트 섞기(최종보스 단, 한줄만에!!!)
		Collections.shuffle(addressBook2);	//-------------------!!!!!!!!!
		for (int i=0 ; i < addressBook2.size() ; i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+", "+info.getTel());
		}
		//Collections.sort(info);
		
		//4. 다시 정렬을 한다.
		//4.1 초롱양 버전
		for (int i = 0; i < MAX-1 ; i++){
			for(int j = i+j ; j < MAX -1 ; j++){
				int cond = addressBook[i].getName().compareTo(
						addressBook[i].getName());
				if( cond > 0){
					PersonInfo temp = addressBook[i];
					addressBook[i] = addressBook[j];
					addressBook[j] = temp;
				}
			}
		}
		for( int i=0 ; i < MAX ; i++){
			System.out.println(addressBook[i].getName()+", "+addressBook[i].getTel());
		}
		
		//4.2 최종보스 버전
		Collections.sort(addressBook2, new Comparator<PersonInfo>){
			public int compare(PersonInfo obj1, PersonInfo obj2){
				int cond = obj1.getName().compareTo(obj2.getName());
				return (cond < 0 ? -1 : (cond > 0 ? 1 : 0));
			}
		}
	
			
		for (int i = 0 ; i < addressBook2.size() ; i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+", "+info.getTel());
		}
		System.out.println(addressBook2.size());
		System.out.println("****************");
		
		
		
		//5. 중복제거
		//5.2 최종보스
		for(int i = 0; i < MAX ; i++){
			addressBook2.add(addressBook2.get(i));// 중복 데이터 생성
		}
		System.out.println(addressBook2.size());
		//Set 을 이용하여 중복 제거
		Set<PersonInfo> set = new HashSet<PersonInfo>(addressBook2);
		//Set 을 ArrayList 로 변경
		addressBook2 = new ArrayList<>(set);
		
		System.out.println(addressBook2.size());
				
		
		//6. 모두 삭제한다.
		for (int i=0; i < MAX ; i++){
			addressBook[i] = null;
		}
		addressBook2.clear();		
				
	}
}
