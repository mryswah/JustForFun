package com.memesapp.web.mapper;

import com.memesapp.web.dto.LabelsDto;
import com.memesapp.web.model.Labels;

public class LabelsMapper {
    public static Labels mapToLabels(LabelsDto labelsDto){
        Labels labels = Labels.builder()
                .id(labelsDto.getId())
                .labelName(labelsDto.getLabelName())
                .createdOn(labelsDto.getCreatedOn())
                .updatedOn(labelsDto.getUpdatedOn())
                .build();

        return labels;
    }

    public static LabelsDto mapToLabelsDto(Labels labels){
        LabelsDto labelsDto = LabelsDto.builder()
                .id(labels.getId())
                .labelName(labels.getLabelName())
                .createdOn(labels.getCreatedOn())
                .updatedOn(labels.getUpdatedOn())
                .build();

        return labelsDto;
    }
}
