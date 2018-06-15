package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

import java.util.List;

public class MethodicsResultDto {

    private String methodicsName;

    private List<ScaleValueDto> scales;

    public String getMethodicsName() {
        return methodicsName;
    }

    public void setMethodicsName(String methodicsName) {
        this.methodicsName = methodicsName;
    }

    public List<ScaleValueDto> getScales() {
        return scales;
    }

    public void setScales(List<ScaleValueDto> scales) {
        this.scales = scales;
    }
}
