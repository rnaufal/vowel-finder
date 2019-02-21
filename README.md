# Busca de um caracter vogal em uma Stream

Sistema que, dada uma stream, encontra o primeiro caracter Vogal, após uma consoante, 
onde a mesma é antecessora a uma vogal e que não se repita no resto da stream. Caso não encontre
o caracter vogal, uma mensagem amigável é informada. 
O sistema foi desenvolvido utilizando Java 11 e Gradle para *build* do projeto.

## Pré-requisitos

- Java 11
- Definição da variável de ambiente *JAVA_HOME*, que aponta para a instalação do JAVA

## Configuração e Build

As seguintes tecnologias foram utilizadas:

- Java 11;
- JUnit 5;
- Hamcrest matchers para tornar os *asserts* nos testes mais elegantes;
- Gradle para *build* do projeto

O sistema deve ser construído na raiz do projeto vowel-finder com o seguinte comando:

***./gradlew clean build*** (em sistemas Unix) e ***./gradlew.bat clean build*** (Windows)

Esse comando utiliza o Gradle *wrapper* para baixar a distribuição do Gradle apropriada.

## Executando o sistema

O sistema deve ser executado na raiz do projeto vowel-finder com o seguinte comando Gradle: ***./gradlew run -PappArgs={stream}***

Esse comando realiza as seguintes tarefas: 

* *build* do sistema, execução dos testes unitários;
* Execução da classe principal *MainApplication* passe todos os testes unitários forem executados com sucesso;

O parâmetro **{stream}** deve ser substituído pela stream que se deseja buscar o caracter vogal.

Caso o parâmetro **{stream}** não seja passado para o sistema, uma mensagem de como deve ser feita a execução é mostrada.

A saída do sistema tanto no sucesso quanto insucesso na busca do caracter vogal ocorre no *console*.

## Testes unitários

Os testes unitários podem ser executados individualmente através do seguinte comando Gradle: 

***./gradlew test***

## Premissas

Uma chamada para ``` hasNext() ``` irá retornar se a stream ainda contém caracteres para processar.

Uma chamada para ``` getNext() ``` irá retornar o próximo caracter a ser processado na stream.

Não será possível reiniciar o fluxo da leitura da stream.

## Arquitetura e padrões

O sistema possui os seguintes diretórios de código fonte:

* *src/main/java*: Encontram-se as classes do sistema;
* *src/test/java*: Encontram-se os testes unitários do sistema;

A classe *CharSequenceStream* representa uma implementação da interface *Stream* de String.

A estratégia utilizada para a resolução do problema foi a seguinte:

          
* Ao final do processo, o caracter vogal encontrado ou um caracter vazio (indicando que o vogal não foi encontrado)
é retornado como resultado da busca.

O sistema mostra no *console* a mensagem *Output: {vogal}* ou uma mensagem informando que o caracter não foi localizado.

## Entradas e saídas

Exemplo (em sistemas Unix):

cd /*{PATH_DO_PROJETO}*/vowel-finder

**./gradlew run -PappArgs=aAbBABacafe**

**Output:** e

**./gradlew run -PappArgs=casa**

**Output:** Caracter vogal nao localizado. Por favor, tente outra stream.

**./gradlew run**

**Output:** Executar o sistema da seguinte forma: ./gradlew run -PappArgs={stream}. Substituir {stream} pela stream desejada.
