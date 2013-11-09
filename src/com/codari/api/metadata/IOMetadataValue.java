package com.codari.api.metadata;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.bukkit.metadata.MetadataValueAdapter;
import org.bukkit.plugin.Plugin;

import com.codari.api.io.CodariIO;

public final class IOMetadataValue extends MetadataValueAdapter {
	//-----Fields-----//
	private final File file;
	private Object value;
	
	//-----Constructors-----//
	public IOMetadataValue(Plugin owningPlugin, Object value, File file) {
		super(owningPlugin);
		this.file = Validate.notNull(file);
		if (!this.reload()) {
			this.value = value != null ? value : ObjectUtils.NULL;	
		}
	}

	//-----Public Methods-----//
	@Override
	public Object value() {
		if (this.value == ObjectUtils.NULL) {
			this.reload();
		}
		return this.value;
	}
	
	@Override
	public void invalidate() {
		this.save();
		this.value = ObjectUtils.NULL;
	}
	
	public boolean save() {
		if (this.value != ObjectUtils.NULL) {
			try {
				CodariIO.serialize(this.value, this.file);
				return true;
			} catch (IOException ex) {
				//TODO Debug check
				ex.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean reload() {
		try {
			this.value = CodariIO.deserialize(file);
			return true;
		} catch (ClassNotFoundException | IOException ex) {
			//TODO Debug check
			ex.printStackTrace();
			return false;
		}
	}
}