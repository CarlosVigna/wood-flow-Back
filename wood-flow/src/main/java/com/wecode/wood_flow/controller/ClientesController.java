@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientesResponseDTO> create(@Valid @RequestBody ClientesRequestDTO dto) {
        ClientesResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesResponseDTO> getById(@PathVariable Long id){
        Clientes cliente = service.buscarPorId(id);
        ClientesResponseDTO response = new ClientesResponseDTO(cliente);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
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
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
