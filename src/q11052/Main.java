package q11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] P;
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		P = new int[N + 1];
		memo = new int[N + 1];
		int i, j, max;

		for (i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		memo[1] = P[1];

		for (i = 2; i <= N; i++) {
			max = Integer.MIN_VALUE;
			for(j = 1; j <= i; j++) {
				max = max > memo[i-j] + P[j] ? max : memo[i-j] + P[j];
			}
			memo[i] = max;
		}
		
		System.out.println(memo[N]);
		br.close();
	}
}
