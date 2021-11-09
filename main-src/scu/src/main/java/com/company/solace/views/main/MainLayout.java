package com.company.solace.views.main;

import com.company.solace.data.security.SecurityService;
import com.company.solace.views.creditcardform.CreditCardFormView;
import com.company.solace.views.customerform.CustomerFormView;
import com.company.solace.views.home.HomeView;
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
 * Main web app layout class containing interchangable content field, but still static components such as headers.
 */
@PageTitle("Workspace")
@Route(value = "home")
public class MainLayout extends AppLayout {

    private final SecurityService securityService;
    private H1 viewTitle;
    private final Tabs menu;

    /**
     * Constructor for creating main app layout.
     *
     * @param securityService       Service object for implementing security over internal resorces.
     */
    public MainLayout(SecurityService securityService){
        this.securityService = securityService;
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));
    }

    /**
     * Creates a custom header component.
     *
     * @return      Header component
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
     * Custom component creating drawer content which can be opened and closed.
     *
     * @param menu      available tabs
     * @return          custom component containing different tabs which can be chosen.
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
     * Creates menu tab with orientation and theme.
     *
     * @return       all tabs added.
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
     * Define navigation text and the specified view
     *
     * @return          All components in the drawer
     */
    private Component[] createMenuItems(){
        return new Tab[]{
                createTab("Home Dashboard", HomeView.class),
                createTab("Credit Card Form", CreditCardFormView.class),
                createTab("Location", MapView.class),
                createTab("Sign up", CustomerFormView.class)
        };
    }

    /**
     *  Create linking tab fo drawer component and the new component to be navigated to.
     *
     * @param text                  component name
     * @param navigationTarget      component target
     * @return                      tab with navigation
     */
    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    /**
     *  Sets title and content right after navigating.
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
     *  Retrieve content field with the corresponding tab
     *
     * @param component
     * @return               retrieved component tab
     */
    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        return getContent().getClass().getAnnotation(PageTitle.class).value();
    }

}
