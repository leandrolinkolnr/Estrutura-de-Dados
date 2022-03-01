# Projeto Estrutura de dados e algoritmos
-> Leandro Lincoln Rodrigues.

-> João Antônio.

 
Esse software foi desenvolvido durante a disciplina de Estrutura de dados e Algoritmo. Ele consiste na leitura, processamento e manipulação de um arquivo csv. 
Seu objetivo principal é ordenar o arquivo recebido de acordo com o campo e algoritmo escolhido pelo usuário.
     

- Para execução deste software, será necessário seguir alguns passos:


- Primeiramente, é necessário ter o Java na sua máquina. Caso nao o tenha, é necessário instala-lo. 


- Em seguida, é preciso clonar este repositorio para a sua maquina.


- Tambem é necessário baixar o arquivo csv na sua maquina, pois é em cima dele que iremos trabalhar durante toda a execução do software.
Atenção : É importante te-lo em um lugar de fácil visibilidade, pois é necessário indicar no programa o caminho onde o arquivo se encontra.


- Após isso, é preciso abrir o arquivo 'Main' (através de algum editor de texto ou de uma IDE) e alterar o caminho do arquivo csv, colocando onde se encontra o arquivo na sua maquina. (Linha 101).


- Depois disso, é preciso ir no arquivo 'ManipularVetor', e alterar o 'caminho_padrao', que é onde o arquivo googleplaystore_date.csv (apos a transformação da data) será salvo.


- Em seguida, novamente no arquivo "Main",  alterar o caminho do arquivo csv, colocando o caminho que voce acabou de definir para o arquivo googleplaystore_date.csv (Linha 111).


- Após essas alterações feitas, escolha uma IDE de sua preferencia para executar o programa java. Nela, voce deve importar o projeto que vc baixou.


- Quando o programa for executado, ele mostrará uma pequena apresentação e logo após um menu onde sao apresentadas algumas opções:


*  Ordenar pelo nome (Campo 'App')  
*  Ordernar pelas Notas de Avaliação (Campo 'Ratins' ) 
*  Ordernar pelo número de instalações (Campo 'installs')  
*  Ordernar pela data da última atualização (Campo last_update)
*  Filtrar por genero 
*  Sair



-Se a escolha for Filtrar por gênero, será pedido pra informar por qual gênero quer filtrar. Ao digitar e dar enter, sera gerado um arquivo contendo apenas os aplicativos que são pertencentes ao genero escolhido. Caso o genero escolhido nao exita ou por algum motivo foi informado errado, será gerado um arquivo em branco. 


- Caso decida por ordenar algum dos campos disponíveis, sera apresentado um submenu apresentando todos os algoritmos de ordenação disponíveis para ordenar a coluna que você escolheu no menu anterior.

- Em seguida, o programa ira processar o arquivo csv e ordena-lo de acordo com o campo e algoritmo utilizado, passando por todos os casos e irá gerar e nomear o arquivo de acordo com as escolhas. Dessa forma, o algoritmo ira imprimir os passos e em seguida em quanto tempo o algoritmo foi executado em todos os tipos de caso. (medio, melhor e pior, respectivamente).

- Apos isso, o programa automaticamente volta para o menu principal. O processo é repetido ate que vc escolha a opção para sair, onde o programa será finalizado.





