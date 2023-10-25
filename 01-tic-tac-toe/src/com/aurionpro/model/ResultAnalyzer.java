package com.aurionpro.model;

public class ResultAnalyzer {
	private Board board;
	private ResultType result;

	public ResultAnalyzer(Board board) {
		this.board = board;
		this.result = ResultType.PROGRESS;
	}

	private boolean checkLine(MarkType mark, int... cells) {
		for (int cell : cells) {
			if (board.getCellMark(cell) != mark) {
				return false;
			}
		}
		return true;
	}

	private boolean checkHorizontalWin(MarkType mark) {
		for (int row = 0; row < 3; row++) {
			int start = row * 3;
			if (checkLine(mark, start, start + 1, start + 2)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkVerticalWin(MarkType mark) {
		for (int col = 0; col < 3; col++) {
			if (checkLine(mark, col, col + 3, col + 6)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonalWin(MarkType mark) {
		return checkLine(mark, 0, 4, 8) || checkLine(mark, 2, 4, 6);
	}

	public ResultType analyzeResult() {
		MarkType[] marks = MarkType.values();

		for (MarkType mark : marks) {
			if (checkHorizontalWin(mark) || checkVerticalWin(mark) || checkDiagonalWin(mark)) {
				result = ResultType.WIN;
				return result;
			}
		}

		if (board.isBoardFull()) {
			result = ResultType.DRAW;
		}

		return result;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ResultType getResult() {
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}
}
