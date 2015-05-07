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

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * 
 * Classe para iniciar o sistema
 * @author jorge
 *
 */
@Configuration
@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "br.com.desafiowallmart")
public class DesafioWallmartApplication extends Neo4jConfiguration{

		public DesafioWallmartApplication() {
			setBasePackage("br.com.desafiowallmart");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory()
					.newEmbeddedDatabase("src/main/resources/baseNeo4jDB.db");
		}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File(
				"src/main/resources/baseNeo4jDB.db"));
		SpringApplication.run(DesafioWallmartApplication.class, args);

	}

}
