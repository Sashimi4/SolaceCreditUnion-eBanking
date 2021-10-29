package com.company.solace.views.creditcardform;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class CreditCardForm extends FormLayout {

    private TextField cardNumber = new TextField("Credit card number");
    private TextField cardHolder = new TextField("Account");
    private Select<Integer> month = new Select<>();
    private Select<Integer> year = new Select<>();
    private ExpirationDateField expiration = new CreditCardFormView.ExpirationDateField("Expiration date", month, year);
    private PasswordField csc = new PasswordField("CSC");

    private Button cancel = new Button("Cancel");
    private Button submit = new Button("Submit");

    private class ExpirationDateField extends CustomField<String> {
        public ExpirationDateField(String label, Select<Integer> month, Select<Integer> year) {
            setLabel(label);
            HorizontalLayout layout = new HorizontalLayout(month, year);
            layout.setFlexGrow(1.0, month, year);
            month.setWidth("100px");
            year.setWidth("100px");
            add(layout);
        }
        @Override
        protected String generateModelValue() {
            // Unused as month and year fields part are of the outer class
            return "";
        }
        @Override
        protected void setPresentationValue(String newPresentationValue) {
            // Unused as month and year fields part are of the outer class
        }
    }

}
