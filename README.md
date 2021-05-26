# teste-star-wars
Projeto feito com intuito de criar uma api para criar, listar e deletar planetas do universo star wars.

# Endpoints criados
 - Get: http://localhost:8080/planet/all
    - Lista todos os planetas cadastrados no banco de dados.
 - Get: http://localhost:8080/planet/{planetId}/id/search
    - Lista o planeta que possui o id passado no path do request.
 - Get: http://localhost:8080/planet/{planetName}/name/search
    - Lista o planeta que possui o nome passado no path do request.
 - Post: http://localhost:8080/planet
    - Cria um planeta de acordo com os campos passados.
    - Exemplo de body do request
      ```json
      {
        "name": "hoth",
        "climate": "frozen",
        "terrain": "snow mountains"
      }
      ```
 - Delete: http://localhost:8080/planet/{planetId}
    - Deleta um planeta que possui o id passado no path do request.
