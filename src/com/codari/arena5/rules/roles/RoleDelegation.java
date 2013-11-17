package com.codari.arena5.rules.roles;

import java.util.Collection;

import com.codari.arena5.objects.persistant.RoleSelectionObject;

/**
 * Object to decide how to delegate roles to players for an Arena. 
 * 
 * In order for this to be valid, either RANDOM or SELECT_BEFORE must be chosen 
 * 	OR if SELECT_START with at least one {@link RoleSelectionObject} assigned. 
 * @author Ryan
 *
 */
public interface RoleDelegation {
	/**
	 * Method to set the RoleDelegationType of this Arena which this will eventually be added to. 
	 * 
	 * @param roleDelegationType The RoleDelegationType to set. 
	 */
	public void setRoleDelegationType(RoleDelegationType roleDelegationType);
	
	/**
	 * Method to add a RoleSelectionObject to this Arena.
	 *  
	 * @param roleSelectionObject The RoleSelectionObject to add. 
	 */
	public void addRoleSelectionObject(RoleSelectionObject roleSelectionObject);
	
	/**
	 * method to set the RoleDelegationType for this Arena. 
	 * 
	 * @return The RoleDelegationType for this Arena.
	 */
	public RoleDelegationType getRoleDelegationTechnique();
	
	/**
	 * Method to get all of the RoleSelectionObject for this Arena. 
	 * 
	 * @return A collection of all RoleSelectionObjects. 
	 */
	public Collection<RoleSelectionObject> getRoleSelectionObjects();
	
	/**
	 * Method to verify if this is a valid RoleDelegation.
	 * 
	 * @return True if valid, false if not valid. This will be not valid if SELECT_START is chosen and no object added 
	 * 	OR no RoleDelegationType is chosen.  
	 */
	public boolean isValidRoleDelegation();
}
