# Desafio-wallmart

# Tecnologias utilizadas:
- Java, JDK 7
- Spring Boot (configuração mais fácil do sistema)
- Spring Core (injeção de dependência)
- Spring Actuator (WS)
- Tomcat Embeded (Mais fácil para vocês testarem a aplicação)
- Neo4j (NoSQL baseado em grapho e com o algoritmo de Dijkstra pronto)
- Mockito (Mock de testes)
- Travis (C.I.) https://travis-ci.org/jorgepgjr/desafio-wallmart

# Como executar:
Com o maven instalado, 
 - mvn package
 - Navegue até a pasta target do projeto e execute java -jar desafio-wallmart-1.2.3.RELEASE.jar

# Para acessar o WS:

-http://localhost/cadastraRota   PUT
  Cadastra uma rota no formato JSON:
  ```
  {
   "nomeMapa": "teste",
   "rotaVO":    [
            {
         "origem": "Origem",
         "destino": "Destino",
         "distancia": 10
      },
            {
         "origem": "Origem2",
         "destino": "Destino2",
         "distancia": 20
      },
            {
         "origem": "Origem3",
         "destino": "Destino3",
         "distancia": 30
      }
   ]
}
```
- http://localhost/cadastraRotaExample GET
  Retorna um exemplo de JSON para cadastro de Rota

- http://localhost/consultaRota POST

  Consulta rota no formato JSON:
```
      {
        "origem": "Origem",
        "destino": "Destino",
        "autonomia": 5,
        "valorCombustivel": 5.1
       }
```
- http://localhost/consultaRotaExample GET
  Retorna um exemplo de JSON para consulta de Rota
  
# Referencia do algoritimo:
http://neo4j.com/docs/stable/tutorials-java-embedded-graph-algo.html

# Tempo do projeto do dia 04/05 - 07/05

#TODO:
- Relatorio de Cobertura de testes
- Javadoc
- Melhorar tratamento de mensagens
