package com.sfeir.modding.client.component.forms;

import java.util.Map;

import com.google.gwt.user.client.ui.PasswordTextBox;
import com.sfeir.modding.client.component.forms.base.LabelTextBoxBase;

/**
 * Champ de saisie de mot de passe avec un label
 * @author sfeir
 */
public class LabelPasswordBox extends LabelTextBoxBase<PasswordTextBox, String> {
    /**
     * 
     */
    public LabelPasswordBox() {
    }

    /**
     * @param label Label
     */
    public LabelPasswordBox(String label) {
        super(label);
    }

    /**
     * @param label
     * @param mandatory
     */
    public LabelPasswordBox(String label, boolean mandatory) {
        super(label, mandatory);
    }

    public LabelPasswordBox(Map<String, Object> config) {
        super(config);
    }

    @Override
    public void setConfig(Map<String, Object> config) {
        super.setConfig(config);
        if (config.containsKey("maxLength")) {
            setMaxLength((Integer) config.get("maxLength"));
        }
        if (config.containsKey("visibleLength")) {
            setVisibleLength((Integer) config.get("visibleLength"));
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.bred.commun.ria.client.component.LabelComponentBase#createComponent()
     */
    @Override
    protected PasswordTextBox createComponent() {
        return new PasswordTextBox();
    }

    public int getMaxLength() {
        return getComponent().getMaxLength();
    }

    public int getVisibleLength() {
        return getComponent().getVisibleLength();
    }

    public void setMaxLength(int length) {
        getComponent().setMaxLength(length);
    }

    public void setVisibleLength(int length) {
        getComponent().setVisibleLength(length);
    }
}
