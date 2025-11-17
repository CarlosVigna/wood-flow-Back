export async function login(email: string, password: string) {
  // Simulando API, geralmente aqui você chamaria axios/fetch
  return new Promise<{ token: string }>((resolve, reject) => {
    setTimeout(() => {
      if (email === "teste@teste.com" && password === "123456") {
        resolve({ token: "fake-jwt-token" });
      } else {
        reject(new Error("Email ou senha incorretos"));
      }
    }, 1000);
  });
}