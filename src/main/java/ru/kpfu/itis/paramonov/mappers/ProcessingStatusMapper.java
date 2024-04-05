package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.ProcessingStatusDto;
import ru.kpfu.itis.paramonov.model.ProcessingStatus;

public class ProcessingStatusMapper implements Mapper<ProcessingStatus, ProcessingStatusDto> {
    @Override
    public ProcessingStatusDto map(ProcessingStatus model) {
        return new ProcessingStatusDto(
                model.getId(),
                model.getValue()
        );
    }
}
