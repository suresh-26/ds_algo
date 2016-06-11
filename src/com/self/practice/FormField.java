/*
 * Copyright (c) Rakuten, Inc. All Rights Reserved.
 * 
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of Use is only admitted in Rakuten Inc.
 * Development Department.
 * If you don't have permission , MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 * 
 * $Id$
 * Created on Oct 19, 2015
 * Updated on $Date$
 */
package com.self.practice;

/**
 * @author suresh.gupta
 *
 */

public class FormField  {

    /**serialVersionUID */
    private static final long serialVersionUID = 2789649936110061488L;

    /** The name. */
    private String name;

    /** The type. */
    private String type;

    /** The label. */
    private String label;

    /** The default value. */
    private String defaultValue;

    /** The block. */
    private Boolean block;

    /** The required. */
    private Boolean required;


    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Gets the block.
     *
     * @return the block
     */
    public Boolean getBlock() {
        return block;
    }

    /**
     * Gets the required.
     *
     * @return the required
     */
    public Boolean getRequired() {
        return required;
    }



    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the label.
     *
     * @param label
     *            the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Sets the default value.
     *
     * @param defaultValue
     *            the new default value
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Sets the block.
     *
     * @param block
     *            the new block
     */
    public void setBlock(Boolean block) {
        this.block = block;
    }

    /**
     * Sets the required.
     *
     * @param required
     *            the new required
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * Sets the attributes.
     *
     * @param attributes
     *            the attributes
     */


}
