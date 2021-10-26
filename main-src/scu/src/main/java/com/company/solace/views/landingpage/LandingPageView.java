package com.company.solace.views.landingpage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Theme(themeFolder = "flowcrmtutorial")
@PageTitle("Solace Credit Union")
@Route(value = "")
public class LandingPageView extends VerticalLayout {

    private Button loginButton = new Button("Login");
    private Button signupButton = new Button("Sign up");

    public LandingPageView() {
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        add(new H1("Solace Credit Union"));
        add(new Paragraph("Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"));

        add(configureButtonSection());

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    public HorizontalLayout configureButtonSection(){
        HorizontalLayout section = new HorizontalLayout(loginButton,signupButton);
        //section.addClassName();
        return section;
    }

}
