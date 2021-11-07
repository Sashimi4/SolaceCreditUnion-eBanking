package com.company.solace.views.creditcardform;

import com.company.solace.data.entity.CreditCard;
import com.company.solace.data.service.CreditCardService;
import com.company.solace.views.main.MainLayout;
import com.company.solace.views.map.MapView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Credit Card Form")
@Route(value = "Credit-Card-Form", layout = MainLayout.class)
@RouteAlias(value = "credit-card-form", layout = MainLayout.class)

public class CreditCardFormView extends Div {

    private TextField cardNumber = new TextField("Credit card number *");
    private TextField cardholderName = new TextField("Cardholder name [ email ]*");
    private Select<Integer> month = new Select<>();
    private Select<Integer> year = new Select<>();
    private ExpirationDateField expiration = new ExpirationDateField("Expiration date", month, year);
    private PasswordField csc = new PasswordField("CSC *");
    private PasswordField cardHolderPassword = new PasswordField("Password");

    private Button cancel = new Button("Cancel");
    private Button submit = new Button("Submit");

    private Binder<CreditCard> binder = new Binder<>(CreditCard.class);

    @Autowired
    private CreditCardService creditCardService;

    public CreditCardFormView() {
        addClassName("credit-card-form-view");
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        validateCreditCard();

        cancel.addClickListener(e -> clearForm());
        submit.addClickListener(e -> {
            save();
            Notification.show("Credit card linked to account successful!");
            clearForm();
            submit.getUI().ifPresent(ui -> ui.navigate(MapView.class));
        });

    }

    /**
     *
     */
    private void clearForm() {
        binder.setBean(new CreditCard());
    }

    public void setCustomer(CreditCard creditCard){
        binder.setBean(creditCard);
        if(creditCard == null){
            setVisible(false);
        }else {
            setVisible(true);
            cardNumber.focus();
        }
    }

    /**
     *
     */
    private void save(){
        CreditCard creditCard = binder.getBean();
        creditCardService.saveCustomer(creditCard);
    }

    /**
     *
     */
    private void validateCreditCard(){
        binder.forField(cardNumber).withValidator(cardnumber -> cardnumber.length() == 16, "Invalid credit card number").bind(CreditCard::getCardNumber, CreditCard::setCardNumber);
        binder.forField(csc).withValidator(cscnumber -> cscnumber.length() == 3, "Invalid pin number").bind(CreditCard::getCsc, CreditCard::setCsc);
        //binder.forField(expiration).withValidator(date -> date.length() > 0, "No date specified").bind();
    }

    private Component createTitle() {
        return new H3("Credit Card");
    }

    /**
     *
     * @return
     */
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(cardNumber, cardholderName, expiration, csc);
        return formLayout;
    }

    /**
     *
     * @return
     */
    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        cardNumber.setPlaceholder("1234 5678 9123 4567");
        cardNumber.setPattern("[\\d ]*");
        cardNumber.setPreventInvalidInput(true);
        cardNumber.setRequired(true);
        cardNumber.setErrorMessage("Please enter a valid credit card number");
        month.setPlaceholder("Month");
        month.setItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        year.setPlaceholder("Year");
        year.setItems(21, 22, 23, 24, 25, 26);
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        buttonLayout.add(submit);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    /**
     *
     */
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
