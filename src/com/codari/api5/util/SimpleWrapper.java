package com.codari.api5.util;

public class SimpleWrapper<T> implements Wrapper<T> {
	//-----Fields-----//
	private final T handle;
	
	//-----Constructor-----//
	public SimpleWrapper(T handle) {
		this.handle = handle;
	}
	
	//-----Public Methods-----//
	@Override
	public T getHandle() {
		return this.handle;
	}
	
	public <C extends T> C getHandleAs(Class<C> clazz) throws ClassCastException {
		return clazz.cast(this.getHandle());
	}
}