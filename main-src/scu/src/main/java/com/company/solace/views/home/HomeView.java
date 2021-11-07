package com.company.solace.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home Dashboard")
@Route(value = "")
@Uses(Icon.class)
public class HomeView extends Div {

    public HomeView() {
        add(createContentBoard());
    }

    public Component createContentBoard(){
        Div div = new Div();
        div.add();


        return ;
    }





}
