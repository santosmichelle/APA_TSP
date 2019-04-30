# Travelling Salesman Problem
#### Repositório de estudo e desenvolvimento de projeto final da disciplina de Análise e Projeto de Algoritmos.

### Equipe

Bianca K. Amorim de S. Melo ([@biancamoriim](https://github.com/biancamoriim)) e Michelle S. da Silva ([@santosmichelle](https://github.com/santosmichelle))

### Relatório

Neste repositório, encontra-se apenas a implementação do trabalho. Para visualizar o relatório, acesse [aqui](https://docs.google.com/document/d/1vSaeRasYBSAWTxletZfLmZQKDicpnwml3HjWlwxd-gA/edit?usp=sharing).

### Problema do Caixeiro Viajante

O Problema do Caixeiro Viajante (TSP) é um problema de otimização combinatória que tem como objetivo determinar a menor rota entre cidades de forma que cada cidade seja visitada uma vez, retornando ao ponto inicial. Este tipo de problema enquadra-se no tipo de problema conhecido como NP-Difícil, que a enfrentam dificuldade computacional de resolução em que encontrar soluções ótimas, ou mesmo aproximadas, é um desafio muito complicado e que, em muitos casos, nem sempre haverá necessidade de se encontrar a melhor solução, e sim uma que gere uma solução adequada em tempo hábil. Para isso, existem algoritmos heurísticos, que são aqueles que tentam encontrar uma solução boa (não necessariamente a melhor) de uma maneira simples e rápida, de acordo com às necessidades da aplicação, sendo estes os ideias para a resolução do problema em questão e o que utilizaremos.

#### Heurística de Construção

A heurística de construção escolhida aqui foi a do **Vizinho Mais Próximo** (*Nearest Neighboor Heuristc/NNH*). Nesta heurística, parte-se da cidade origem e adiciona-se a cada passo a cidade k ainda não visitada cuja distância à última cidade visitada é a menor possível. O procedimento de construção termina quando todas as cidades forem visitadas, situação na qual é feita a ligação entre a última cidade visitada e a cidade origem. 

#### Heurística de Refinamento

A heurística de refinamento escolhida foi a **Descida em Vizinhança Variável** (*Variable Neighborhood Descent/VND*), que é um método de refinamento que consiste em explorar o espaço de soluções por meio de trocas sistemáticas de estruturas de vizinhança, aceitando somente soluções de melhora da solução corrente e retornando à primeira estrutura quando uma solução melhor é encontrada.

