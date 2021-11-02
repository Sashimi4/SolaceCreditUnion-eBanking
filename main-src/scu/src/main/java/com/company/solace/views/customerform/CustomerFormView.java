package com.company.solace.views.customerform;

import com.company.solace.data.entity.Customer;
import com.company.solace.data.service.CustomerService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Sign up")
@Route(value = "sign-up")
@Uses(Icon.class)
public class CustomerFormView extends Div {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email address");
    private DatePicker dateOfBirth = new DatePicker("Birthday");
    private PhoneNumberField phone = new PhoneNumberField("Phone number");
    private TextField address = new TextField("address");
    private ComboBox<String> country = new ComboBox<>();
    //private CheckboxGroup<String> mailSubscriber = new CheckboxGroup<>();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Customer> binder = new Binder<>(Customer.class);

    @Autowired
    private CustomerService customerService;

    public CustomerFormView() {

        addClassName("person-form-view");
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        readCustomer();
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            save();
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        });
    }

    private void readCustomer(){
        binder.forField(firstName).withValidator(name -> name.length() >= 3, "Full name must contain at least three characters").bind(Customer::getFirstName, Customer::setFirstName);
        binder.forField(firstName).withValidator(name -> name.length() >= 3, "Full name must contain at least three characters").bind(Customer::getFirstName, Customer::setFirstName);


    }

    private void save() {
        Customer customer = binder.getBean();
        customerService.saveCustomer(customer);
    }

    public void setCustomer(Customer customer){
        binder.setBean(customer);
        if(customer == null){
            setVisible(false);
        }else {
            setVisible(true);
            firstName.focus();
        }
    }

    private void clearForm() {
        binder.setBean(new Customer());
    }

    private Component createTitle() {
        return new H3("Personal information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        //mailSubscriber.setLabel("Mail Subscriber");
        //mailSubscriber.setItems("Yes please", "No thank you");
        //mailSubscriber.setValue(Collections.singleton("true"));
        //mailSubscriber.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        country.setLabel("Country");
        country.setItems("Australia", "Switzerland", "Britain", "Canada");
        country.setHelperText("Select your current residence location");
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(firstName, lastName, dateOfBirth, phone, email, address, country);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setPattern("\\+\\d*");
            countryCode.setPreventInvalidInput(true);
            countryCode.setItems("+354", "+91", "+62", "+98", "+964", "+353", "+44", "+972", "+39", "+225", "+41");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setPattern("\\d*");
            number.setPreventInvalidInput(true);
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
    public Binder<Customer> getBinder() {
        return binder;
    }
}
