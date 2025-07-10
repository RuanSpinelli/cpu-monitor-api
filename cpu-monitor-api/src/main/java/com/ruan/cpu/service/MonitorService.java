package com.ruan.cpu.service;

import com.ruan.cpu.dto.ProcessInfoDTO;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class MonitorService {

    private final SystemInfo si = new SystemInfo();
    private final CentralProcessor processor = si.getHardware().getProcessor();
    private final OperatingSystem os = si.getOperatingSystem();
    private long[] prevTicks = processor.getSystemCpuLoadTicks();



    public double getCpuUsage() {
        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks);
        prevTicks = ticks;  // atualiza para o próximo cálculo
        return cpuLoad * 100;
    }

    public List<ProcessInfoDTO> getTopProcesses(int topN) {
        List<OSProcess> procs = os.getProcesses();
        return procs.stream()
                .sorted(Comparator.comparingDouble(OSProcess::getProcessCpuLoadCumulative).reversed())
                .limit(topN)
                .map(p -> {
                    ProcessInfoDTO dto = new ProcessInfoDTO();
                    dto.setPid(p.getProcessID());
                    dto.setName(p.getName());
                    dto.setCpuLoadPercent(100d * p.getProcessCpuLoadCumulative());
                    dto.setMemoryBytes(p.getResidentSetSize());
                    return dto;
                })
                .collect(Collectors.toList());
    }



}
