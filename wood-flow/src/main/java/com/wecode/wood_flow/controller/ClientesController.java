package com.wecode.wood_flow.controller;


import com.wecode.wood_flow.dto.ClientesResponseDTO;
import com.wecode.wood_flow.entity.Clientes;
import com.wecode.wood_flow.repositories.ClientesRepository;
import com.wecode.wood_flow.request.ClientesRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository repository;

    @GetMapping
    public List<ClientesResponseDTO> getall(){

        List<ClientesResponseDTO> clientesList = repository.findAll().stream().map(ClientesResponseDTO::new).toList();
        return clientesList;
    }

    @PostMapping
    public void saveClientes(@RequestBody ClientesRequestDTO data){
        Clientes clientesData = new Clientes(data);
        repository.save(clientesData);
        return;

    }
}
