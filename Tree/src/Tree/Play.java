package Tree;

public class Play {
	//필드
	int[] rand_num = new int[3];//랜덤숫자
	int strike_cnt;//스트라이크
	int ball_cnt;//볼
	int out_cnt;//아웃
	int try_cnt;//도전횟수
	int level;//레벨
	int correct_cnt;//맞춘횟수
	
	//생성자
	public Play(){
		strike_cnt=0; ball_cnt=0; out_cnt=0; try_cnt=0; level=0; correct_cnt=0;
	}
	
	//메소드
	void random() {
		while (true) {
			int num1 = (int) (Math.random() * 10);
			int num2 = (int) (Math.random() * 10);
			int num3 = (int) (Math.random() * 10);
			if (num1 != num2 && num3 != num1 && num3 != num2) { // 중복안되게
				this.rand_num[0] = num1;
				this.rand_num[1] = num2;
				this.rand_num[2] = num3;
				break;
			}
		}

	}
	
	int ball(int real_num[]){
		ball_cnt=0;
		for (int rand_position = 0; rand_position < rand_num.length; rand_position++) {
			for (int real_position = 0; real_position < real_num.length; real_position++) {
				if (rand_position == real_position)
					continue;
				else {
					if (rand_num[rand_position] == real_num[real_position]) {
						ball_cnt++;
					}
				}
			}
		}
		return ball_cnt;
	}
	
	int strike(int real_num[]) {
		strike_cnt=0;
		for (int position = 0; position < rand_num.length; position++) {
			if (rand_num[position] == real_num[position]) {
				strike_cnt++;
			}
		}
		return strike_cnt;
	}
	
}
