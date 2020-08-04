package jogodaforca.game;

import java.util.HashSet;
import java.util.Set;

import jogodaforca.core.Config;
import jogodaforca.core.Dictionary;
import jogodaforca.core.InvalidCharacterException;
import jogodaforca.core.Word;
import jogodaforca.ui.UI;

public class Game {
	
	public void start(String[] args) {
		UI.print("Bem vindo ao jogo da forca!");
		
		Dictionary dictionary = Dictionary.getInstance();
		UI.print("Dicion�rio usado: " + dictionary.getName());
		
		Word word =  dictionary.nextWord();
		
		UI.print("A palavra tem " + word.size() + " letras");
		
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		if(args.length > 0) {
			Config.setMaxErrors(args[0]);
		}
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("Voc� pode errar no m�ximo " + maxErrors + " vezes");
		
		while(true) {
			UI.print(word);
			UI.printNewLine();
			
			char c;
			try {
				c = UI.readChar("Digite uma letra:");
				
				if(usedChars.contains(c)) {
					throw new InvalidCharacterException("Esta letra j� foi utilizada");
				}
				
				usedChars.add(c);
				
				if(word.hasChar(c)) {
					UI.print("Voc� acertou uma letra");
				} else {
					errorCount++;
					if(errorCount < maxErrors) {
						UI.print("Voc� errou! Voc� ainda pode errar " + (maxErrors - errorCount) + " vez(es)");
					}
				}
				
				UI.printNewLine();
				
				if(word.discovered()) {
					UI.print("PARAB�NS! Voc� acertou a palavra: " + word.getOriginalWord());
					UI.print("Fim do jogo!");
					break;
				}
				
				if(errorCount == maxErrors) {
					UI.print("Voc� perdeu o jogo! A palavra correta �: " + word.getOriginalWord());
					UI.print("Fim do jogo!");
					break;
				}
			} catch(InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}
	}

}
