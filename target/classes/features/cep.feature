# encoding: iso-8859-1
Feature: Consultar CEP

  Scenario Outline: Consulta CEP valido
    Given o usuario insere um "<cep_valido>"
    When o servico eh consultado
    Then eh retornado o "<cep>", "<logradouro>", "<complemento>", "<bairro>", "<localidade>", "<uf>", "<ibge>"

    Examples:
      | cep_valido | cep       | logradouro                             | complemento     | bairro            | localidade   | uf | ibge    |
      |   05593970 | 05593-970 | Avenida Comendador Alberto Bonfiglioli |   737          | Jardim Bonfiglioli | S[0xc3][0xa3]o Paulo"   | SP | 3550308 |

  Scenario Outline: Consulta CEP inexistente
    Given o usuario insere um "<cep_inexistente>"
    When o servico eh consultado
    Then eh retornada um atributo "<erro>"

    Examples:
      | cep_inexistente | erro |
      |        91060901 | true |

  Scenario Outline: Consulta CEP com formato invalido
    Given o usuario insere um "<cep_invalido>"
    When o servico eh consultado
    Then eh retornada uma "<mensagem_de_erro>"

    Examples:
      | cep_invalido | mensagem_de_erro                  |
      |    123456789 | Verifique a sua URL (Bad Request) |

  Scenario Outline: Consulta dados informando UF, localidade, parte do logradouro
    Given o usuário insere "<uf>", "<localidade>", "<logradouro>"
    When o servico eh consultado
    Then eh retornada uma lista de locais que correspondem a pesquisa

    Examples:
      | uf | localidade | logradouro |
      | RS | Gravatai   | Barroso    |