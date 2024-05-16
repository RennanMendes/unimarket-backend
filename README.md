
<div align="center">    
    <h1>Unimarket</h1>

![GitHub License](https://img.shields.io/github/license/RennanMendes/unimarket-backend)
![Static Badge](https://img.shields.io/badge/tested_with-JUnit-red)
![Static Badge](https://img.shields.io/badge/status-in_progress-brightgreen)
</div>

##  Sobre

O objetivo deste projeto é criar um mini e-commerce que permita aos usuários navegar e realizar compras de produtos. Os principais recursos incluem a página de vendas acessível sem a necessidade de login, a funcionalidade de adicionar e remover itens do carrinho de compras após o login, a verificação de disponibilidade de produtos em estoque e a validação de pagamento por meio de integração com uma API de pagamentos. Além disso, apenas usuários com permissão de administrador terão autorização para gerenciar categorias e produtos.

### Regras de negócio

 - Navegar pelos produtos disponíveis sem de fazer login;
- Necessário fazer login para movimentar o carrinho de compras;
- O carrinho exibe uma lista de itens selecionados permitindo ajustar a sua quantidade;
- A compra só será finalizada caso haja itens suficiente em estoque;
- A validação de pagamento por meio de API de pagamentos;
- Apenas admin podem adicionar, editar e remover produtos e categorias;

## Tecnologias utilizadas

| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-plain.svg" alt="Java Icon" width="40" height="40" /> | <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="Spring Icon" width="48" height="48" /> | <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="`MySQL` Icon" width="40" height="40" /> | <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" alt="Intellij Icon" width="40" height="40" /> |
| :--: | :--: | :--: | :--: |
| Java | Spring | MySQL | IntelliJ |

## Instalação

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [MySQL](https://www.mysql.com/downloads/)

Siga estas etapas para instalar e executar o projeto:
1. Clone o repositório: `git clone git@github.com:RennanMendes/unimarket-backend.git`

2. Compile o projeto usando o Maven: `mvn clean install`

3. Execute o projeto: `java -jar target/unimarket.jar`

O aplicativo Spring será executado na porta padrão 8080. Você pode acessá-lo em http://localhost:8080.


## Arquitetura Limpa

A escolha da arquitetura limpa para a realização deste projeto se baseia em diversas considerações que visam garantir um desenvolvimento eficiente e de alta qualidade. Abaixo, está alguns dos motivos que fundamentam a escolha:

 - **Separação Clara de Responsabilidades:** A arquitetura limpa estabelece uma divisão nítida entre as diferentes camadas do sistema, incluindo apresentação, regra de negócio e acesso a dados. Essa separação clara facilita significativamente os processos de teste, pois cada camada tem suas responsabilidades bem definidas.

 - **Escalabilidade:** Uma das características distintivas da arquitetura limpa é sua capacidade de ser facilmente escalada. Isso significa que o sistema pode crescer e evoluir ao longo do tempo sem comprometer a integridade ou a performance.

 - **Baixo Acoplamento:** A arquitetura limpa promove um baixo acoplamento com frameworks e bibliotecas externas. Isso não apenas simplifica a manutenção do código, mas também facilita a substituição desses elementos quando necessário, sem causar impactos significativos no restante do sistema. 
 
  - **Flexibilidade:** A arquitetura limpa permite uma grande flexibilidade na implementação de novas funcionalidades e na modificação de existentes. Isso é possível graças à separação clara de responsabilidades e ao baixo acoplamento mencionados anteriormente. 

## Banco de Dados MySQL

A escolha do banco de dados relacional para este projeto é devido a sua modelagem organizada, coesão, integridade e segurança dos dados.

<!-- ###  Diagrama de Entidade-Relacionamento (DER)
![DER database](./src/main/resources/static/) -->

### Alguns dos princípios utilizados no desenvolvimento do projeto:
`S.O.L.I.D`

`K.I.S.S`

`DRY`

`Tell don’t ask`

`Fail fast`