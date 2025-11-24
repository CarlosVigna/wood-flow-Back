package com.wecode.wood_flow.dto.request;

import java.util.List;

public record EtapaRequestDTO(
        Long idEtapa,
        Integer ordem,
        List<EtapaMaterialRequestDTO> materiais
) {}