package com.codari.api.io;

import java.io.File;

import org.apache.commons.lang3.Validate;
import org.bukkit.configuration.file.FileConfiguration;

public final class CodariConfig {
	//-----Fields-----//
	private final File file;
	private FileConfiguration config;
	
	//-----Constructor-----//
	public CodariConfig(File file) {
		this.file = Validate.notNull(file, "the File must not be null");
	}
}