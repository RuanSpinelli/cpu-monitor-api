# ☕ CPU Monitor API

Uma API REST simples feita em **Java + Spring Boot**, que fornece dados em tempo real sobre o uso da CPU da máquina local. Ideal para testes, integração com frontends e experimentos com monitoramento de sistemas.

---

## 📦 Tecnologias

- Java 17+
- Spring Boot
- [OSHI](https://github.com/oshi/oshi) (para coleta de informações do sistema)
- Maven

---

## ⚙️ Funcionalidades

- ✅ Endpoint para obter o uso atual da CPU
- ✅ Pode ser consumida por qualquer frontend ou ferramenta (React, JS puro, Postman, etc)

---

## 🚀 Como rodar localmente

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/RuanSpinelli/cpu-monitor-api.git
   cd cpu-monitor-api
```

2. **Instale as dependências e rode**
   Certifique-se de ter o Maven instalado:

   ```bash
   ./mvnw spring-boot:run
   ```
---
### 📌 **Endpoints da API**

#### 🔹 `GET /cpu-usage`

Retorna o uso atual da CPU em tempo real.

📥 **Exemplo de resposta:**

```json
{
  "cpuLoadPercent": 7.05917415164533
}
```

📌 **Observação:** os dados são atualizados a cada requisição. Ou seja, **sempre que o endpoint for acessado, uma nova leitura da CPU é feita.**

---

#### 🔹 `GET /top-processes?topN=5`

Retorna uma lista com os **N processos mais consumidores de CPU no momento**, ordenados do maior para o menor uso.

🔧 **Parâmetro opcional:**

* `topN` (inteiro): Define quantos processos retornar.
  Padrão: `5`.

📥 **Exemplo de requisição:**

```
GET /top-processes?topN=3
```

📤 **Exemplo de resposta:**

```json
[
  {
    "name": "java",
    "pid": 4521,
    "cpuUsage": 18.3
  },
  {
    "name": "chrome",
    "pid": 1198,
    "cpuUsage": 12.1
  },
  {
    "name": "discord",
    "pid": 3020,
    "cpuUsage": 7.6
  }
]
```

📌 **Observação:** Os processos são lidos no momento da requisição, garantindo **dados atualizados sob demanda.**

---

## 📡 Integração com frontend

Este backend foi pensado para funcionar junto com o projeto React:

👉 [cpu-monitor-react](https://github.com/RuanSpinelli/cpu-monitor-react)

No frontend, o React consome este endpoint a cada 2 segundos e atualiza a interface com o uso atual da CPU em tempo real.

---

## 🧪 Teste com curl (opcional)

Se quiser testar sem frontend:

```bash
curl http://localhost:8080/cpu-usage
```
---
## 🤝 Colaboradores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/RuanSpinelli">
        <img src="https://avatars.githubusercontent.com/RuanSpinelli" width="100px;" alt="Foto do Ruan Spinelli"/><br>
        <sub>
          <b>Ruan Spinelli</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

---

## 📄 Licença

Este projeto está sob a licença MIT.
Feito com 💻 e ☕ por [@RuanSpinelli](https://github.com/RuanSpinelli)



