package interviewbit;

public class BlackWhiteDFS {

    public static void main(String args[]){
        BlackWhiteDFS dfs = new BlackWhiteDFS();
        String[] A = new String[]{
                                    "OOOXOOO",
                                    "OOXXOXO",
                                    "OXOOOXO"
                                };

        System.out.println(" result :" + dfs.black(A));
    }

    public int black(String[] A) {

        boolean[][] visited =  new boolean[A.length][A[0].length()];

        int size=0;
        for(int i =0; i < A.length; i++){
            char[] str = A[i].toCharArray();
            for(int j=0; j < str.length; j++){
                if( str[j] == 'X')
                    size = getBlack(A, i, j, visited);
            }
        }
        return size;
    }

    public int getBlack(String[] A, int row, int col, boolean[][] visited){

        if(row==A.length || col==A[0].length() || row ==0 || col == 0 || visited[row][col])
            return 0;

        int size =1;
        visited[row][col] =  true;

        for(int i = row-1; i <=row+1 && i<A.length; i++){
            char[] str = A[i].toCharArray();
            for(int j=col-1; j<=col+1 && j<str.length; j++){
                if(i != row && j != col) {
                    if (str[j] == 'X')
                        size += getBlack(A, i, j, visited);
                }
            }
        }

        return size;
    }


}
