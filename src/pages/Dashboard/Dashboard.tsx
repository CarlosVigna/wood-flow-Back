import React, { useState } from "react";
import "./Dashboard.css";
import Clientes from "./Clientes";

const Dashboard: React.FC = () => {
  const [currentPage, setCurrentPage] = useState<string | null>(null);
  const [showCadastrosMenu, setShowCadastrosMenu] = useState(false);

  const handleMenuClick = (page: string) => {
    if (page === "cadastros") {
      setShowCadastrosMenu(!showCadastrosMenu); // alterna menu cascata
    } else {
      setCurrentPage(page);
      setShowCadastrosMenu(false); // fecha o menu cascata
    }
  };

  const handleDropdownClick = (page: string) => {
    setCurrentPage(page);
    setShowCadastrosMenu(false);
  };

  const renderPage = () => {
    switch (currentPage) {
      case "clientes":
        return <Clientes />;
      case "pedidos":
        return <div><h2>Pedidos</h2><p>Lista de pedidos.</p></div>;
      case "op":
        return <div><h2>Ordens de Produção</h2><p>Gerenciamento de OPs.</p></div>;
      case "etapas":
        return <div><h2>Etapas</h2><p>Definição de etapas do processo.</p></div>;
      case "produtos":
        return <div><h2>Produtos</h2><p>Lista de produtos cadastrados.</p></div>;
      case "fornecedores":
        return <div><h2>Fornecedores</h2><p>Cadastro de fornecedores.</p></div>;
      case "oc":
        return <div><h2>Ordens de Compra</h2><p>Gestão de ordens de compra.</p></div>;
      case "movimentacao":
        return <div><h2>Movimentação de Estoque</h2><p>Controle de movimentações.</p></div>;
      case "inventario":
        return <div><h2>Inventário</h2><p>Controle de inventário.</p></div>;
      case "almoxarifado":
        return <div><h2>Almoxarifado</h2><p>Gerenciamento do almoxarifado.</p></div>;
      default:
        return (
          <div style={{ textAlign: "center" }}>
            <h2>Bem-vindo ao ERP</h2>
            <img src="https://via.placeholder.com/400" alt="logo" />
          </div>
        );
    }
  };

  return (
    <div className="dashboard">
      {/* Navbar superior */}
      <div className="navbar">
        <div onClick={() => handleMenuClick("cadastros")} className="menu-item">
          Cadastros ▼
          {showCadastrosMenu && (
            <div className="dropdown">
              <div onClick={() => handleDropdownClick("clientes")}>Clientes</div>
              <div onClick={() => handleDropdownClick("pedidos")}>Pedidos</div>
              <div onClick={() => handleDropdownClick("op")}>Ordens de Produção</div>
              <div onClick={() => handleDropdownClick("etapas")}>Etapas</div>
              <div onClick={() => handleDropdownClick("produtos")}>Produtos</div>
              <div onClick={() => handleDropdownClick("fornecedores")}>Fornecedores</div>
              <div onClick={() => handleDropdownClick("oc")}>Ordens de Compra</div>
              <div onClick={() => handleDropdownClick("movimentacao")}>Movimentação de Estoque</div>
              <div onClick={() => handleDropdownClick("inventario")}>Inventário</div>
              <div onClick={() => handleDropdownClick("almoxarifado")}>Almoxarifado</div>
            </div>
          )}
        </div>
        <div onClick={() => handleMenuClick("produtos")} className="menu-item">Produtos</div>
        <div onClick={() => handleMenuClick("ordens")} className="menu-item">Ordens</div>
        <div onClick={() => handleMenuClick("relatorios")} className="menu-item">Relatórios</div>
      </div>

      {/* Área central */}
      <div className="main-content">
        {renderPage()}
      </div>
    </div>
  );
};

export default Dashboard;
