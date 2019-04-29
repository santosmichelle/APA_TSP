## RELATÓRIO:  PROBLEMA DO CAIXEIRO VIAJANTE

# Introdução

O Problema do Caixeiro Viajante (ou _travelling salesman problem_, em inglês) é um problema de otimização combinatória
que tem como objetivo determinar a menor rota entre cidades de forma que cada cidade seja visitada uma vez, retornando ao ponto inicial.   
Notamos que, a partir da quantidade de cidades a serem visitadas, teremos várias possibilidades de caminhos. Ou seja, é necessário tomar 
a decisão de qual cidade escolher em cada ponto. Para este caso temos um problema da classe NP-difícil, ou seja, não é possível garantir
que a rota de custo mínimo seja encontrada em tempo polinomial. Assim, no pior caso, todas as possíveis soluções devem ser analisadas [1].  
Sintetizando, dado um grafo completo, com um número n de cidades conectadas entre si. Nota-se que, na primeira cidade, é preciso decidir
entre (n-1) cidades, já que a cidade origem não é considerada (apenas no fim do percurso para voltar). Na segunda cidade, é preciso decidir
e  ntre (n-2), na terceira (n-3) e assim sucessivamente, de forma que todas as cidades sejam percorridas e, em seguida, volte para a cidade
inicial. Ou seja, no início do percurso, o caixeiro possui (n-1)! soluções possíveis e [(n-1)!/2] decisões que pode tomar ao longo do
caminho. Sendo, assim, um problema de complexidade fatorial, e, portanto, pertencente à classe NP-difícil. Isso torna uma solução 
em tempo exponencial inviável, visto que em aplicações práticas, o valor dessa solução é gigante.  
Problemas do NP-difícil ou NP-completos enfrentam dificuldade computacional de resolução em que encontrar soluções ótimas, ou mesmo 
aproximadas, é um desafio muito difícil e que, em muitos casos, nem sempre haverá necessidade de se encontrar a melhor solução, e sim
uma que gere uma solução adequada em tempo hábil [4]. Para isso, existem diversos tipos de algoritmos que podem resolver esses tipos
de problemas, como exemplo: os exatos, como os de programação dinâmica, branch-and-bound, entre outros; os aproximativos, aqueles que
encontram uma solução viável com um valor a uma distância máxima garantida do ótimo; e os heurísticos, que são aqueles que tentam
encontrar uma solução boa (não necessariamente a melhor) de uma maneira simples e rápida, de acordo com às necessidades da aplicação, 
sendo estes os ideias para a resolução do problema em questão e o que utilizaremos.

# Representação da Solução

Uma heurística de construção tem por objetivo construir uma solução, elemento por elemento [1]. Uma solução inicial pode ser gerada de
forma aleatória ou por meio de uma heurística construtiva, sendo a última, a maneira mais utilizada. A forma de escolha de cada elemento
a ser inserido em cada passo varia de acordo com a função de avaliação adotada, a qual, por sua vez, depende do problema abordado [2].
Para o Problema do Caixeiro Viajante, existem três exemplos de heurísticas construtivas que podem ser utilizadas para a construção da 
solução inicial do problema, são elas: a heurística do Vizinho Mais Próximo (_Nearest Neighbor_), a de _Nemhauser e Bellmore_ e a de
Inserção Mais Barata (_Cheapest Insertion_). Neste trabalho, não será entrado em detalhes a respeito do funcionamento delas.
Para a realização deste trabalho, foi escolhida a Heurística do Vizinho Mais Próximo, devido a sua popularidade e facilidade
de implementação.  

