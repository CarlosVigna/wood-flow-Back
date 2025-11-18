@Service
public class ClientesService {

    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public Clientes buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Clientes> buscarTodos(){
        List<Clientes> clientes = repository.findAll();
        if (clientes.isEmpty()){
            throw new RuntimeException("Nenhum cliente encontrado");
        }
        return clientes;
    }

    public ClientesResponseDTO create(ClientesRequestDTO dto) {

        Clientes cliente = new Clientes();
        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEmail(dto.email());
        cliente.setEndereco(dto.endereco());
        cliente.setDocumento(dto.documento());
        cliente.setTipo(dto.tipo());

        Clientes salvo = repository.save(cliente);
        return new ClientesResponseDTO(salvo);
    }

    public ClientesResponseDTO update(Long id, ClientesRequestDTO dto){

        Clientes cliente = buscarPorId(id);

        if(dto.nome() != null && !dto.nome().equals(cliente.getNome()))
            cliente.setNome(dto.nome());

        if(dto.telefone() != null && !dto.telefone().equals(cliente.getTelefone()))
            cliente.setTelefone(dto.telefone());

        if(dto.email() != null && !dto.email().equals(cliente.getEmail()))
            cliente.setEmail(dto.email());

        if(dto.endereco() != null && !dto.endereco().equals(cliente.getEndereco()))
            cliente.setEndereco(dto.endereco());

        if(dto.documento() != null && !dto.documento().equals(cliente.getDocumento()))
            cliente.setDocumento(dto.documento());

        Clientes atualizado = repository.save(cliente);

        return new ClientesResponseDTO(atualizado);
    }

    public void delete(Long id){
        Clientes cliente = buscarPorId(id);
        repository.delete(cliente);
    }
}