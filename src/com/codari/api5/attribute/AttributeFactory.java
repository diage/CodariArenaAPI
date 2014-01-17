package com.codari.api5.attribute;

import com.codari.api5.attribute.AttributeTemplate.AttributeTemplateBuilder;

public interface AttributeFactory extends Iterable<AttributeTemplate> {
	public AttributeTemplateBuilder templateBuilder(String attributeId);
	public Attribute buildAttribute(String statId);
	public AttributeTemplate getTemplate(String attributeId);
	public AttributeTemplate[] getTemplates(String... attributeIds);
	public boolean isRegistered(String attributeId);
	public boolean isRegistered(String... attributeIds);
	public boolean isValidStatName(String name);
}
