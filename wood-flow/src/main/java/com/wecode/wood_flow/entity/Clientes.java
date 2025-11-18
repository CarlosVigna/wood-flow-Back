@Entity
@Table(name = "clientes")
@Getter @Setter
public class Clientes extends Pessoa {

    @Column(nullable = false)
    private String tipo; // "FISICA" ou "JURIDICA"

    @Column(nullable = false, unique = true)
    private String documento;
 
}