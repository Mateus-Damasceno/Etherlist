echo "Executando docker-compose para o mongodb..."
system break
docker-compose -f C:/Users/matheus.damasceno/IdeaProjects/etherlist/EtherList/src/docker-compose.yml up -d --remove-orphans --force-recreate --renew-anon-volumes --always-recreate-deps
