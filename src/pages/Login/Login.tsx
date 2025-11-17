import React, { useState } from "react";
import Input from "../../components/Input";
import Button from "../../components/Button";
import styles from "./Login.module.css";

interface LoginProps {
  onLoginSuccess: () => void;
}

export default function Login({ onLoginSuccess }: LoginProps) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // previne o reload da página
    setLoading(true);
    setError("");

    // login fixo para teste
    setTimeout(() => {
      if (email === "carlos@carlos" && password === "1234") {
        onLoginSuccess(); // chama callback do App para ir para Dashboard
      } else {
        setError("Usuário ou senha incorretos!");
      }
      setLoading(false);
    }, 500); // simula delay de rede
  };

  return (
    <div className={styles.container}>
      <div className={styles.left}>
        <form className={styles.form} onSubmit={handleSubmit}>
          <h1>Login</h1>
          <Input label="Email" value={email} onChange={setEmail} type="email" />
          <Input label="Senha" value={password} onChange={setPassword} type="password" />
          <Button type="submit" disabled={loading}>
            {loading ? "Entrando..." : "Entrar"}
          </Button>
          {error && <p className={styles.error}>{error}</p>}
        </form>
      </div>
      <div className={styles.right}>
        <h2>Bem-vindo!</h2>
        <p>Design moderno, responsivo e bonito.</p>
      </div>
    </div>
  );
}