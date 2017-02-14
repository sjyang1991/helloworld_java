package com.test.thread_exam;

public class ThreadExam {

	public static void main(String[] args) {
		/*Thread thread1 = new Thread(new Runnable(){
			@Override
			public void run(){
				for (int i=0; i<10; i++){
					System.out.println(i+"*****");
					//System.out.println(thread1.getState());
					try{
						Thread.sleep(1000);	//1초에 한 번씩 찍어라
					}catch(Exception e){}
				}
			}
		}
		);
		Thread thread2 = new Thread(new Runnable(){
			@Override
			public void run(){
				for (int i=0; i<10; i++){
					System.out.println(i+"##########");
					//System.out.println(thread1.getState());
					try{
						Thread.sleep(1000);	//1초에 한 번씩 찍어라
					}catch(Exception e){}
				}
			}
		}
		);
		thread1.start();
		thread2.start();
//		thread1.run();
		Thread thread3 = new Thread(new Runnable(){
			@Override
			public void run(){
				while(true){
					try{
						Thread.sleep(1000);
					
					}catch(InterruptedException e){break;}
					System.out.println("save---");
				}
				System.out.println("quit---");
			}
		});
		thread3.setDaemon(true);
		thread3.start();
		try{
			thread1.join();
		}catch(Exception e){}
		thread3.interrupt();
		
		for(int i=0; i<10 ; i++){
			System.out.println(i);
			try{
				Thread.sleep(500);	//0.5초에 한 번씩 찍어라
			}catch(Exception e){}
		}
		*/
		Thread[] multiThread = new Thread[1000];
		for( int i=0; i<2000; i++){
			multiThread[i] = new Thread(new Runnable(){
				@Override
				public void run(){
					for (int i=0; i<10; i++){
						System.out.println(i+"-----"+Thread.currentThread().getName());
						//System.out.println(thread1.getState());
						try{
							Thread.sleep(500);	//1초에 한 번씩 찍어라
						}catch(Exception e){}
					}
				}
			}
			);
			multiThread[i].start();
		}

	}

}
