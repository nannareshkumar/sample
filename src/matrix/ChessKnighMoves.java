package matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by home on 12/25/2020.
 */
public class ChessKnighMoves {

    public static void main(String args[]){

        int A = 8,  B = 8, C = 1, D = 1,  E = 8,  F = 8;
        //  initial position (1,1), said position (8,8)

    }
    /*
      A and B represent the size of the board  C, D represent the current knight position and E, F represent final knight position
      with min number of steps
     allPossible(100, 100, 4, 4):
          { {3, 2}, {3, 6}, {2, 3}, {2, 5}, ... }


 i+2, j-1
 i+1, j-2

 i-1, j-2
 i-2, j-1

 i-1, j+2
 i-2, j+1

 i+1, j+2
 i+2, j+1

     */
    public int knight(int A, int B, int C, int D, int E, int F) {
        int res = -1;
        //get the minimum distance between E and C, D and F.  Call the recursive function by passing the calc new moves
        // first call of C, D is { (1, 1), (3,2), (5, 3), (7,4), (8, 6), (6,7), (8,8) }
        /*
        K  .  .  .  .  .  .  .
        .  .  .  .  .  .  .  .
        .  K  .  .  .  .  .  .
        .  .  .  .  .  .  .  .
        .  .  K  .  .  .  .  .
        .  .  .  .  .  .  K  .
        .  .  .  K  .  .  .  .
        .  .  .  .  .  K  .  K


        K  .  .  .
        .  .  .  .
        .  K  K  .
        K  .  .  .
        .  .  K  K


        */
        int step=0;
        for( step =1; step < A; step++) {
            List<int[]> moves = allMoves(A,B,C,D,E,F);

            int minC =0, minD=0;
            Iterator iter = moves.iterator();
            while(iter.hasNext()){
             int[] move = (int[]) iter.next();
             if(minC < E- move[0])
                minC = E-move[0];
                allMoves(A, B, move[0], move[1], E, F );
                continue;
            }
        } // step for loop

        return step;
    }
/*
            moves[i+k][j-p]=1;
            moves[i-k][j-p]=1;
            moves[i-k][j+p]=1;
            moves[i+k][j+p]=1;

*/
    public List<int[]> allMoves(int A, int B, int C, int D, int E, int F) {
        List<int[]> moves = new ArrayList();
        for (int k = 1, p = 2; (k < 3 && k <= C) && (p <= D && p > 0); k++, p--) {
            // what if j-p < 0?
            if (C + k < A) {
                if (D - p >= 0) {
                    int[] move1 = new int[]{C + k, D - p};
                    moves.add(move1);
                } else if (D + p < A) {
                    int[] move4 = new int[]{C + k, D + p};
                    moves.add(move4);
                }
            } else if (C - k >= 0) {
                if (D - p >= 0) {
                    int[] move2 = new int[]{C + k, D - p};
                    moves.add(move2);
                } else if (D + p < A) {
                    int[] move3 = new int[]{C + k, D + p};
                    moves.add(move3);
                }

            }
        }
        return moves;
    }


}
