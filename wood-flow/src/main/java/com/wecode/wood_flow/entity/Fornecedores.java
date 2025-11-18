@Entity
@Table(name = "fornecedores")
@Getter 
@Setter

public class Fornecedor extends Pessoa {
    private String cnpj;
}