package com.codari.api5.attribute;

/**
 * Represents a template for an {@link Attribute}. An instance of {@code AttributeTemplate}
 * contains all of the core information that any {@code Attribute} created by it share.
 * <p>
 * When creating an {@code AttributeTemplate}, it's id must be unique. No two instances
 * can share the same id. An {@code AttributeTemplate} can be created by calling the method
 * {@link AttributeFactory#templateBuilder(String) templateBuilder(String)} in {@link AttributeFactory}.
 * <p>
 * {@code AttributeTemplate} is an immutable object.
 */
public interface AttributeTemplate {
	/**
	 * Gets the id of {@code this AttributeTemplate}. The id returned is a unique
	 * identifier for an {@code AttributeTemplate}.
	 * 
	 * @return a unique id for {@code this AttributeTemplate}
	 */
	public String getId();
	/**
	 * Gets the name of this attribute. Unlike the id, the name is not unique however is
	 * used to determine equality for an {@link Attribute}.
	 * 
	 * @return the name of {@code this AttributeTemplate}
	 */
	public String getName();
	public String getDescription();
	public double[] getBaseValues();
	public double getBaseValue(int level);
	public int getMaxLevel();
	public double getMinValue();
	public double getMaxValue();
	public Attribute buildAttribute();
	
	public static interface AttributeTemplateBuilder {
		public AttributeTemplate build() throws InvalidAttributeException;
		public AttributeTemplateBuilder setName(String displayName);
		public AttributeTemplateBuilder setDescription(String description);
		public AttributeTemplateBuilder setBaseValues(double[] baseValues);
		public AttributeTemplateBuilder setMinValue(double minValue);
		public AttributeTemplateBuilder setMaxValue(double maxValue);
	}
}
