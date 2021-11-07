package com.company.solace.views.landingpage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

/**
 * Class containing landing page view
 */
@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", enableInstallPrompt = false)
@Theme(themeFolder = "flowcrmtutorial")
@PageTitle("Solace Credit Union")
@Route(value = "landing page")
@Uses(Icon.class)
public class LandingPageView extends VerticalLayout {

    private Button loginButton = new Button("Login");
    private Button signupButton = new Button("Sign up");

    /**
     * Constructor for creating HTML/Typescript page.
     */
    public LandingPageView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("text-align", "center");
        add(configureMainSection());
    }

    /**
     * Configures the horizontal layout of the page containing login and sign up button.
     * Secondly sets up the button for routing to another page.
     *
     * @return      section     A finished HorizontalLayout object.
     */
    public HorizontalLayout configureMainSection(){
        HorizontalLayout section = new HorizontalLayout();
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        section.add(img);
        section.add(new H1("Solace Credit Union"));
        section.add(new Paragraph("Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"));
        loginButton.addClickListener((event) -> loginButton.getUI().ifPresent
                (ui -> ui.navigate("login")));
        signupButton.addClickListener((event) -> signupButton.getUI().ifPresent
                (ui -> ui.navigate("sign-up")));
        section.add(loginButton, signupButton);
        return section;
    }

}
