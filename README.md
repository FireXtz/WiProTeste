# Teste WiPro Integração com Api Via Cep + Testes com Junit e Cucumber

- o desafio pedido foi a construção de uma api rest de consulta de endereço e cálculo de frete para um determinado cep.

- o contrato da api foi usado conforme especificado no teste.

## Exemplo do contrato da API:

- POST v1/consulta-endereco
- REQUEST
- {"cep": "01001000"}
* Response
* {"cep": "01001-000","rua": "Praça da Sé","complemento": "lado ímpar","bairro": "Sé","cidade": "São Paulo","estado": "SP","frete": 7.85 }

- Requisitos para o desenvolvimento
- Java 11
- Spring Boot
- Documentação Swagger
- Testes Unitários Junit5
- Testes Automatizados utilizando cucumber
- API REST Template

# Requisitos usados no teste:
* todos os requisitos de desenvolvimento foram utilizados
- Java 11
- Spring Boot
- Documentação Swagger
- Testes Unitários Junit5
- Testes Automatizados utilizando cucumber
- API REST Template
- Postman

# Construção da API Imagens:

- Endpoint testado no Postman, usando o RestTemplate e documentado no Swagger apartir desse link Version 1.0.
- http://localhost:8080/swagger-ui/index.html#/cep-rest-template-controller/pesquisarUsingPOST
- Endpoint testado no Postman, usando o Feign e documentado no Swagger apartir desse link Version 2.0.
- http://localhost:8080/swagger-ui/index.html#/cep-rest-template-controller/pesquisarUsingPOST

- POST v1/consulta-endereco usando RestTemplate
- ![alt text](https://github.com/FireXtz/WiProTeste/blob/main/src/main/resources/images/EnderecoSP.png)

- ![alt text](https://github.com/FireXtz/WiProTeste/blob/main/src/main/resources/images/EnderecoRS.png)

- Documentação Swagger

- ![alt text](https://github.com/FireXtz/WiProTeste/blob/main/src/main/resources/images/SwaggerApi.png)
- ![alt text](https://github.com/FireXtz/WiProTeste/blob/main/src/main/resources/images/SwaggerDocumentacao.png)


