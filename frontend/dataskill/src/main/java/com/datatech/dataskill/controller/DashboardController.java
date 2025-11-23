package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.DashboardClient;
import com.datatech.dataskill.entities.dtos.response.DashboardDTOResponse;
import com.datatech.dataskill.entities.enums.Cargo;
import com.datatech.dataskill.entities.enums.Departamento;
import com.datatech.dataskill.entities.enums.Hard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {
    private final DashboardClient dashboardClient;

    public DashboardController(DashboardClient dashboardClient) {
        this.dashboardClient = dashboardClient;
    }

    @GetMapping("/diretor/dashboard")
    public ModelAndView dashboard() {
        List<DashboardDTOResponse> dashboard = dashboardClient.buscarDashboard();
        ModelAndView mv = new ModelAndView("diretor/dashboard");
        mv.addObject("labels", dashboard.stream().map(DashboardDTOResponse::getName).toList());
        mv.addObject("values", dashboard.stream().map(DashboardDTOResponse::getValue).toList());


        return mv;
    }


}
