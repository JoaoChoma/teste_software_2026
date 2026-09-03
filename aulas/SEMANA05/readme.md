# Vamos testar algo na aula de teste

## Usar o codespaces do github

`https://github.com/codespaces`

### Criar um `New codespace``

1. Escolher o repositório onde será criado o projeto
2. Create project 

### O ambiente do vscode será carregado
1. Confiar na pasta e continuar

### No terminal

Acessar a pasta desejada para o projeto `maven`

ls
cd
cd ..

mkdir nomePasta






```
mvn archetype:generate \
  -DgroupId=br.edu.cesu \
  -DartifactId=aula-testes-unitarios \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

### Substituir o pom.xml por:

````
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>br.edu.ifpr</groupId>
    <artifactId>aula-testes-unitarios</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

        <junit.version>5.11.0</junit.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.0</version>
            </plugin>

        </plugins>
    </build>

</project>
````

### Executar

`mvn clean compile`

### Criar o diretório `.devcontainer/`

### Criar o arquivo `devcontainer.json`

```
{
  "name": "Java 17 + Maven + JUnit 5",

  "image": "mcr.microsoft.com/devcontainers/java:0-17",

  "features": {
    "ghcr.io/devcontainers/features/java:1": {
      "version": "none",
      "installMaven": true,
      "installGradle": false
    },

    "ghcr.io/devcontainers/features/git-lfs:1": {}
  },

  "customizations": {
    "vscode": {
      "extensions": [
        "vscjava.vscode-java-pack"
      ]
    }
  },

  "postCreateCommand": "git lfs install && java -version && javac -version && mvn -version && git lfs version"
}

```

`Codespaces: Rebuild Container`

---

# Depois de escrever código e teste

`mvn clean compile`

## Rodar teste

`mvn test`

---

# Comandos úteis

# Remove arquivos compilados
mvn clean

# Compila src/main
mvn compile

# Compila também os testes
mvn test-compile

# Executa os testes
mvn test

# Gera o .jar
mvn package

# Limpa, testa e gera o pacote
mvn clean package


# Executar teste

mvn clean test jacoco:report

python3 -m http.server 8080 -d target/site/jacoco


````
<build>
        <plugins>

            <!-- Executa testes JUnit 5 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.0</version>
            </plugin>

            <plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.13</version>

    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>

        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>

        </plugins>
    </build>
````
