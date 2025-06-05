package com.kepler.view;

import com.kepler.service.MetricsService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Main View")
public class MainView extends VerticalLayout {

    private final MetricsService metricsService;

    public MainView(MetricsService metricsService) {
        this.metricsService = metricsService;

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();

        add(new H1("Prometheus - grafana - test"));
        add(new H1("Counter: " + metricsService.getCounter().count()));
    }
}