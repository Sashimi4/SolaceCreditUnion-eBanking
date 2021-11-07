package com.company.solace.views.main;

import com.company.solace.data.security.SecurityService;
import com.company.solace.views.HelloWorldView;
import com.company.solace.views.creditcardform.CreditCardFormView;
import com.company.solace.views.map.MapView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.Optional;

/**
 *
 */
@PageTitle("Workspace")
@Route(value = "")
public class MainLayout extends AppLayout {

    private final SecurityService securityService;
    private H1 viewTitle;
    private final Tabs menu;

    /**
     *
     * @param securityService
     */
    public MainLayout(SecurityService securityService){
        this.securityService = securityService;
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));
    }

    /**
     *
     * @return
     */
    private Component createHeaderContent() {
        HorizontalLayout header = new HorizontalLayout();

        header.setId("header");
        header.getThemeList().set("dark", true);
        header.setWidthFull();
        header.setSpacing(false);
        header.setAlignItems(FlexComponent.Alignment.CENTER);

        header.add(new DrawerToggle());

        viewTitle = new H1();
        header.add(viewTitle);

        //header.add(new Image("images/empty-plant.png", "Avatar"));

        Button logout = new Button("Log out", e -> securityService.logout());
        header.add(logout);

        return header;
    }

    /**
     *
     * @param menu
     * @return
     */
    private Component createDrawerContent(Tabs menu){
        VerticalLayout layout = new VerticalLayout();

        // Configure styling for the drawer
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);

        // Have a drawer header with an application logo
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/empty-plant.png", "My Project logo"));
        logoLayout.add(new H1("My Project"));

        // Display the logo and the menu in the drawer
        layout.add(logoLayout, menu);
        return layout;
    }

    /**
     *
     * @return
     */
    private Tabs createMenu() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        return tabs;
    }

    /**
     *
     * @return
     */
    private Component[] createMenuItems(){
        return new Tab[]{
                createTab("Credit Card Form", CreditCardFormView.class),
                createTab("Location", MapView.class),
                createTab("Hello World", HelloWorldView.class)
        };
    }

    /**
     *
     * @param text
     * @param navigationTarget
     * @return
     */
    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    /**
     *
     */
    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        // Select the tab corresponding to currently shown view
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);

        // Set the view title in the header
        viewTitle.setText(getCurrentPageTitle());
    }

    /**
     *
     * @param component
     * @return
     */
    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    /**
     *
     * @return
     */
    private String getCurrentPageTitle() {
        return getContent().getClass().getAnnotation(PageTitle.class).value();
    }

}
