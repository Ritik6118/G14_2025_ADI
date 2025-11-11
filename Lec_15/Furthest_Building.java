package Lec_15;

import java.util.Collections;
import java.util.PriorityQueue;

public class Furthest_Building {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 2, 7, 6, 9, 14, 12 };

		System.out.println(solve(arr, 5, 1));
	}

	private static int solve(int[] arr, int b, int l) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int i = 0;
		while (i < arr.length - 1) {
			int diff = arr[i + 1] - arr[i]; // +ve -> i+1 > i // -ve -> i > i+1 // 0 -> i==i+1

			if (diff <= 0) {
				i++;
			} else {
				if (b >= diff) {
					b -= diff;
					i++;
					pq.add(diff);
				} else if (l > 0) {
					if (!pq.isEmpty() && pq.peek() > diff) {
						b += pq.poll();
						l--;
					} else {
						i++;
						l--;
					}

				} else {
					break;
				}
			}

		}
		return i;

	}

}
