import os
import re
import json

def remove_comments_from_json(content):
    """Remove comentários de um JSON usando regex."""
    # Remove comentários de linha (// ...)
    content = re.sub(r"//.*", "", content)
    # Remove comentários de bloco (/* ... */)
    content = re.sub(r"/\*.*?\*/", "", content, flags=re.DOTALL)
    return content

def update_json_files(base_dir="."):
    for root, _, files in os.walk(base_dir):
        for file in files:
            if file.endswith(".json"):
                file_path = os.path.join(root, file)
                try:
                    with open(file_path, "r", encoding="utf-8") as f:
                        raw_content = f.read()
                    
                    # Remove comentários antes de carregar o JSON
                    clean_content = remove_comments_from_json(raw_content)
                    data = json.loads(clean_content)

                    # Substituir "moreblocks:" por "somemoreblocks:"
                    data_str = json.dumps(data)
                    updated_data_str = data_str.replace("somesomemoreblocks:", "somemoreblocks:")
                    updated_data = json.loads(updated_data_str)

                    # Salvar alterações no arquivo com indentação de 2 espaços
                    with open(file_path, "w", encoding="utf-8") as f:
                        json.dump(updated_data, f, indent=2)

                    print(f"Updated: {file_path}")
                except (json.JSONDecodeError, IOError) as e:
                    print(f"Error processing {file_path}: {e}")

if __name__ == "__main__":
    update_json_files()
