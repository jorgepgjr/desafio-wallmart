/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.desafiowallmart;

import java.io.File;

import org.neo4j.graphalgo.GraphAlgoFactory;
import org.neo4j.graphalgo.PathFinder;
import org.neo4j.graphalgo.WeightedPath;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PathExpanders;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

import br.com.desafiowallmart.domain.Local;
import br.com.desafiowallmart.repository.LocalRepository;

@SpringBootApplication
@ComponentScan
public class DesafioWallmartApplication implements CommandLineRunner {

	@Configuration
	@EnableNeo4jRepositories(basePackages = "br.com.desafiowallmart")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("br.com.desafiowallmart");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory()
					.newEmbeddedDatabase("src/main/resources/baseNeo4jDB.db");
		}
	}
	private static RelationshipType DISTANCIA = DynamicRelationshipType.withName( "DISTANCIA" );
	
	@Autowired
	LocalRepository localRepository;

	@Autowired
	GraphDatabase graphDatabase;
	
	@Autowired
	GraphDatabaseService graphDatabases;

	public void run(String... args) throws Exception {
		Local greg = new Local("Greg");
		Local roy = new Local("Roy");
		Local craig = new Local("Craig");
		Transaction tx = graphDatabase.beginTx();
		try {
//			localRepository.save(greg);
//			localRepository.save(roy);
//			localRepository.save(craig);
//
//			greg = localRepository.findByNome(greg.getNome());
//			System.out.println(greg.getId());
//			greg.rotaPara(roy, 1L);
//			greg.rotaPara(craig, 2L);
//			localRepository.save(greg);
//			
//			Set<Rota> set = greg.getRotas();
//			for (Rota s : set) {
//			    System.out.println(s.getDistancia());
//			}
//			
//			roy = localRepository.findByNome(roy.getNome());
//			System.out.println("ROY ID:   " + roy.getId());
//			roy.rotaPara(craig, 3L);
//			
//			// We already know that roy works with greg
//			localRepository.save(roy);
//
//			// We already know craig works with roy and greg
//
//			System.out.println("Lookup each person by name...");
//			for (String name : new String[] { greg.getNome(), roy.getNome(),
//					craig.getNome() }) {
//				System.out.println(localRepository.findByNome(name));
//			}
//
			tx.success();
		} finally {
			tx.close();
		}
		Transaction tx2 = graphDatabase.beginTx();
		try {
			
			Node a = graphDatabases.createNode();
			a.setProperty("name", "A");
			
			Node b = graphDatabases.createNode();
			b.setProperty("name", "B");
			
			Node c = graphDatabases.createNode();
			c.setProperty("name", "C");
			
			Relationship relacao = a.createRelationshipTo(b, DISTANCIA);
			relacao.setProperty("distancia", 1L);
			
			Relationship relacaoa = a.createRelationshipTo(c, DISTANCIA);
			relacaoa.setProperty("distancia", 4L);
			
			Relationship relacaob = b.createRelationshipTo(c, DISTANCIA);
			relacaob.setProperty("distancia", 3L);
			
			
			PathFinder<WeightedPath> finder = GraphAlgoFactory.dijkstra(
				    PathExpanders.forTypeAndDirection( DISTANCIA, Direction.BOTH ), "distancia" );
			
			WeightedPath path = finder.findSinglePath( a, c );
			System.out.println(path);
			tx2.success();
		} finally {
			tx2.close();
		}

		// GraphAlgoFactory.dijkstra(
		// PathExpanders.forType(type)
		//
		// expander, costEvaluator)

	}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File(
				"src/main/resources/baseNeo4jDB.db"));
		SpringApplication.run(DesafioWallmartApplication.class, args);

	}

}
