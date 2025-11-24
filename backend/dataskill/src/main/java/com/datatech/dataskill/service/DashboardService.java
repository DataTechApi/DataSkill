package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.dto.response.DashboardDTOResponse;
import com.datatech.dataskill.repository.DashboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }
    public List<DashboardDTOResponse> listarHardkill(){
        return dashboardRepository.listarHardskill();
    }
}
