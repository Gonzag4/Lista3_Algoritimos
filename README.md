# Lista3_Algoritimos
Implementação manual de Árvores Binárias de Busca e Tabelas Hash, desenvolvida para a disciplina de Algoritmos e Estruturas de Dados da UFRPE, seguindo rigorosamente as regras da lista de exercícios, sem uso de estruturas prontas ou algoritmos otimizados da linguagem.


# 📘 Lista de Exercícios 03 – Tabelas Hash e Árvores Binárias de Busca

## Universidade Federal Rural de Pernambuco – UFRPE  
**Departamento:** Computação  
**Área:** Informática  
**Disciplina:** Algoritmos e Estruturas de Dados  
**Curso:** Bacharelado em Ciência da Computação / Licenciatura em Computação  

---

## 👤 Autor
**Luiz Gonzaga**  
Graduando em Ciência da Computação – UFRPE  

---

## 🎯 Objetivo do Trabalho

Este trabalho tem como objetivo consolidar os conhecimentos adquiridos na disciplina de **Algoritmos e Estruturas de Dados**, por meio da implementação manual de estruturas de dados fundamentais, respeitando rigorosamente as regras estabelecidas pelo professor.

Foram implementadas as seguintes estruturas:

- **Árvore Binária de Busca (ABB)**
- **Tabela Hash**, utilizando:
  - *Open Address Hashing* com **Linear Probing**
  - *Closed Address Hashing* com **Listas Lineares Encadeadas**

Todas as estruturas e algoritmos foram desenvolvidos sem o uso de bibliotecas prontas ou métodos otimizados da linguagem de programação.

---

## 📌 Conformidade com as Regras da Disciplina

O trabalho foi desenvolvido em conformidade com todas as regras da Lista de Exercícios 03, destacando-se:

- Não utilização de estruturas de dados prontas das linguagens de programação
- Implementação manual de todas as estruturas de dados
- Uso exclusivo de:
  - Variáveis e tipos primitivos
  - Estruturas condicionais
  - Estruturas de repetição
  - Sub-rotinas (funções/métodos)
  - Estruturas homogêneas (arrays)
  - Estruturas heterogêneas (classes/structs)
- Uso de **alocação dinâmica** para estruturas encadeadas
- Uso de **array estático** apenas onde explicitamente permitido (Tabela Hash)
- Todos os algoritmos foram implementados pelo aluno, sem uso de funções prontas da linguagem

---

## 📂 Estrutura dos Arquivos

Os arquivos foram organizados conforme o padrão exigido pela disciplina:

Lista03/
├── L3Q1.<extensão>
├── L3Q2.<extensão>
└── README.md


Cada arquivo contém todas as estruturas e procedimentos necessários para a resolução completa da respectiva questão.

---

## 🧠 Questões Implementadas

### 🔹 Questão 1 – Árvore Binária de Busca (ABB)

Nesta questão foram implementadas as estruturas básicas e os algoritmos fundamentais de uma **Árvore Binária de Busca**, respeitando suas propriedades.

#### Funcionalidades implementadas:

- **Busca:**  
  Realiza a busca de uma chave percorrendo a árvore de acordo com as propriedades da ABB.

- **Inserção:**  
  Insere novos nós mantendo a propriedade:
  - Subárvore esquerda contém valores menores
  - Subárvore direita contém valores maiores

- **Sucessor:**  
  Determina o sucessor de um nó, ou seja, o menor valor maior que o nó atual.

- **Remoção:**  
  Remove um nó da árvore utilizando obrigatoriamente o procedimento de sucessor, tratando corretamente os casos de:
  - Nó folha
  - Nó com um filho
  - Nó com dois filhos

**Observação:** A remoção foi implementada conforme solicitado, fazendo uso direto do algoritmo de sucessor.

---

### 🔹 Questão 2 – Tabela Hash com Estratégias Híbridas

Foi implementada uma **Tabela Hash de tamanho `m`**, fornecido como parâmetro de entrada, utilizando duas estratégias distintas de tratamento de colisões.

#### Função Hash utilizada

- h(k) = k mod m


#### Estratégias de Colisão

- **Open Address Hashing (Linear Probing):**  
  Enquanto houver espaço disponível na tabela, as colisões são tratadas por sondagem linear, buscando a próxima posição livre no array estático.

- **Closed Address Hashing:**  
  Quando a tabela estiver completamente preenchida, as colisões passam a ser tratadas por **listas lineares encadeadas**, implementadas com alocação dinâmica.

A Tabela Hash foi implementada como um **array estático**, conforme exigido, e as listas utilizadas na estratégia de endereçamento fechado foram implementadas manualmente, sem uso de estruturas prontas da linguagem.

---

## ✅ Considerações Finais

Este trabalho permitiu a aplicação prática dos conceitos de **Árvores Binárias de Busca** e **Tabelas Hash**, reforçando o entendimento sobre:

- Alocação dinâmica de memória
- Manipulação manual de estruturas encadeadas
- Tratamento de colisões em tabelas hash
- Importância da implementação dos algoritmos fundamentais sem abstrações prontas

Todo o código foi desenvolvido seguindo estritamente as regras da disciplina e reflete o aprendizado adquirido ao longo do conteúdo estudado.





