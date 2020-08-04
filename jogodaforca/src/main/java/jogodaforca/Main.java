package jogodaforca;

import jogodaforca.game.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		//args caso queira fornecer parâmetros via linha de comando
		game.start(args);
		

	}

}
