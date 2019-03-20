package array;

/**
 * 题目
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 *
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 */

public class Available_Captures_for_Rook {
    public int numRookCaptures(char[][] board) {
        //先找出rook, 然后遍历它的四个方向
        int res =0;
        int rlen = board.length;
        int clen = board[0].length;
        int rr = 0;
        int cr = 0;
        //找出white rook
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (board[i][j] == 'R') {
                    rr = i;
                    cr = j;
                    break;
                }
            }
        }
        //找出四个方向的第一个棋子,利用其中一个在变实现循环
        for (int[] d : new int[][] {{1, 0}, {-1,0},{0,1},{0,-1}}) {
            for (int x = rr + d[0], y = cr + d[1]; x > 0 && x < rlen && y > 0 && y < clen; x += d[0], y += d[1]) {
                if (board[x][y] == 'p') res ++;
                //遇见第一个棋子后跳出
                if (board[x][y] != '.') break;
            }
        }
        return res;
    }
}
