package com.codari.arena5.arena.rules.roledelegation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.codari.arena5.arena.rules.Argument;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RoleDeclarationName {
	String value();
	Argument[] constructorArguments() default {};
}
