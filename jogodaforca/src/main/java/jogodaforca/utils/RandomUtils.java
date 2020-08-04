package jogodaforca.utils;

import java.util.Random;

public class RandomUtils {
	
	private static Random random = new Random();
	
	public static int newRandomNumber(int min, int max) {
		//ex num entre 5 e 10. (10 - 5) = 5. Será gerado um número entre 0 e 4, por ex 3. 3 + 5(min) = 7.
		return random.nextInt(max - min) + min;
	}

}
