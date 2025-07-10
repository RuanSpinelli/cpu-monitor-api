package com.ruan.cpu.dto;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProcessInfoDTO {
    private long pid;
    private String name;
    private double cpuLoadPercent;
    private Long memoryBytes;

}
