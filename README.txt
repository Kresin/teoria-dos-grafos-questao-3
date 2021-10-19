Alunos: Gabriel Kresin e Iago G. Tambosi

Enunciado

Segue abaixo as funcionalidades que precisam ser implementadas neste trabalho. Ele trabalhará apenas com grafos não-dirigidos.

ENTRADA:
Sua implementação deve ser capaz de ler um grafo de um arquivo texto. O formato do grafo no arquivo será o seguinte.
A primeira linha informa o número de vértices do grafo. Cada linha subsequente informa as arestas. Um exemplo de um grafo
e seu respectivo arquivo texto pode ser visto acima.

SAÍDA:
    a. Busca em grafos: sua implementação deve ser capaz de percorrer o grafo utilizando busca em largura e busca em profundidade.
       O vértice inicial será dado pelo usuário. A respectiva árvore de busca deve ser gerada assim como o nível de cada
       vértice na árvore (nível da raiz é zero). Estas informações devem ser armazenadas em um arquivo.

Considerando cada um dos grafos de entrada, responda às perguntas abaixo:
    1. Determine o tempo necessário para executar dez buscas em largura e profundidade em cada um dos casos
       (utilize diferentes vértices como ponto de partida da busca). Dica: obtenha o tempo do relógio da máquina no seu
       código antes de iniciar e depois de terminar a BFS/DFS.
    2. Você deve preparar uma (ou duas) tabela com os resultados obtidos onde as colunas representam as características
       e as linhas representam os diferentes grafos analisados. O importante é computador o tempo de execução de cada uma das buscas (DFS/BFS).

Sugestão de solução:
Implementar uma classe para escrita e leitura de arquivos;
Criar função para criar o grafo/matriz a partir do arquivo de texto;
Implementar uma classe especializada em BFS;
Implementar uma classe especializada em DFS;