package Tree;

import java.util.Scanner;

public class Baseball2 {
	static int[] realnum = new int[3];
	static int[] rd_num = new int[3];
	static int cnt = 0;

	public static void main(String[] args) {
		int s_cnt = 0;
		int b_cnt = 0;
		random();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("########################################################");
		System.out.println("#                   play ball                          #");
		System.out.println("########################################################");
		System.out.println();
		
		while (true) {
			System.out.print("숫자 3개를 입력해주세요 ex(1 2 3)");
			String line = scanner.nextLine();

			String[] num = line.split(" ");

			for (int i = 0; i < realnum.length; i++) {
				realnum[i] = Integer.parseInt(num[i]);
			} // for문 끝

			System.out.println("랜덤숫자:"+rd_num[0]+""+rd_num[1]+""+rd_num[2]);

			s_cnt = strike(realnum, rd_num);
			b_cnt = ball(realnum, rd_num);

			System.out.println(" 스트라이크 " + s_cnt + " 볼 " + b_cnt);
			s_cnt = 0;
			b_cnt = 0;
			System.out.println();
			cnt++;
			if (s_cnt == 3) {

				System.out.println("당신은 " + cnt + "번만에 맞추셨습니다.");
				System.out.println("축하합니다 ^^");
				break;
			}

		} // while문 끝

	}

	static int ball(int realnum[], int rd_num[]) {
		int p = 0;
	    int ball = 0;
	    while (p < rd_num.length ) {
	        int k = rd_num[p];
	        int d = 0;
	        while (d < realnum.length){
	            int m = realnum[d];
	            if (k == m && p != d){
	                ball = ball + 1;
	            }
	             
	            d = d + 1;
	        }
	        p = p + 1;
	    }
	    return ball;
	}

	static int strike(int realnum[], int rd_num[]) {
		int cp = 0;
		int st_cnt = 0;
		while (cp < rd_num.length) {
			int k = rd_num[cp];
			int d = realnum[cp];
			if (k == d) {
				st_cnt = st_cnt + 1;
			}
			cp = cp + 1;
		}
		return st_cnt;
	}

	static void random() {
		for (int k = 0; k < 3; k++) {
			rd_num[k] = (int) (Math.random() * 10);
		}
	}

}
