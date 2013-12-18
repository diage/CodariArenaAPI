package com.codari.arena5.rules.roledelegation;

import java.io.Serializable;

public interface RoleDeclaration extends Serializable {
	/**
	 * 
	 * @return The name of the group all the roles were assigned under. 
	 */
	public String initalizeRoles();
}
