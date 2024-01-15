FROM openjdk:17-jdk-slim

# Installation de Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Configuration du répertoire de travail
WORKDIR /app

# Copie des fichiers du projet dans le conteneur
COPY . .

# Commande par défaut pour le conteneur (peut être remplacée lors du lancement du conteneur)
#CMD ["bash"]
ENTRYPOINT ["tail", "-f", "/dev/null"]

#ENTRYPOINT ["mvn", "spring-boot:run"]