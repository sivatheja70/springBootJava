package com.example.springboot.service;

import java.io.Serializable;

public class FormErrors implements LookupTarget<String, String> , Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected Map<String, FieldErrors> fieldNamesToErrors = new LinkedHashMap <String, FieldErrors>();
    protected Map<String, String> styleLookupMap = new LookupMap<String, String>(this);
    protected Locale locale;

    public FormErrors(Locale locale) {
        this.locale = locale;
    }

    public void addError(String field, MessageWO message) {
        getFieldErrors(field).addError(message);

    }

    public List<MessageWO> getErrors(String field) {
        return getFieldErrors(field).getErrorMessages();
    }

    public void removeErrorField(String key) {
        if(this.getAllErrorFieldsMap().get(key)!=null) {
            this.getAllErrorFieldsMap().remove(key);
        }

        if(fieldNamesToErrors.get(key)!=null) {
            fieldNamesToErrors.remove(key);
        }
    }

    private FieldErrors getFieldErrors(String field) {
        FieldErrors errors = fieldNamesToErrors.get(field);
        if (errors == null) {
            errors = new FieldErrors(field);
            fieldNamesToErrors.put(field, errors);
        }

        return errors;
    }

    public void clearErrors(String field) {
        getFieldErrors(field).clearErrors();
    }

    public void clearAllErrors() {
        Set<String> keys = this.fieldNamesToErrors.keySet();
        for(String key : keys) {
            clearErrors(key);
        }
    }

    public boolean hasNoErrors(String field) {

        return getFieldErrors(field).hasNoErrors();
    }

    public List<MessageWO> getAllErrors() {
        List<MessageWO> allErrors = new ArrayList<MessageWO>();

        Set<String> fields = this.fieldNamesToErrors.keySet();
        for(String field : fields) {
            List<MessageWO> fieldErrors = this.fieldNamesToErrors.get(field).getErrorMessages();
            for(MessageWO error : fieldErrors) {
                allErrors.add(error);
            }
        }
        return allErrors;
    }

    public Set<String> getAllErrorFields() {
        Set<String> fieldNames = this.fieldNamesToErrors.keySet();
        Set<String> fieldsWithErrors = new HashSet<String>();
        for(String field : fieldNames) {
            if (this.fieldNamesToErrors.get(field).hasNoErrors() == false) {
                fieldsWithErrors.add(field);
            }
        }
        return fieldsWithErrors;
    }

    public void setFieldStyles(String field, String validStyle, String errorStyle) {
        FieldErrors errors = getFieldErrors(field);
        errors.setValidStyle(validStyle);
        errors.setErrorStyle(errorStyle);
    }

    public String getFieldStyle(String field) {
        return getFieldErrors(field).getFieldStyle();
    }

    public Map<String, String> getFieldStyles() {
        return this.styleLookupMap;
    }

    public String lookup(String field) {
        return getFieldStyle(field);
    }

    public void addErrors(Map<String, List<MessageWO>> errorMessages) {

        Set<String> fields = errorMessages.keySet();
        for(String field : fields) {
            List<MessageWO> messageList = errorMessages.get(field);
            for(MessageWO message : messageList) {
                addError(field, message);
            }
        }

    }

    public boolean hasNoErrors() {
        Set<String> fields = this.fieldNamesToErrors.keySet();
        for(String field : fields) {
            FieldErrors errors = this.fieldNamesToErrors.get(field);
            if (errors.hasNoErrors() == false) {
                return false;
            }
        }
        return true;
    }

    public List<String> getAllErrorMessages() {
        List<String> allErrors = new ArrayList<String>();

        for(Map.Entry<String, FieldErrors> field : fieldNamesToErrors.entrySet()) {
            for(MessageWO error : field.getValue().getErrorMessages()) {
                allErrors.add(getErrorMessageText(field.getKey(), locale, error));
            }
        }

        return allErrors;
    }

    public List<String> getAllErrorMessagesLinked() {
        List<String> allErrors = new LinkedList<String>();

        for(Map.Entry<String, FieldErrors> field : fieldNamesToErrors.entrySet()) {
            for(MessageWO error : field.getValue().getErrorMessages()) {
                allErrors.add(getErrorMessageText(field.getKey(), locale, error));
            }
        }

        return allErrors;
    }

    /** New Code Base GANGA */
    public Map<String, String> getAllErrorFieldsMap() {
        Set<String> fieldNames = this.fieldNamesToErrors.keySet();
        Map<String, String> fieldsWithErrors = new HashMap<String, String>();
        for(String field : fieldNames) {
            if (!this.fieldNamesToErrors.get(field).hasNoErrors()) {
                fieldsWithErrors.put(field, field);
            }
        }
        return fieldsWithErrors;
    }


    /** New Code Base GANGA */
    /*
     *
     * This method has been replace with above method for better performance.
     *
     * Comment By : -  Ganga
     *
     * */
    protected String getErrorMessageText(String field, Locale locale, MessageWO m) {
        String[] params = null;
        int paramLength = 1;
        String errorMessage = MessageResourceManager.getInstance().getErrorMessageProperties().getProperty(m.getMessageKey());
        String labelName = MessageResourceManager.getInstance().getTextProperties().getProperty(field);
        if (m.getParams() != null) {
            paramLength = m.getParams().length + 1;
            params = new String[paramLength];
            params[0] = labelName;
            int i = 1;
            for (String s : m.getParams()) {
                params[i] = s; i++;
            }
        }else{
            params = new String[paramLength];
            params[0] = labelName;
        }
        if(params != null){
            MessageFormat mf = new MessageFormat(errorMessage, locale);
            errorMessage = mf.format(params, new StringBuffer(), null).toString();
        }
        return errorMessage;
    }



	/*
	protected String getErrorMessageText(String field, Locale locale, MessageWO m) {
		String labelName = MessageResourceUtils.getMessageResourceString("application.text", field, null, locale);
		int paramLength = 1;
		if (m.getParams() != null) {
			paramLength = m.getParams().length + 1;
		}
		String[] params = new String[paramLength];
		params[0] = labelName;
		if (m.getParams() != null) {
			int i = 1;
			for (String s : m.getParams()) {
				params[i] = s;
				i++;
			}
		}
		String errorMessage = MessageResourceUtils.getMessageResourceString("application.error-messages", m.getMessageKey(), params, locale);
		return errorMessage;
	}*/

}
