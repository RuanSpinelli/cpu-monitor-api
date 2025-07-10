package com.ruan.cpu.dto;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProcessInfoDTO {
    private Long pid;
    private String name;
    private double cpuLoadPercent;
    private byte memoryBytes;

}
