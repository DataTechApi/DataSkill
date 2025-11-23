package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.response.CertificadoDTOResponse;
import com.datatech.dataskill.entities.dtos.response.DashboardDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name="DashboardClient", url = "${spring.feign.url}")
public interface DashboardClient {
    @RequestMapping(method = RequestMethod.GET, value="/dashboard")
    List<DashboardDTOResponse> buscarDashboard();
}
