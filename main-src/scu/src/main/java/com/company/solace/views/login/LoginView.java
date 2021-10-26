package com.company.solace.views.login;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Login Page")
@Route(value = "login")
public class LoginView extends VerticalLayout {

    public LoginView(){
        Button button = new Button("Hey there!");
        VerticalLayout layout = new VerticalLayout(button);

        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(layout);
    }
}
