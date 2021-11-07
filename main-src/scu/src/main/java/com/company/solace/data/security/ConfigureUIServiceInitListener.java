package com.company.solace.data.security;

import com.company.solace.views.login.LoginView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.stereotype.Component;

/**
 *  This class configures all necessary Security Listeners.
 */
@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    /**
     * Adds listener object before changing views.
     * @param event     ServiceInit object which is created as soon as a security layer is present.
     */
    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::authenticateNavigation);
        });
    }

    /**
     * Reroutes the user to the login form, if they have accessed a view without login
     *
     * @param event     BeforeEnterEvent object which is created before entering a new view.
     */
    private void authenticateNavigation(BeforeEnterEvent event) {
        if (!LoginView.class.equals(event.getNavigationTarget())
                && !SecurityUtils.isUserLoggedIn()) {
            event.rerouteTo(LoginView.class);
        }
    }
}
