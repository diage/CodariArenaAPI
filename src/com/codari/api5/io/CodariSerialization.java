package com.codari.api5.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

public final class CodariSerialization {
	//-----Private Constructor-----//
	private CodariSerialization(){}
	
	//-----Methods-----//
	public static void serialize(OutputStream out, Object obj) throws CodariSerializationException {
		if (out == null) {
			throw new NullPointerException();
		}
		try (BukkitObjectOutputStream objectOut = new BukkitObjectOutputStream(out)) {
			objectOut.writeObject(obj);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static void serialize(File file, Object obj) throws CodariSerializationException {
		try (FileOutputStream fileOut = new FileOutputStream(file)) {
			serialize(fileOut, obj);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static byte[] serialize(Object obj) throws CodariSerializationException {
		try (ByteArrayOutputStream byteDataOut = new ByteArrayOutputStream(512)) {
			serialize(byteDataOut, obj);
			return byteDataOut.toByteArray();
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static Object deserialize(InputStream in) throws CodariSerializationException {
		if (in == null) {
			throw new NullPointerException();
		}
		try (BukkitObjectInputStream objectIn = new BukkitObjectInputStream(in)) {
			return objectIn.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static Object deserialize(File file) throws CodariSerializationException {
		try (FileInputStream fileIn = new FileInputStream(file)) {
			return deserialize(fileIn);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static Object deserialize(byte[] byteData) throws CodariSerializationException {
		if (byteData == null) {
			throw new NullPointerException();
		}
		try(ByteArrayInputStream dataIn = new ByteArrayInputStream(byteData)) {
			return deserialize(dataIn);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static <T> T clone(T obj) throws CodariSerializationException {
		byte[] byteData = serialize(obj);
		@SuppressWarnings("unchecked")//If it was serialized as T it should deserialize as T
		T result = (T) deserialize(byteData);
		return result;
	}
}
