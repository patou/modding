package com.sfeir.modding.client.component.formator;


/**
 * 
 * Met le texte en minuscule
 * @author sfeir
 */
public class LowerCaseFormator extends Formator<String> {
    @Override
    public String format(String value) {
        return value.toLowerCase();
    }
}
