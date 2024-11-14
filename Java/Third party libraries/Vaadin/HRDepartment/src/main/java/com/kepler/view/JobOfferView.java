package com.kepler.view;

import com.kepler.model.JobOffer;
import com.kepler.service.JobOfferService;
import com.kepler.service.NotificationService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Push
@Slf4j
@Route("")
@PageTitle("CRM")
public class JobOfferView extends VerticalLayout implements AppShellConfigurator {
    private final JobOfferService jobOfferService;
    private final NotificationService notificationService;
    private final Grid<JobOffer> grid = new Grid<>(JobOffer.class);
    private TextField fullNameField = new TextField("ФИО");
    private TextField jobTitleField = new TextField("Наименование вакансии");
    private TextField departmentField = new TextField("Подразделение");
    private TextField addressField = new TextField("Адрес");
    private TextField workingConditionsClassField = new TextField("Класс условий труда");
    private TextField workScheduleField = new TextField("График работы");
    private TextField irregularWorkingHoursField = new TextField("Ненормированный рабочий день");
    private TextField hireDateField = new TextField("Дата приема");
    private TextField salaryNetField = new TextField("Заработная плата на руки");
    private TextField salaryGrossField = new TextField("Заработная плата (оклад/премия) к начислению");
    private TextField housingCompensationField = new TextField("Компенсация жилья");
    private TextField recruitmentResponsibleField = new TextField("Ответственный за подбор");
    private TextField offerDateField = new TextField("Дата предложения");
    private TextField managerField = new TextField("Руководитель");
    private TextField recommendedByField = new TextField("Кем рекомендован");
    private TextField changedInSHRField = new TextField("Изменено в ШР");
    private Button saveButton = new Button("Добавить");
    private Button updateButton = new Button("Редактировать");
    private Button deleteButton = new Button("Удалить");
    private MenuBar menuBar = new MenuBar();

    @Autowired
    public JobOfferView(JobOfferService jobOfferService, NotificationService notificationService) {

        this.jobOfferService = jobOfferService;
        this.notificationService = notificationService;

        notificationService.registerListener(event -> {
            // Обновление UI через доступ к Vaadin Push
            UI.getCurrent().access(this::refreshGrid);
        });

        add(getMenu(), getTable(), getFields(), getButtons());
        setAlignItems(Alignment.CENTER);
    }


    private Grid<JobOffer> getTable() {
        grid.setColumns();

        grid.addColumn(JobOffer::getId).setHeader("№").setWidth("70px").setFlexGrow(0);

        grid.addColumn(JobOffer::getFullName).setHeader("ФИО").setFlexGrow(1).setAutoWidth(true).setSortable(true);

        grid.addColumn(JobOffer::getJobTitle).setHeader("Наименование вакансии").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getDepartment).setHeader("Подразделение").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getAddress).setHeader("Адрес").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getWorkingConditionsClass).setHeader("Класс условий труда").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getWorkSchedule).setHeader("График работы").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getIrregularWorkingHours).setHeader("Ненормированный рабочий день").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getHireDate).setHeader("Дата приема").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getSalaryNet).setHeader("Заработная плата на руки").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getSalaryGross).setHeader("Заработная плата (оклад/премия) к начислению").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getHousingCompensation).setHeader("Компенсация жилья").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getRecruitmentResponsible).setHeader("Ответственный за подбор").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getOfferDate).setHeader("Дата предложения").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getManager).setHeader("Руководитель").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getRecommendedBy).setHeader("Кем рекомендован").setWidth("500px").setFlexGrow(0);
        grid.addColumn(JobOffer::getChangedInSHR).setHeader("Изменено в ШР").setWidth("500px").setFlexGrow(0);

        grid.setHeight("800px");

        grid.setItems(jobOfferService.findAll());

        grid.asSingleSelect().addValueChangeListener(event -> {
            JobOffer jobOffer = event.getValue();
            if (jobOffer != null) {
                fullNameField.setValue(jobOffer.getFullName());
                jobTitleField.setValue(jobOffer.getJobTitle());
                departmentField.setValue(jobOffer.getDepartment());
                addressField.setValue(jobOffer.getAddress());
                workingConditionsClassField.setValue(jobOffer.getWorkingConditionsClass());
                workScheduleField.setValue(jobOffer.getWorkSchedule());
                irregularWorkingHoursField.setValue(jobOffer.getIrregularWorkingHours());
                hireDateField.setValue(jobOffer.getHireDate());
                salaryNetField.setValue(jobOffer.getSalaryNet());
                salaryGrossField.setValue(jobOffer.getSalaryGross());
                housingCompensationField.setValue(jobOffer.getHousingCompensation());
                recruitmentResponsibleField.setValue(jobOffer.getRecruitmentResponsible());
                offerDateField.setValue(jobOffer.getOfferDate());
                managerField.setValue(jobOffer.getManager());
                recommendedByField.setValue(jobOffer.getRecommendedBy());
                changedInSHRField.setValue(jobOffer.getChangedInSHR());

            } else {
                clearForm();
            }
        });

        return grid;
    }

    private FormLayout getFields() {
        FormLayout fields = new FormLayout();
        fields.add(fullNameField, jobTitleField, departmentField, addressField,
                workingConditionsClassField, workScheduleField, irregularWorkingHoursField,
                hireDateField, salaryNetField, salaryGrossField, housingCompensationField,
                recruitmentResponsibleField, offerDateField, managerField, recommendedByField, changedInSHRField);
        return fields;
    }

    private HorizontalLayout getMenu() {
        Text selected = new Text("");
        ComponentEventListener<ClickEvent<MenuItem>> listener = e -> selected
                .setText(e.getSource().getText());

        menuBar.addItem("Предложение о работе", listener);
        menuBar.addItem("Таблица №2", listener);
        menuBar.addItem("Таблица №3", listener);

        HorizontalLayout menu = new HorizontalLayout(menuBar);
        menu.setWidthFull();
        menu.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        return menu;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout(saveButton, updateButton, deleteButton);

        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.getStyle().set("background-color", "green");
        saveButton.getStyle().set("color", "white");

        updateButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        updateButton.getStyle().set("background-color", "yellow");
        updateButton.getStyle().set("color", "black");

        deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteButton.getStyle().set("background-color", "red");
        deleteButton.getStyle().set("color", "white");

        saveButton.addClickListener(e -> {
            saveDialog().open();
        });

        updateButton.addClickListener(e -> {
            JobOffer jobOffer = grid.asSingleSelect().getValue();
            if (jobOffer != null) {
                updateDialog().open();
            } else {
                Notification.show("Не выбрана запись для редактирования!");
            }
        });

        deleteButton.addClickListener(e -> {
            JobOffer jobOffer = grid.asSingleSelect().getValue();
            if (jobOffer != null) {
                deleteDialog().open();
            } else {
                Notification.show("Не выбрана запись для удаления!");
            }
        });

        return buttons;
    }

    private Dialog updateDialog() {
        Dialog dialog = new Dialog();

        Button confirmButton = new Button("Подтвердить", event -> {
            // Действие при подтверждении
            JobOffer jobOffer = grid.asSingleSelect().getValue();
            if (jobOffer != null) {
                jobOffer.setFullName(fullNameField.getValue());
                jobOffer.setJobTitle(jobTitleField.getValue());
                jobOffer.setDepartment(departmentField.getValue());
                jobOffer.setAddress(addressField.getValue());
                jobOffer.setWorkingConditionsClass(workingConditionsClassField.getValue());
                jobOffer.setWorkSchedule(workScheduleField.getValue());
                jobOffer.setIrregularWorkingHours(irregularWorkingHoursField.getValue());
                jobOffer.setHireDate(hireDateField.getValue());
                jobOffer.setSalaryNet(salaryNetField.getValue());
                jobOffer.setSalaryGross(salaryGrossField.getValue());
                jobOffer.setHousingCompensation(housingCompensationField.getValue());
                jobOffer.setRecruitmentResponsible(recruitmentResponsibleField.getValue());
                jobOffer.setOfferDate(offerDateField.getValue());
                jobOffer.setManager(managerField.getValue());
                jobOffer.setRecommendedBy(recommendedByField.getValue());
                jobOffer.setChangedInSHR(changedInSHRField.getValue());

                jobOfferService.save(jobOffer);

                refreshGrid();
                clearForm();
                Notification.show("Запись обновлена");
            } else {
                Notification.show("Не выбрана запись");
            }

            dialog.close();
        });

        confirmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        confirmButton.getStyle().set("background-color", "green");
        confirmButton.getStyle().set("color", "white");

        Button cancelButton = new Button("Отменить", event -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelButton.getStyle().set("background-color", "red");
        cancelButton.getStyle().set("color", "white");

        HorizontalLayout buttons = new HorizontalLayout(confirmButton, cancelButton);

        VerticalLayout layout = new VerticalLayout();
        layout.add(new H4("Вы уверены, что хотите изменить запись?"));
        layout.add(buttons);
        layout.setAlignItems(Alignment.CENTER);

        dialog.add(layout);

        return dialog;
    }

    private Dialog saveDialog() {
        Dialog dialog = new Dialog();

        Button confirmButton = new Button("Подтвердить", event -> {
            JobOffer jobOffer = new JobOffer();

            jobOffer.setFullName(fullNameField.getValue());
            jobOffer.setJobTitle(jobTitleField.getValue());
            jobOffer.setDepartment(departmentField.getValue());
            jobOffer.setAddress(addressField.getValue());
            jobOffer.setWorkingConditionsClass(workingConditionsClassField.getValue());
            jobOffer.setWorkSchedule(workScheduleField.getValue());
            jobOffer.setIrregularWorkingHours(irregularWorkingHoursField.getValue());
            jobOffer.setHireDate(hireDateField.getValue());
            jobOffer.setSalaryNet(salaryNetField.getValue());
            jobOffer.setSalaryGross(salaryGrossField.getValue());
            jobOffer.setHousingCompensation(housingCompensationField.getValue());
            jobOffer.setRecruitmentResponsible(recruitmentResponsibleField.getValue());
            jobOffer.setOfferDate(offerDateField.getValue());
            jobOffer.setManager(managerField.getValue());
            jobOffer.setRecommendedBy(recommendedByField.getValue());
            jobOffer.setChangedInSHR(changedInSHRField.getValue());

            jobOfferService.save(jobOffer);

            refreshGrid();
            clearForm();
            Notification.show("Запись добавлена");

            dialog.close();

        });
        confirmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        confirmButton.getStyle().set("background-color", "green");
        confirmButton.getStyle().set("color", "white");

        Button cancelButton = new Button("Отменить", event -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelButton.getStyle().set("background-color", "red");
        cancelButton.getStyle().set("color", "white");

        HorizontalLayout buttons = new HorizontalLayout(confirmButton, cancelButton);

        VerticalLayout layout = new VerticalLayout();
        layout.add(new H4("Вы уверены, что хотите добавить запись?"));
        layout.add(buttons);
        layout.setAlignItems(Alignment.CENTER);

        dialog.add(layout);

        return dialog;
    }


    private void refreshGrid() {
        List<JobOffer> jobOffers = jobOfferService.findAll();
        grid.setItems(jobOffers);
    }

    private void clearForm() {
        fullNameField.clear();
        jobTitleField.clear();
        departmentField.clear();
        addressField.clear();
        workingConditionsClassField.clear();
        workScheduleField.clear();
        irregularWorkingHoursField.clear();
        hireDateField.clear();
        salaryNetField.clear();
        salaryGrossField.clear();
        housingCompensationField.clear();
        recruitmentResponsibleField.clear();
        offerDateField.clear();
        managerField.clear();
        recommendedByField.clear();
        changedInSHRField.clear();

    }


    private Dialog deleteDialog() {
        Dialog dialog = new Dialog();

        Button confirmButton = new Button("Подтвердить", event -> {
            // Действие при подтверждении
            JobOffer jobOffer = grid.asSingleSelect().getValue();
            if (jobOffer != null) {
                jobOfferService.delete(jobOffer);
                refreshGrid();
                clearForm();
                Notification.show("Запись удалена");
            } else {
                Notification.show("Не выбрана запись");
            }

            dialog.close();
        });

        confirmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        confirmButton.getStyle().set("background-color", "green");
        confirmButton.getStyle().set("color", "white");

        Button cancelButton = new Button("Отменить", event -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelButton.getStyle().set("background-color", "red");
        cancelButton.getStyle().set("color", "white");

        HorizontalLayout buttons = new HorizontalLayout(confirmButton, cancelButton);

        VerticalLayout layout = new VerticalLayout();
        layout.add(new H4("Вы уверены, что хотите удалить запись?"));
        layout.add(buttons);
        layout.setAlignItems(Alignment.CENTER);

        dialog.add(layout);

        return dialog;
    }
}
