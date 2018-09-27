
/**
 * Solves 8-Queens problem
 * 
 * How to place 8-queens on a chess board such that none can capture another.
 * 
 * 
 * The function solve() return the board for display.
 * 
 * @author Dr. Baharav
 */
public class Solver8x8 {

    
    // Board representation
    private int[][] board;
    


    // Initialize all to empty
    public Solver8x8() {

        board = new int[8][8];
        for (int init=0;init<8;init++){
            board[0][init]=1;
        }
    }

    /**
     * 
     * @return int[][] - Board - 2D array, with 1 representing a queen, and 0 
     * represents NO queen (aka empty square)
     * 
     */
    public int[][] solve() {
        int temp=0;
        boolean boardlegal=false;


        while(boardlegal==false){
            boardlegal=checkBoard(board);
//            System.out.println("Board test");
//            printBoard(board);
            if(boardlegal==false)
                board=nextboard(board);
            temp++;
           // System.out.println(temp);
        }
        // do something
        
        // return a nice board
        printBoard(board);
        return board;
    }
    
    public boolean checkBoard(int[][] board){
        for(int rr=0; rr<8; rr++){
            for(int cc=0; cc<8; cc++){
                if(board[rr][cc]==1){
                    int row=rr;
                    int col=cc;
                
        for(int rowcheck=row+1; rowcheck<8;rowcheck++){
            if(board[rowcheck][col]==1)
                return false;
            
        }
        for (int colcheck=col+1;colcheck<8;colcheck++){
            if(board[row][colcheck]==1)
                return false;
        }
        for(int count=1;row+count<8&&col+count<8;count++){
            if(board[row+count][col+count]==1)
                return false;
        }
        for (int count=1;row+count<8&&col-count>=0;count++){
            if(board[row+count][col-count]==1)
                return false;
                }
        for (int count=1;row-count>=0&&col+count<8;count++){
            if(board[row-count][col+count]==1)
                return false;
        }
        for(int count=1;row-count>=0&&col-count>=0;count++){
            if(board[row-count][col-count]==1)
                return false;
        }
//        int maxdiag=0;
//        if(8-row>=8-col)
//            maxdiag=8-col;
//        else
//            maxdiag=8-row;
//        for(int diag=1;diag<maxdiag;diag++){
//            if(board[row+diag][col+diag]==1)
//                return false;
//        }
        
            }
          }
       }
        return true;
    }
    
    public int[][] nextboard(int[][] board) {
        for (int c = 0; c <= 7; c++) {
            for (int r = 0; r < 7; r++) {
                if (board[r][c] == 1) {
                    board[r][c] = 0;
                    board[r + 1][c] = 1;
                    return board;
                }
            }
            board[7][c] = 0;
            board[0][c] = 1;
        }

        return board;
    }
    
    
    
    /*
    
    UTILITY methods below
    
    */
    
    
    
    

    //  Convert into a 2D representation.
    //  Used to communicate out. For display. Simple 8x8 array
    //      bDisplay[ii][jj] is square [ii][jj] on the board.
    //      content of cell: 1 is Queen present, 0 is empty cell.

    private int[][] b2board() {
        int[][]br = new int[8][8];
        for (int ii = 0; ii < 8; ++ii) 
            for (int jj = 0; jj < 8; ++jj) 
                br[ii][jj] = 0;
           
        for (int ii = 0; ii < 8; ++ii)
            if (ii==4)
                br[7][ii] = 1;
            else    
                br[ii][ii] = 1;

        // Just if you want intermediate printouts, see how it works
//        printBoard(br);
        
        return br;
    }
    
    
    
    private void printBoard(int[][] b) {
        System.out.println("Board");

        for (int cc = 0; cc < 8; ++cc) 
            System.out.print("+-");
        System.out.println("+");

        for (int rr = 0; rr < 8; ++rr) {
            for (int cc = 0; cc < 8; ++cc) {
                if (b[rr][cc] == 1)
                    System.out.format("|*");
                else
                    System.out.format("| ");                    
            }
            System.out.println("|");
        
            for (int cc = 0; cc < 8; ++cc) 
                System.out.print("+-");
            System.out.println("+");
        }

    }

}
