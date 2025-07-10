package com.ruan.cpu.controller;

import com.ruan.cpu.dto.ProcessInfoDTO;
import com.ruan.cpu.service.MonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("/cpu-usage")
    public double getCpuUsage() {
        return monitorService.getCpuUsage();
    }

    @GetMapping("/top-processes")
    public List<ProcessInfoDTO> getTopProcesses(@RequestParam(defaultValue = "5") int topN) {
        return monitorService.getTopProcesses(topN);
    }
}
