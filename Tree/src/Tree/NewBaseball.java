package Tree;
import java.util.Scanner;

public class NewBaseball {
	
	public static void main(String[] args) {
		int[] real_num = new int[3];
		Play player1 = new Play();
		player1.random();

		Scanner scanner = new Scanner(System.in);
		System.out.println("┌──────────────────────────────────────────────────────┐");
		System.out.println("│                 Play Baseball Game                   │");
		System.out.println("└──────────────────────────────────────────────────────┘");
		System.out.println();

		while (true) {
			System.out.print("숫자 3개를 입력해주세요 ex(1 2 3)");
			String line = scanner.nextLine();
			String[] input_num = line.split(" ");

			for (int i = 0; i < real_num.length; i++) {
				real_num[i] = Integer.parseInt(input_num[i]);
			} // for문 끝

			if ( real_num[0] == real_num[1] || real_num[2] == real_num[0] || real_num[2] == real_num[1]) {
				System.out.println("중복된 숫자를 입력하셨습니다.");
				continue;
			}
					
			System.out.println("랜덤숫자:" + player1.rand_num[0] + "" + player1.rand_num[1] + "" + player1.rand_num[2]);

			player1.strike(real_num);
			player1.ball(real_num);

			System.out.println(" 스트라이크 " + player1.strike_cnt + " 볼 " + player1.ball_cnt);
			System.out.println();
			player1.try_cnt++;

			if (player1.strike_cnt == 3) {
				System.out.println("당신은 " + player1.try_cnt + "번만에 맞추셨습니다.");
				player1.random();
				System.out.println("축하합니다 ^^");
				System.out.println("계속하시겠습니까? y/n");
				
				if (scanner.nextLine().equals("n")){
					break;
				}
				player1.try_cnt = 0;
			}
		}
	}
}
