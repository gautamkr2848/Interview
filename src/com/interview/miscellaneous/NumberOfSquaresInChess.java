package com.interview.miscellaneous;

public class NumberOfSquaresInChess {

    public Long squaresInChessBoard(Long n) {
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;
    }
}