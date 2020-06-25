public class Solution {
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
        boolean[][] isVisited = new boolean[N+1][M+1];
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(x1, y1));
        isVisited[x1][y1] = true;
        int moveCount = 0;
        
        while (!queue.isEmpty()) {
            int nodesAtCurrentBreadth = queue.size();
            for (int count = 0; count < nodesAtCurrentBreadth; count++) {
                Coordinate currPos = queue.remove();
                if (currPos.x == x2 && currPos.y == y2) {
                    return moveCount;
                }

                for (int i = 0; i < 8; i++) {
                    if (isValid(currPos.x + dx[i], currPos.y + dy[i], N, M) && isVisited[currPos.x + dx[i]][currPos.y + dy[i]] == false) {
                        queue.add(new Coordinate(currPos.x + dx[i], currPos.y + dy[i]));
                        isVisited[currPos.x + dx[i]][currPos.y + dy[i]] = true;
                    }
                }                
            }
            moveCount++;
        }        
        return -1;
    }
    
private boolean isValid(int x, int y, int N, int M) {
        if (x <= 0 || y <= 0 || x > N || y > M) 
            return false;   
        return true;
    } 
}
class Coordinate {
    int x, y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

