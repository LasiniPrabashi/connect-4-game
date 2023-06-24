package lk.ijse.dep.service;

import lk.ijse.dep.service.impl.Winner;

public class BoardImpl  implements Board{
    private Piece[][] pieces ;
    private BoardUI boardUI;
    Piece WinningPiece;
    int col1;
    int row1;
    int col2;
    int row2;

    public BoardImpl(BoardUI boardUI){
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        this.boardUI=boardUI;

        for (int i = 0; i < NUM_OF_COLS; i++){
            for (int j=0; j<NUM_OF_ROWS; j++){
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {

        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for(int i = 0; i < NUM_OF_ROWS; i++) {

            if(pieces[col][i] == Piece.EMPTY){
                return(i);
            }
        }
        return (-1);
    }

    @Override
    public boolean isLegalMove(int col) {
        int places=findNextAvailableSpot(col);
        if (places==-1){
            return false;
        }
        return (true);
    }



    @Override
    public boolean existLegelMove() {
        for (int i=0; i< NUM_OF_COLS; i++){
            for(int j=0; j<NUM_OF_ROWS; j++){

                if(pieces[i][j]==Piece.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void UpdateMove(int col, Piece move) {
        pieces[col][findNextAvailableSpot(col)]=move;
    }

    @Override
    public void UpdateMove(int col, int rows, Piece move) {
        pieces[col][rows] = move;
    }

    @Override
    public Winner findWinner() {
        Piece winningPiece ;

        for(int i = 0; i<NUM_OF_ROWS; i++){// col 6 column checker

            if(pieces[2][i]==pieces[3][i]&&pieces[3][i]==pieces[4][i]&&pieces[4][i]==pieces[5][i]){
                winningPiece = pieces[2][i];
                if (winningPiece != Piece.EMPTY) {
                    col1 = 2;
                    col2 = 5;
                    row1 = i;
                    row2 = i;
                    return new Winner(winningPiece, col1, row1, col2, row2);
                }
            }
            else if(pieces[0][i]==pieces[1][i]&&pieces[1][i]==pieces[2][i]&&pieces[2][i]==pieces[3][i]){
                winningPiece = pieces[0][i];
                if (winningPiece != Piece.EMPTY) {
                    col1 = i;
                    col2 = i;
                    row1 = 0;
                    row2 = 3;
                    return new Winner(winningPiece, col1, row1, col2, row2);
                }
            }
            else if(pieces[1][i]==pieces[2][i] && pieces[2][i]==pieces[3][i] && pieces[3][i]==pieces[4][i]){
                winningPiece = pieces[1][i];
                if (winningPiece != Piece.EMPTY) {
                    col1 = 1;
                    col2 = 4;
                    row1 = i;
                    row2 = i;
                    return new Winner(winningPiece, col1, row1, col2, row2);
                }
            }
        }

        for (int i = 0; i < NUM_OF_COLS; i++) {// rows 5 row checker

            if(pieces[i][0]==pieces[i][1] && pieces[i][1]==pieces[i][2] && pieces[i][2]==pieces[i][3]){
                winningPiece = pieces[i][0];
                if(winningPiece != Piece.EMPTY) {
                    col1 = i;
                    col2 = i;
                    row1 = 0;
                    row2 = 3;
                    return new Winner(winningPiece,col1,row1,col2,row2);
                }
            }
            else if(pieces[i][1]==pieces[i][2] && pieces[i][2]==pieces[i][3] && pieces[i][3]==pieces[i][4]){
                winningPiece = pieces[i][1];
                if (winningPiece != Piece.EMPTY) {
                    col1 = i;
                    col2 = i;
                    row1 = 1;
                    row2 = 4;
                    return new Winner(winningPiece, col1, row1, col2, row2);
                }
            }
        }
        return new Winner(Piece.EMPTY);

    }


}
