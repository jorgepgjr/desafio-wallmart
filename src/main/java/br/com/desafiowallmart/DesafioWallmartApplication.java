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

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DesafioWallmartApplication {

	@Configuration
	@EnableNeo4jRepositories(basePackages = "br.com.desafiowallmart")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("br.com.desafiowallmart");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory().newEmbeddedDatabase("src/main/resources/baseNeo4jDB.db");
		}
	}
	
	@Autowired LocalRepository localRepository;

	@Autowired GraphDatabase graphDatabase;
	
	public void run(String ...args) throws Exception{
		Local greg = new Local("Greg");
		Local roy = new Local("Roy");
		Local craig = new Local("Craig");

		System.out.println("Before linking up with Neo4j...");
		for (Local local : new Local[] { greg, roy, craig }) {
			System.out.println(local);
		}

		Transaction tx = graphDatabase.beginTx();
		try {
			localRepository.save(greg);
			localRepository.save(roy);

			greg = localRepository.findByNome(greg.getNome());
			greg.criarRota(roy);
			greg.criarRota(craig);
			localRepository.save(greg);

			roy = localRepository.findByNome(roy.getNome());
			roy.criarRota(craig);
			// We already know that roy works with greg
			localRepository.save(roy);

			// We already know craig works with roy and greg

			System.out.println("Lookup each person by name...");
			for (String name : new String[] { greg.getNome(), roy.getNome(), craig.getNome() }) {
				System.out.println(localRepository.findByNome(name));
			}

			tx.success();
		} finally {
			tx.close();
		}

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesafioWallmartApplication.class, args);
		
	}

}
