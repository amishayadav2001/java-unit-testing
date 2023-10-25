package com.aurionpro.model;

public class Cell {
    private MarkType mark;

    public Cell() {
        this.mark = MarkType.EMPTY;
    }

    public boolean isEmpty() {
        return mark == MarkType.EMPTY;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws CellAlreadyMarkedException {
        if (this.mark == MarkType.EMPTY) {
            this.mark = mark;
        } else {
            throw new CellAlreadyMarkedException("Cell is already marked.");
        }
    }
}
