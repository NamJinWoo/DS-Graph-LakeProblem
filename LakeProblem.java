import java.util.Scanner;

public class LakeProblem {
	static char arr[][] = new char[10][10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int result = 0;
		int index = 0;
		int count = 0;
		while (index < x) {
			String w = sc.next();
			for (int i = 0; i < y; i++) {
				arr[count][i] = w.charAt(i);
			}
			count++;
			index++;
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (arr[i][j] == 'W') {
					dfs(i, j);
					result++;
				}
			}
		}
		System.out.println(result);
	}

	public static void dfs(int x, int y) {
		arr[x][y] = '.';

		int deltaX[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int deltaY[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

		for (int k = 0; k < 8; k++) {
			int newX = x + deltaX[k];
			int newY = y + deltaY[k];

			if (arr[newX][newY] == 'W')
				dfs(newX, newY);
		}
	}
}
