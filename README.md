#  **Como está estruturado**

Seguindo a ideia de fazer um jogo de Paciência o mais modularizado possível, surgiu este projeto.

Com toda as funcionalidades do código estando no src. A classe principal sendo ***Menu.java***.

## **MODEL**

## Criação de carta

Iniciando com a criação de classe para pode criar o objeto de carta, sendo essas utilizadas para o desenvolvimento do jogo.

Nela se encontra as informações essencias que é necessário para uma carta existir: naipe, valor, peso(para calcular a distância entre cartas), vísibilidade e cor.

### Baralho

Foi implementado uma factory, padrão factory method, para poder gerenciar a criação de baralhos, podendo assim existir a criação de diferentes tipos deles(caso se queira implementar outros jogos em que o baralho é diferente). Porém no jogo atual, o Paciência, só se utiliza 1 baralho simples, sem coringa, com 52 cartas.

### Pilhas

Para organização das pilhas de fundações, estoque, fileiras e descarte, foi utilizada uma classe abstrata Pilha que implementa os atributos/métodos comuns à todas as pilhas.

Também foi adicionados métodos específicos em algumas pilhas, nas suas respectivas classes.

## **UTIL**

Foram necessários alguns métodos em que seriam utilizados em todo o código, e já pensando em facilitar para projetos futuros, foi pensado na criação dessa pasta.

### Comparar Cartas

Classe para realizar as comparações entre as cartas. Nela temos as comparações necessárias para a utilização nas fundações e nas fileiras. Tendo também métodos para informar se pode ou não realizar a movimentação.

### Embaralhar

Classe que embaralha e retorna um array de cartas.

### Mostrar Carta

Esta classe possui um método que recebe um array de cartas e oculta todas ou as torna visíveis.

### Mover Cartas

Classe que contém os métodos que são responsáveis pelas movimentações no jogo, permitindo a movimentação de somente uma carta, ou de várias cartas em conjunto.

## **Controller**

Utiliza essa pasta para organização de comandos, junção de alguns comandos para uma melhor organização e facilitando a criação de novos controller quando quiser implementar novas coisas.

### Controller Menu

Este controller tem o objetivo de ser um inicio para qualquer jogo que possa ser implementado futuramente. Ele possui funções básicas que os jogos necessitam.

### Controller Movimentos

Este controller é responsável por pelas movimentações entre as pilhas. Contém métodos para cada movimento, utilizando os métodos da classe MoverCartas.

### Controller Paciência

Este controller possui as regras especifícas utilizadas para o jogo de paciências.

## **VIEW**

Pacote responsável pela interface do código. Contendo todos os prints e comunicações com o usuário.

### Menu

Sendo a responsável para inicialização do jogo, em que pergunta pro usuário se quer iniciar a partida de paciência ou encerrar o programa. Montado dessa forma para facilitar a criação de um menu para qualquer outro jogo que possa vir ser implementado.

### Menu Paciência

Este menu é responsável por todas opções de jogadas disponíveis ao jogo Paciência. Dividido em "dois" menus, um para escolher uma próxima jogada, como por exemplo mover cartas, e outro com as movimentações possíveis entre as pilhas. No "primeiro" menu é sempre verificado se o jogo foi ganho para que possa ser finalizado assim que o usuário complete as quatro fundações.


# PADROES QUE PODERIAM SER UTILIZADOS

# PONTOS FORTER E FRACOS

# MODELO CONCEITUAL

# MODELO DE BAIXO NÍVEL