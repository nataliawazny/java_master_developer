package jogodaforca;

import jogodaforca.game.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		//args caso queira fornecer parāmetros via linha de comando
		game.start(args);
		

	}

}
