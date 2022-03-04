# Estudo Microsserviços: Mini banco

> Conjunto de microsserviços Java, gerenciados pelas ferramentas do Spring Cloud. 

## Linguagens e tecnologias utilizadas

- Spring Boot
- Spring Cloud
- Eureka 
- Banco H2


## Microsserviços
- Mb-conta: Criação de uma conta vinculada ao CPF do usuário (se o usuário não estiver cadastrado, não abre conta)
- Mb-Usuário: Cadastro de pessoas no sistema do banco
- Mb-Histórico: Histórico de transações (saques, depósitos) registrados por CPF de usuário
- Mb-Eureka-Server: Mapeamento dos microservices em um servidor Eureka para melhor acompanhamento de suas funcionalidades
- Mb-Gateway: Junção dos demais microservices em uma só porta do localhost






