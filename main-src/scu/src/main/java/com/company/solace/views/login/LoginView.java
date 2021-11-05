package com.company.solace.views.login;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Login Page")
@Route(value = "login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm loginForm = new LoginForm();

    private EmailField email = new EmailField("Email address");
    private PasswordField password = new PasswordField("Password");

    private Button cancel = new Button("Cancel");
    private Button login = new Button("Log in");

    public LoginView(){
        //Image
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(createTitle(),loginForm);
        loginForm.setAction("login");
    }

    /**
     *
     * @param beforeEnterEvent
     */
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error")){
            loginForm.setError(true);
        }
    }

    /**
     *
     * @return
     */
    public Component createTitle(){
        return new H2("Solace Credit Union");
    }
}