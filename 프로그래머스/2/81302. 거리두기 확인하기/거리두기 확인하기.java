import java.util.*;

class Solution {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private boolean checkPartition(char[][] seats, int r1, int c1, int r2, int c2) {
        int r = Math.abs(r1 - r2);
        int c = Math.abs(c1 - c2);

        // 거리가 2이상인 경우
        if (r + c > 2) {
            return true;
        }

        // 거리가 1인 경우
        if (r + c == 1) {
            return false;
        }

        // 거리가 2인 경우
        // 가로로 한칸 띄어져 있는 경우
        if (r1 == r2 && c == 2 && seats[r1][Math.min(c1, c2) + 1] != 'X') {
            return false;
        }

        // 세로로 한칸 띄어져 있는 경우
        if (c1 == c2 && r == 2 && seats[Math.min(r1, r2) + 1][c1] != 'X') {
            return false;
        }

        // 대각선으로 한칸 띄어져 있는 경우
        if (r == 1 && c == 1 && (seats[r1][c2] != 'X' || seats[r2][c1] != 'X')) {
            return false;
        }

        return true;
    }

    private boolean isManhattan(char[][] seats) {
        ArrayList<Point> position = new ArrayList<Point>();

        // 'P'좌표 position 에 저장
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats.length; j++) {
                char seat = seats[i][j];
                if (seat == 'P') {
                    position.add(new Point(i, j));
                }
            }
        }

        int size = position.size();

        // 'P'가 없는 경우
        if (size == 0) {
            return true;
        }

        // 모든 P쌍에 대해 거리와 파티션 여부 체크
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Point p1 = position.get(i);
                Point p2 = position.get(j);
                int distance = getDistance(p1, p2);

                if (distance <= 2) {
                    if (!checkPartition(seats, p1.x, p1.y, p2.x, p2.y)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] seats = new char[place.length][place.length];

            for (int j = 0; j < seats.length; j++) {
                seats[j] = place[j].toCharArray();
            }

            if (isManhattan(seats)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}