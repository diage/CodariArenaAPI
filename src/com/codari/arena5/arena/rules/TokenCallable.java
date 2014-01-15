package com.codari.arena5.arena.rules;

public interface TokenCallable<T> {
	public String store(T obj);
	public T call(String string);
}