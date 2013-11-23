package com.codari.api5.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

/**
 * <p>Assists with the serialization process for objects implementing {@link java.io.Serializable Serializable}
 * and {@link org.bukkit.configuration.serialization.ConfigurationSerializable ConfigurationSerializable}.</p>
 * 
 * 
 * @author Soren025
 */
public final class CodariSerialization {
	//-----Private Constructor-----//
	/**
	 * <p>Private constructor to prevent construction.</p>
	 */
	private CodariSerialization(){}
	
	//-----Methods-----//
	public static void serialize(Object obj, OutputStream out) throws CodariSerializationException {
		if (out == null) {
			throw new IllegalArgumentException("OutputStream must not be null");
		}
		try (BukkitObjectOutputStream objectOut = new BukkitObjectOutputStream(out)) {
			objectOut.writeObject(obj);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static void serialize(Object obj, File file) throws CodariSerializationException {
		try (FileOutputStream fileOut = new FileOutputStream(file)) {
			serialize(obj, fileOut);
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static byte[] serialize(Object obj) throws CodariSerializationException {
		try (ByteArrayOutputStream byteDataOut = new ByteArrayOutputStream(512)) {
			serialize(obj, byteDataOut);
			return byteDataOut.toByteArray();
		} catch (IOException ex) {
			throw new CodariSerializationException(ex);
		}
	}
	
	public static Object deserialize(InputStream in) throws CodariSerializationException {
		if (in == null) {
			throw new IllegalArgumentException("InputStream must not be null");
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
			throw new IllegalArgumentException("Byte data must not be null");
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
	
	public static void registerConfigurationSerializable(Class<? extends ConfigurationSerializable> clazz) {
		SerializableAs serializableAs = clazz.getAnnotation(SerializableAs.class);
		if (serializableAs != null) {
			ConfigurationSerialization.registerClass(clazz, serializableAs.value());
		} else {
			ConfigurationSerialization.registerClass(clazz);
		}
	}
}
