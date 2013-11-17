package com.codari.arena5.objects.persistant;

import com.codari.arena5.players.role.Role;

/**
 * This is a type of ImmediatePersistantObject which can be used to assign roles to players. 
 * 
 * A required object if the RoleDelegationType of SELECT_START is chosen. 
 * @author Ryan
 *
 */
public interface RoleSelectionObject extends ImmediatePersistentObject {
	/**
	 * Method to return a Role based on how the object works. 
	 * @return The Role based on spcified conditions. 
	 */
	public Role roleSelect();
}
