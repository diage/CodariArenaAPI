package com.codari.api.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.lang3.Validate;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

public final class CodariIO {
	//-----Static Methods-----//
	public static void serialize(Object obj, OutputStream out) throws IOException {
		Validate.notNull(out, "OutputStream must not be null");
		try (BukkitObjectOutputStream objectOut = new BukkitObjectOutputStream(out)) {
			objectOut.writeObject(obj);
		}
	}
	
	public static void serialize(Object obj, File file) throws IOException {
		try (FileOutputStream fileOut = new FileOutputStream(file)) {
			deleteContents(file);
			serialize(obj, fileOut);
		}
	}
	
	public static byte[] serialize(Object obj) throws IOException {
		try (ByteArrayOutputStream byteDataOut = new ByteArrayOutputStream(512)) {
			serialize(obj, byteDataOut);
			return byteDataOut.toByteArray();
		}
	}
	
	public static Object deserialize(InputStream in) throws IOException, ClassNotFoundException {
		Validate.notNull(in, "InputStream must not be null");
		try (BukkitObjectInputStream objectIn = new BukkitObjectInputStream(in)) {
			return objectIn.readObject();
		}
	}
	
	public static Object deserialize(File file) throws IOException, ClassNotFoundException {
		try (FileInputStream fileIn = new FileInputStream(file)) {
			return deserialize(fileIn);
		}
	}
	
	public static Object deserialize(byte[] byteDataIn) throws IOException, ClassNotFoundException {
		Validate.notNull(byteDataIn, "byte[] must not be null");
		try(ByteArrayInputStream dataIn = new ByteArrayInputStream(byteDataIn)) {
			return deserialize(dataIn);
		}
	}
	
	public static <T> T clone(T obj) throws IOException, ClassNotFoundException {
		byte[] byteData = serialize(obj);
		@SuppressWarnings("unchecked")//If it was serialized as T it should deserialize as T
		T result = (T) deserialize(byteData);
		return result;
	}
	
	public static void deleteContents(File file) throws IOException {
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.write("");
		}
	}
	
	//-----Constructor-----//
	private CodariIO(){}
}