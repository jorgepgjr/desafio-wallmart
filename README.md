# Desafio-wallmart

# Tecnologias utilizadas:
- Spring Boot (configuração mais fácil do sistema)
- Spring Core (injeção de dependência)
- Spring Actuator (WS)
- Tomcat Embeded
- Neo4j (NoSQL baseado em grapho e com o algoritmo de Dijkstra pronto)
- Mockito (Mock de testes)
- Travis (C.I.) https://travis-ci.org/jorgepgjr/desafio-wallmart

# Como executar:
Com o maven instalado, 
 - mvn install
 - Navegue até a pasta target do projeto e execute java -jar desafio-wallmart-1.2.3.RELEASE.jar

# Para acessar o WS:

  http://localhost/cadastraRota
    Cadastra uma rota no formato json:
    
  http://localhost/cadastraRotaExample
  http://localhost/consultaRota
  
# Referencia do algoritimo:
http://neo4j.com/docs/stable/tutorials-java-embedded-graph-algo.html

#TODO:
- Relatorio de Cobertura de testes
- Javadoc
- Melhorar tratamento de mensagens
