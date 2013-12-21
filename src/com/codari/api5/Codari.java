package com.codari.api5;

import com.codari.api5.enchantment.EnchantmentManager;
import com.codari.api5.itemdata.ItemDataManager;
import com.codari.api5.player.CodariPlayerManager;
import com.codari.api5.stats.StatFactory;
import com.codari.arena5.Library;
import com.codari.arena5.arena.ArenaManager;

public class Codari {
	public static CodariPlayerManager getCodariPlayerManager() {
		return CodariI.INSTANCE.getCodariPlayerManager();
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
	
	public static EnchantmentManager getEnchantmentManager() {
		return CodariI.INSTANCE.getEnchantmentManager();
	}
	
	public static ItemDataManager getItemDataManager() {
		return CodariI.INSTANCE.getItemDataManager();
	}
}
