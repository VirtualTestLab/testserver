package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.MethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.ScaleValueDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

import java.util.ArrayList;
import java.util.List;

public class MethodicsResultConverter extends DozerConverter<MethodicsResultDto, PassingFact> implements MapperAware {

    private Mapper mapper;

    private MethodicsService methodicsService;

    public MethodicsResultConverter(MethodicsService methodicsService) {
        super(MethodicsResultDto.class, PassingFact.class);
        this.methodicsService = methodicsService;
    }

    @Override
    public PassingFact convertTo(MethodicsResultDto methodicsResultDto, PassingFact passingFact) {
        return null;
    }

    @Override
    public MethodicsResultDto convertFrom(PassingFact passingFact, MethodicsResultDto methodicsResultDto) {
        methodicsResultDto = new MethodicsResultDto();
        List<ScaleValueDto> scaleDtoValues = new ArrayList<>();
        List<ScaleValue> scaleValues = passingFact.getScaleValues();
        scaleValues.forEach(scaleValue -> scaleDtoValues.add(mapper.map(scaleValue, ScaleValueDto.class)));
        Methodics methodics = methodicsService.findById(passingFact.getMethodicsId());
        methodicsResultDto.setMethodicsName(methodics.getName());
        methodicsResultDto.setScales(scaleDtoValues);
        return methodicsResultDto;
    }

    @Override
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}
