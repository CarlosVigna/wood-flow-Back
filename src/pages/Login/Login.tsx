import React, { useState } from "react";
import Input from "../../components/Input";
import Button from "../../components/Button";
import { login } from "../../services/auth";
import styles from "./Login.module.css";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); // previne o reload da página
    setLoading(true);
    setError("");

    try {
      const response = await login(email, password);
      console.log("Login bem-sucedido:", response);
      alert("Login feito com sucesso! Token: " + response.token);
    } catch (err: any) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
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