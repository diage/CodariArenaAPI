package com.codari.api5;

import com.codari.api5.metadata.MetadataManager;
import com.codari.api5.stats.StatFactory;
import com.codari.arena5.ArenaManager;
import com.codari.arena5.Library;

public class Codari {
	public static MetadataManager getMetadataManager() {
		return CodariI.INSTANCE.getMetadataManager();
	}
	
	public static ArenaManager getArenaManager() {
		return CodariI.INSTANCE.getArenaManager();
	}
	
	public static StatFactory getStatFactory() {
		return CodariI.INSTANCE.getStatFactory();
	}
	
	public static Library getLibrary() {
		return CodariI.INSTANCE.getLibrary();
	}
}
