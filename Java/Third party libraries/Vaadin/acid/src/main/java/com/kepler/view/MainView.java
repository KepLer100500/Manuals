package com.kepler.view;

import com.kepler.model.Account;
import com.kepler.service.AccountService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;

@Route("")
@CssImport("./styles/shared-styles.css")
public class MainView  extends VerticalLayout {
    private final AccountService accountService;

    private final Grid<Account> grid = new Grid<>(Account.class);
    private final TextField fromField = new TextField("From ID");
    private final TextField toField = new TextField("To ID");
    private final TextField amountField = new TextField("Amount");
    private final Button transferButton = new Button("Transfer");

    private final TextField ownerField = new TextField("Owner");
    private final TextField balanceField = new TextField("Initial Balance");
    private final Button createButton = new Button("Create Account");

    public MainView(AccountService accountService) {
        this.accountService = accountService;

        add(new H1("ACID Demo — Bank"));

        setupGrid();
        setupTransferForm();
        setupCreateForm();

        refreshGrid();
    }

    private void setupGrid() {
        grid.setColumns("id", "owner", "balance");
        grid.setSizeFull();
        add(grid);
    }

    private void setupTransferForm() {
        HorizontalLayout layout = new HorizontalLayout(fromField, toField, amountField, transferButton);
        transferButton.addClickListener(e -> {
            try {
                accountService.transfer(
                        Long.parseLong(fromField.getValue()),
                        Long.parseLong(toField.getValue()),
                        new BigDecimal(amountField.getValue())
                );
                Notification.show("Transfer successful");
                refreshGrid();
            } catch (Exception ex) {
                Notification.show("Error: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });
        add(new H3("Transfer money"), layout);
    }

    private void setupCreateForm() {
        HorizontalLayout layout = new HorizontalLayout(ownerField, balanceField, createButton);
        createButton.addClickListener(e -> {
            accountService.create(ownerField.getValue(), new BigDecimal(balanceField.getValue()));
            Notification.show("Account created");
            refreshGrid();
        });
        add(new H3("Create new account"), layout);
    }

    private void refreshGrid() {
        grid.setItems(accountService.getAll());
    }

}
