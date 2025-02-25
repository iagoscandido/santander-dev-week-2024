package com.iagoscandido.sdw24.domain.ports;

import com.iagoscandido.sdw24.domain.model.Champion;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {

    List<Champion> findAll();

    Optional<Champion> findById(Long id);


}
