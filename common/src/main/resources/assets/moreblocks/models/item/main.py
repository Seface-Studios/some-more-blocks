print('Testing')

import os
import json

# Diretório atual
diretorio_atual = os.getcwd()

# Definir a parte a ser substituída e o novo valor
parte_a_substituir = "texto_antigo"
novo_texto = "novo_texto"

# Percorrer todos os arquivos no diretório atual
for arquivo_nome in os.listdir(diretorio_atual):
    if arquivo_nome.endswith('.json'):
        caminho_arquivo = os.path.join(diretorio_atual, arquivo_nome)
        
        # Carregar o arquivo JSON
        with open(caminho_arquivo, 'r', encoding='utf-8') as file:
            dados = json.load(file)
        
        # Converter o JSON para uma string
        json_str = json.dumps(dados)
        
        # Substituir a parte específica
        json_str_modificado = json_str.replace('bricks_stairs', 'brick_stairs').replace('bricks_slab', 'brick_slab').replace('bricks_wall', 'brick_wall').replace('tiles_stairs', 'tile_stairs').replace('tiles_slab', 'tile_slab').replace('tiles_wall', 'tile_wall')
        
        # Converter a string de volta para JSON
        dados_modificados = json.loads(json_str_modificado)
        
        # Salvar o JSON modificado de volta no arquivo
        with open(caminho_arquivo, 'w', encoding='utf-8') as file:
            json.dump(dados_modificados, file, ensure_ascii=False, indent=2)

        print(f'Arquivo modificado: {caminho_arquivo}')


for arquivo_nome in os.listdir(diretorio_atual):
    if arquivo_nome.endswith('.json'):
        # Novo nome do arquivo
        novo_nome = arquivo_nome.replace('bricks_stairs', 'brick_stairs').replace('bricks_slab', 'brick_slab').replace('bricks_wall', 'brick_wall').replace('tiles_stairs', 'tile_stairs').replace('tiles_slab', 'tile_slab').replace('tiles_wall', 'tile_wall')
        caminho_antigo = os.path.join(diretorio_atual, arquivo_nome)
        caminho_novo = os.path.join(diretorio_atual, novo_nome)
        
        # Renomear o arquivo
        os.rename(caminho_antigo, caminho_novo)
        print(f'Arquivo renomeado: {arquivo_nome} -> {novo_nome}')