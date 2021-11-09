package com.company.solace.views.home;

import com.company.solace.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home Dashboard")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class HomeView extends Div {

    //I'm sorry little one . . .
    //Your potential was limited by my
    public HomeView() {
        add(createTitleText());
        add(createSubtitleText());

        }


    private Component createTitleText() {
        VerticalLayout horizontalLayout = new VerticalLayout();
        H1 title = new H1("- Solace Credit Union -");
        horizontalLayout.add(title);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        return horizontalLayout;
    }

    private Component createSubtitleText() {
        VerticalLayout horizontalLayout = new VerticalLayout();
        horizontalLayout.add(new H3("For all your banking needs."));
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        return horizontalLayout;
    }


}
