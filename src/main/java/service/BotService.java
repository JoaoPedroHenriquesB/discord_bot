package service;

import java.util.Random;

public class BotService {
	
	public enum CaraCoroa {
		CARA,
		COROA;
	}
	
	public static CaraCoroa caraOuCoroa() {
		int random = new Random().nextInt(0, 1);
		
		return CaraCoroa.values()[random];
	}
}
