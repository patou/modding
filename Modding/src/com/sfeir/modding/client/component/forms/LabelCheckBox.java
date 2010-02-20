package com.sfeir.modding.client.component.forms;

import java.util.Map;

import com.google.gwt.user.client.ui.CheckBox;
import com.sfeir.modding.client.component.forms.base.LabelComponentBase;

/**
 * Champ à choix binaire (Case à cocher)
 * @author sfeir
 */
public class LabelCheckBox extends LabelComponentBase<CheckBox, Boolean> {

    /**
     * 
     */
    public LabelCheckBox() {
    }

    /**
     * @param text
     */
    public LabelCheckBox(String text) {
        super(text);
    }

    /**
     * @param text
     * @param mandatory
     */
    public LabelCheckBox(String text, boolean mandatory) {
        super(text, mandatory);
    }

    /**
     * @param config
     */
    public LabelCheckBox(Map<String, Object> config) {
        super(config);
    }

    /* (non-Javadoc)
     * @see fr.bred.commun.ria.client.component.label.base.LabelComponentBase#clearComponent()
     */
    @Override
    public void clearComponent() {
        getComponent().setValue(false);
    }
    
    @Override
    public Boolean defaultValue() {
        return false;
    }

    /* (non-Javadoc)
     * @see fr.bred.commun.ria.client.component.label.base.LabelComponentBase#createComponent()
     */
    @Override
    protected CheckBox createComponent() {
        return new CheckBox();
    }

}
