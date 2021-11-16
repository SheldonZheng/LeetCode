/**
 * LeetCode 391 Perfect Rectangle
 */
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
		int area = 0;
		Set<Integer> container = new HashSet<>();
		int a1 = Integer.MAX_VALUE,b1 = Integer.MAX_VALUE;
		int a2 = Integer.MIN_VALUE,b2 = Integer.MIN_VALUE;

		for (int[] rectangle : rectangles) {
			int x1 = rectangle[0];
			int y1 = rectangle[1];
			int x2 = rectangle[2];
			int y2 = rectangle[3];

			if (x1 < a1 || y1 < b1) {
				a1 = x1;
				b1 = y1;
			}

			if (x2 > a2 || y2 > b2) {
				a2 = x2;
				b2 = y2;
			}

			area += (x2 - x1) * (y2 - y1);

			record(container,x1,y1);
			record(container,x1,y2);
			record(container,x2,y1);
			record(container,x2,y2);

		}

		int totalArea = (a2 - a1) * (b2 - b1);

		if (area != totalArea) {
			return false;
		}

		return container.size() == 4 && container.contains(mapKey(a1,b1)) && container.contains(mapKey(a2,b1)) && container.contains(mapKey(a1,b2)) && container.contains(mapKey(a2,b2));
	}

	private void record(Set<Integer> container,int x,int y) {
		int key = mapKey(x,y);
		if (container.contains(key)) {
			container.remove(key);
		} else {
			container.add(key);
		}
		return ;
	}

	private int mapKey(int x,int y) {
		return x * 111119 + y;
	}
}
