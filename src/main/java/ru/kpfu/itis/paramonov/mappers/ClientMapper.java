package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.ClientDto;
import ru.kpfu.itis.paramonov.model.Client;

public class ClientMapper implements Mapper<Client, ClientDto> {

    @Override
    public ClientDto map(Client model) {
        return new ClientDto(
                model.getId(),
                model.getName(),
                model.getCardLastDigits()
        );
    }
}
