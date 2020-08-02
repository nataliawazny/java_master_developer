package br.com.softblue.tictactoe.core;

public class Move {
	
	int i;
	int j;
	
	public Move(String moveStr) throws InvalidMoveException {
		try {
			//"0,0"
			String[] tokens = moveStr.split(",");
			//["0","0"]
			this.i = Integer.parseInt(tokens[0]);
			this.j = Integer.parseInt(tokens[1]);
		} catch(Exception e) {
			throw new InvalidMoveException("A jogada é inválida");
		}
	}
	
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
