package lk.ijse.dep.service;

import lk.ijse.dep.service.impl.Winner;

public class HumanPlayer extends Player{
    BoardUI boardController;
    int col1;

    boolean isTrue;
    Winner winner;
    Board newBoard;
    public HumanPlayer(Board board){
        super(board);
    }
    @Override
    public void movePiece(int col1) {
        isTrue = board.isLegalMove(col1);
        if(isTrue) {
            board.UpdateMove(col1, Piece.BLUE);
            board.getBoardUI().update(col1, isTrue);

            winner = board.findWinner();

            if (winner.getWinningPiece() != Piece.EMPTY) {
                board.getBoardUI().notifyWinner(winner);
            } else {
                if (board.existLegelMove() != true) {
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }
        }
    }
}
