# language: pt
Funcionalidade: Cálculo de preços e prazos de entrega
  Como um Cliente desejo calcular o preco da e o prazo da entrega
  De modo que eu insira os dados e consiga visualizar o valor e o prazo da entrega
  
  - Campo Data da postagem
  - CEP de Origem
  - CEP de Destino
  - ComboBox Tipo de Servico com as opcoes:
  	- Aerograma
  	- Carta Registrada
  	- Carta Simples
  	- Carta Via Internet
  	- Cartão Postal
  	- e-SEDEX
  	- Impresso Normal
  	- Mala Direta Domiciliária
  	- Mala Direta Não Urgente
  	- Mala Direta/Impresso Urgente
  	- Correios entrega Direta Operação B
  	- Malote

  ###################################################################################################################################
  Contexto: 
    Dado que eu esteja na home dos correios

  ###################################################################################################################################
  @CN01
  Esquema do Cenario: "<Cenario>" [Precos e Prazos] "<Descricao>"
    E que estou na tela inicial da tela de Precos e prazos
    E que eu insira a Data de Postagem
    E que eu insira o CEP de origem "<CepOrigem>"
    E que eu insira o CEP de destino "<CepDestino>"
    E selecione o Tipo de Servico "<TipoServico>"
    Quando clicar em Enviar
    Entao devo visualizar os dados Prazo de entrega "<Prazo>", entrega "<Entrega>", Dias de Entrega "<DiasEntrega>"
    E clicar em dados do Objeto Simulado
    E o endereco Simulado de Origem: CEP "<CepOrigem>", endereco "<EndOrigem>", Bairro "<BairroOrigem>", Cidade / UF "<CidadeUfOrigem>"
    E o endereco Simulado de Destino: CEP "<CepDestino>", endereco "<EndDestino>", Bairro "<BairroDestino>", Cidade / UF "<CidadeUfDestino>"

    Exemplos: 
      | Cenario | Descricao                                               | CepOrigem | CepDestino | TipoServico        | Prazo | Entrega            | DiasEntrega            | EndOrigem                                      | BairroOrigem | CidadeUfOrigem | EndDestino                                       | BairroDestino  | CidadeUfDestino |
      | CT01    | Validar opcao de envio Aerograma CEP dados validos      |  01311200 |   11025000 | Aerograma          |     3 | Entrega domiciliar | Segunda a Sexta-Feira. | Avenida Paulista - de 1047 a 1865 - lado ímpar | Bela Vista   | São Paulo / SP | Avenida Doutor Pedro Lessa - até 1594 - lado par | Ponta da Praia | Santos / SP     |
      | CT02    | Validar opcao de envio Carta Simples dados validos      |  01311200 |   11025000 | Carta Simples      |     3 | Entrega domiciliar | Segunda a Sexta-Feira. | Avenida Paulista - de 1047 a 1865 - lado ímpar | Bela Vista   | São Paulo / SP | Avenida Doutor Pedro Lessa - até 1594 - lado par | Ponta da Praia | Santos / SP     |
      #| CT03    | Validar opcao de envio Carta Via Internet dados validos |  01311300 |   11025000 | Carta Via Internet |     4 | Entrega domiciliar | Segunda a Sexta-Feira. | Avenida Paulista - de 1867 ao fim - lado ímpar | Bela Vista   | São Paulo / SP | Avenida Doutor Pedro Lessa - até 1594 - lado par | Ponta da Praia | Santos / SP     |

  ###################################################################################################################################
  @CN02
  Cenario: Validar feature usando somente Cenario [Precos e Prazos] 
    E que estou na tela inicial da tela de Precos e prazos
    E que eu insira a Data de Postagem
    E que eu insira o CEP de origem "01311200"
    E que eu insira o CEP de destino "11025000"
    E selecione o Tipo de Servico "Aerograma"
    Quando clicar em Enviar
    Entao devo visualizar os dados Prazo de entrega "3", entrega "Entrega domiciliar", Dias de Entrega "Segunda a Sexta-Feira."
    E clicar em dados do Objeto Simulado
    E o endereco Simulado de Origem: CEP, endereco, Bairro, Cidade
      | CepOrigem | EndOrigem                                      | BairroOrigem | CidadeUfOrigem |
      |  01311200 | Avenida Paulista - de 1047 a 1865 - lado ímpar | Bela Vista   | São Paulo / SP |
    E o endereco Simulado de Destino: CEP, endereco, Bairro, Cidade
      | CepDestino | EndDestino                                       | BairroDestino  | CidadeUfDestino |
      |   11025000 | Avenida Doutor Pedro Lessa - até 1594 - lado par | Ponta da Praia | Santos / SP     |
