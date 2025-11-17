import React, { useState } from "react";
import "./Clientes.css";

interface Cliente {
  nome: string;
  cpfCnpj: string;
  telefone: string;
  email: string;
  endereco: string;
}

const Clientes: React.FC = () => {
  const [cliente, setCliente] = useState<Cliente>({
    nome: "",
    cpfCnpj: "",
    telefone: "",
    email: "",
    endereco: "",
  });

  const [clientesCadastrados, setClientesCadastrados] = useState<Cliente[]>([]);
  const [busca, setBusca] = useState("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    setCliente({ ...cliente, [e.target.name]: e.target.value });
  };

  const handleSalvar = () => {
    if (!cliente.nome || !cliente.cpfCnpj) {
      alert("Nome e CPF/CNPJ são obrigatórios!");
      return;
    }
    setClientesCadastrados([...clientesCadastrados, cliente]);
    alert("Cliente salvo com sucesso!");
    setCliente({ nome: "", cpfCnpj: "", telefone: "", email: "", endereco: "" });
  };

  const handleExcluir = (cpfCnpj: string) => {
    const filtrados = clientesCadastrados.filter(c => c.cpfCnpj !== cpfCnpj);
    setClientesCadastrados(filtrados);
  };

  const handleBuscar = () => {
    const filtrados = clientesCadastrados.filter(c =>
      c.nome.toLowerCase().includes(busca.toLowerCase()) ||
      c.cpfCnpj.includes(busca)
    );
    setClientesCadastrados(filtrados);
  };

  return (
    <div className="clientes-container">
      <h2>Cadastro de Clientes</h2>

      <div className="clientes-form">
        <div className="form-row">
          <label>Nome:</label>
          <input name="nome" value={cliente.nome} onChange={handleChange} />
        </div>

        <div className="form-row">
          <label>CPF/CNPJ:</label>
          <input name="cpfCnpj" value={cliente.cpfCnpj} onChange={handleChange} />
        </div>

        <div className="form-row">
          <label>Telefone:</label>
          <input name="telefone" value={cliente.telefone} onChange={handleChange} />
        </div>

        <div className="form-row">
          <label>Email:</label>
          <input name="email" value={cliente.email} onChange={handleChange} />
        </div>

        <div className="form-row">
          <label>Endereço:</label>
          <textarea name="endereco" value={cliente.endereco} onChange={handleChange} />
        </div>

        <div className="form-buttons">
          <button type="button" onClick={handleSalvar}>Salvar</button>
          <button type="button" onClick={() => setCliente({ nome: "", cpfCnpj: "", telefone: "", email: "", endereco: "" })}>Limpar</button>
        </div>
      </div>

      <div className="clientes-busca">
        <input
          placeholder="Buscar por nome ou CPF/CNPJ"
          value={busca}
          onChange={(e) => setBusca(e.target.value)}
        />
        <button onClick={handleBuscar}>Buscar</button>
      </div>

      <div className="clientes-lista">
        <h3>Clientes cadastrados</h3>
        {clientesCadastrados.length === 0 ? (
          <p>Nenhum cliente cadastrado.</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Nome</th>
                <th>CPF/CNPJ</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              {clientesCadastrados.map((c, idx) => (
                <tr key={idx}>
                  <td>{c.nome}</td>
                  <td>{c.cpfCnpj}</td>
                  <td>{c.telefone}</td>
                  <td>{c.email}</td>
                  <td>{c.endereco}</td>
                  <td>
                    <button onClick={() => setCliente(c)}>Editar</button>
                    <button onClick={() => handleExcluir(c.cpfCnpj)}>Excluir</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default Clientes;