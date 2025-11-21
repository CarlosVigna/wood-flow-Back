package com.wecode.wood_flow.controller;

import com.wecode.wood_flow.dto.request.ClientesRequestDTO;
import com.wecode.wood_flow.dto.response.ClientesResponseDTO;
import com.wecode.wood_flow.entity.Clientes;
import com.wecode.wood_flow.service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientesResponseDTO> create(@RequestBody ClientesRequestDTO dto) {
        ClientesResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesResponseDTO> getById(@PathVariable Long id) {
        Clientes cliente = service.buscarPorId(id);
        return ResponseEntity.ok(new ClientesResponseDTO(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> getAll() {
        List<Clientes> clientes = service.buscarTodos();
        List<ClientesResponseDTO> response = clientes.stream()
                .map(ClientesResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesResponseDTO> updateById(
            @PathVariable Long id,
            @RequestBody ClientesRequestDTO dto) {
        ClientesResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}