```diff
- # ATENÇÃO
```
Para rodar o sistema é necessário clonar o módulo que se encontra aqui: https://github.com/allanbrunobr/cliente-cotacao-dolar . O módulo deverá ficar na mesma nível na estrutura da diretório que o cliente-cotacao-dolar.

# Teste técnico -  Cotação-Dólar

O teste proposto foi para consumir uma API externa do BCB - Banco Central do Brasil a fim de saber a cotação do dólar. 

# Tecnologias utilizadas
Foi utilizado o framework Quarkus e o RestClient para o consumo da API do BCB. O sistema presente receberá uma requisição do cliente-cotacao-dolar. 

# Portas
  O Microserviço Cliente está na porta 8081.

# Swagger

O swagger **não** está funcionando dentro do Docker. Tentei várias vezes, mas acho que deixei passar algo. Para verificar a documentação via Swagger, precisa clonar o projeto e depois importar por alguma IDE (Eclipse, IntelliJ etc). Após a importação do projeto pela IDE, deve-se rodar a aplicação e acessar a documentação da API pela seguinte url: 


http://localhost:8082/q/swagger-ui

# Exceptions
As mensagens das exceções dentro do docker não estão sndo exibidas. Mais uma vez, posso ter deixado passar algo com o Docker. Mas ao executar o programa pela IDE ou até mesmo por um executável (*jar), elas são exibidas na tela.


# Docker

A imagem deverá ser criada pelo sistema cliente-cotacao-dolar, de acordo com as instruções no README do mesmo.

# Testes

Infelizmente, não fiz os testes. Nunca fiz parte de alguma Squad de testes por isso, preferi não realizar do que não saber como explicar se questionado. Mas, vendo agora a necessidade, já estou correndo atrás.
