package com.codari.api5.attribute;

public interface AttributeTemplate {
	public String getId();
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
