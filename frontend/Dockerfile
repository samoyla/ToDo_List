# Utiliser une image Node.js en tant que base
FROM node:14-alpine

# Définir le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copier les fichiers du projet dans le conteneur
COPY . .

# Installer les dépendances
RUN npm install

# Construire l'application React
RUN npm run build

# Exposer le port sur lequel l'application React s'exécute (par défaut : 3000)
EXPOSE 3000

# Commande pour démarrer l'application React
CMD ["npx", "serve", "-s", "-l", "3000", "build"]
