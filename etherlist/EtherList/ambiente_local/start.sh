echo "Executando docker-compose para o serviço do Mockserver..."
docker-compose -f ambiente_local/docker-compose.yml up -d --remove-orphans --force-recreate --renew-anon-volumes --always-recreate-deps
