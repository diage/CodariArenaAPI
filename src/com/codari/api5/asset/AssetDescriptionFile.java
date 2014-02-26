package com.codari.api5.asset;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public final class AssetDescriptionFile {
	//-----Constants-----//
	private static final Yaml YAML = new Yaml(new SafeConstructor());
	
	//-----Static Methods-----//
	public static AssetDescriptionFile load(InputStream stream) throws InvalidAssetDescriptionFileException {
		return parse(YAML.load(stream));
		
	}
	
	public static AssetDescriptionFile load(Reader reader) throws InvalidAssetDescriptionFileException {
		return parse(YAML.load(reader));
	}
	
	private static AssetDescriptionFile parse(Object obj) throws InvalidAssetDescriptionFileException {
		if (obj instanceof Map) {
			return new AssetDescriptionFile((Map<?,?>) obj);
		}
		throw new InvalidAssetDescriptionFileException("asset description file not properly structured");
	}
	
	//-----Fields-----//
	private final String name;
	private final String version;
	private final List<String> assets;
	
	//-----Constructor-----//
	private AssetDescriptionFile(Map<?,?> args) /*throws InvalidAssetDescriptionFileException */{
		this.assets = new ArrayList<>();
		this.name = "";
		this.version = "";
	}
	
	//-----Methods-----//
	public String getName() {
		return this.name;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public List<String> getAssets() {
		return this.assets;
	}
}
