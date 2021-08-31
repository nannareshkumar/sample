package bytebybyte;

/**
 * Created by home on 1/29/2021.
 */
public class TrueMatrix {

    public static void main(String args[]) {
        boolean[][] a = new boolean[][]{{true, false, false},
                                        {false, false, false},
                                        {false, false, true}};

        TrueMatrix t = new TrueMatrix();
        t.print(t.updateMatrix(a));

    }

    public boolean[][] updateMatrix(boolean[][] a ){

        boolean[][] r = new boolean[a.length][a[0].length];
        if(a.length > 0 && a[0].length > 0) {

            //copy the orig matrix
            for(int i=0; i < a.length; i++){
                for(int j=0; j < a.length; j++) {
                    r[i][j] = a[i][j];
                }
            }

            for(int i=0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if(a[i][j]){
                        r[i][j] = true;

                        for(int m=0; m < a.length; m++ ){
                            r[m][j] = true;
                        }
                        for(int m=0; m < a[0].length; m++ ){
                            r[i][m] = true;
                        }
                    }
                }
            }
        }
        return r;
    }

    public void print(boolean[][] a ){

        for(int i=0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print( " " + a[i][j]);
            }
            System.out.println("");
        }
    }

}
