# Utiliser une image Node.js en tant que base
FROM node:16-alpine

# Définir le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

COPY ./entrypoint.sh /usr/bin/entrypoint.sh

# Commande pour démarrer l'application React
ENTRYPOINT ["/bin/sh", "/usr/bin/entrypoint.sh"]
