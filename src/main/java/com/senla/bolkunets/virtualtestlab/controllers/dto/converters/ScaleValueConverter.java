package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.ScaleValueDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;
import org.dozer.DozerConverter;

public class ScaleValueConverter extends DozerConverter<ScaleValue, ScaleValueDto> {

    public ScaleValueConverter() {
        super(ScaleValue.class, ScaleValueDto.class);
    }

    @Override
    public ScaleValueDto convertTo(ScaleValue scaleValue, ScaleValueDto scaleValueDto) {
        scaleValueDto = new ScaleValueDto();
        String nameScale = scaleValue.getMethodicsKey().getNameScale();
        Integer value = scaleValue.getValue();
        scaleValueDto.setScaleName(nameScale);
        scaleValueDto.setScaleValue(value);
        return scaleValueDto;
    }

    @Override
    public ScaleValue convertFrom(ScaleValueDto scaleValueDto, ScaleValue scaleValue) {
        return null;
    }
}
