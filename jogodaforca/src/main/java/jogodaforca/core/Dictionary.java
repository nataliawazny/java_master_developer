package jogodaforca.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Dictionary {
	
	private static Dictionary instance;
	
	public static Dictionary getInstance() {
		if(instance==null) {
			
			//assim é só trocar no config.properties o nome da classe
			try {
				String dictionaryClassName = Config.get("dictionaryClassName");
				Class<?> clazz = Class.forName(dictionaryClassName);
				Constructor<?> constructor = clazz.getConstructor();
				Dictionary dictionary = (Dictionary) constructor.newInstance();
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException();
			}
			
			//dicionario.txt
			//instance = new FileDictionary();
			//estático
			//instance = new StaticDictionary();
		}
		return instance;
	}
	
	public abstract Word nextWord();
	
	public abstract String getName();

}
