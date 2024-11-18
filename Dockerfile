# Etapa 1: Construção do projeto com Maven
FROM maven:3.8-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven e o código-fonte para o container
COPY pom.xml .
COPY src ./src

# Executa o Maven para construir o projeto e gerar o arquivo .jar
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final para execução do aplicativo
FROM amazoncorretto:17

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot (8080)
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
