package com.clara.mbuser.dto;

import com.clara.mbuser.entity.User;
import org.springframework.context.annotation.Lazy;

public class Converter {

    public static User fromDto(CadUser dto) {
        return new User(dto.getNome(), dto.getCpf(), dto.getEndereco(), dto.getTelefone(), dto.getEmail());
    }
}
