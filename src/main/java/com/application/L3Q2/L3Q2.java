package com.application.L3Q2;

// L3Q2.java
// Tabela Hash com (Encadeamento)
// Estruturas de Dados e Algoritmos - Lista 03 - Questão 02



// Representa um nó de uma lista encadeada.
class NoLista {
    int chave;       // Valor armazenado no nó
    NoLista proximo; // Referência para o próximo nó da lista

    public NoLista(int chave) {
        this.chave = chave;
        this.proximo = null;
    }
}

// Representa uma lista encadeada simples (usada quando a tabela está cheia)
class ListaEncadeada {
    NoLista cabeca; // Aponta para o primeiro nó da lista

    public ListaEncadeada() {
        this.cabeca = null;
    }

    // Insere um novo nó no início da lista
    public void inserir(int chave) {
        NoLista novoNo = new NoLista(chave);
        novoNo.proximo = this.cabeca; // Aponta para o antigo primeiro nó
        this.cabeca = novoNo;         // Novo nó vira a cabeça da lista
    }

    // Busca um valor dentro da lista
    public boolean buscar(int chave) {
        NoLista atual = this.cabeca;
        while (atual != null) { // Percorre até o fim
            if (atual.chave == chave) { // Se achar a chave, retorna true
                return true;
            }
            atual = atual.proximo;
        }
        return false; // Não encontrou
    }
}

// Representa uma célula da tabela hash (para inserção direta)
class Celula {
    int chave;      // Valor guardado
    boolean ocupada; // Indica se essa posição já foi usada

    public Celula() {
        this.chave = -1;  // Usamos -1 para indicar que está vazia
        this.ocupada = false;
    }
}

// Classe principal da tabela Hash
class TabelaHash {
    Celula[] tabela;         // Vetor principal da hash
    ListaEncadeada[] listas; // Vetor de listas (para encadeamento)
    int m;                   // Tamanho da tabela
    int numElementos;        // Quantidade de elementos inseridos
    boolean tabelaCheia;     // Indica quando todas as posições diretas já estão ocupadas

    public TabelaHash(int m) {
        this.m = m;
        this.tabela = new Celula[m];
        this.listas = new ListaEncadeada[m];
        this.numElementos = 0;
        this.tabelaCheia = false;

        // Inicializa todas as posições da tabela
        int i = 0;
        while (i < m) {
            this.tabela[i] = new Celula();
            this.listas[i] = null; // Lista só será criada se necessário
            i = i + 1;
        }
    }

    // Função Hash simples: resto da divisão
    private int funcaoHash(int chave) {
        return chave % this.m;
    }

    // Insere uma chave na tabela hash
    public void insercao(int chave) {
        // Enquanto ainda houver espaço na tabela principal
        if (!this.tabelaCheia) {
            int indice = funcaoHash(chave);
            int tentativas = 0;

            // Probing linear (procura próxima posição vazia)
            while (tentativas < this.m) {
                int posicao = (indice + tentativas) % this.m;

                // Se achou uma posição livre, insere
                if (!this.tabela[posicao].ocupada) {
                    this.tabela[posicao].chave = chave;
                    this.tabela[posicao].ocupada = true;
                    this.numElementos = this.numElementos + 1;

                    // Se lotou a tabela, a partir de agora usaremos listas encadeadas
                    if (this.numElementos == this.m) {
                        this.tabelaCheia = true;
                    }

                    return; // Inserção concluída
                }

                tentativas = tentativas + 1;
            }

            // Caso não ache espaço com probing → marcamos tabela como cheia
            this.tabelaCheia = true;
        }

        // Inserção por encadeamento (quando não cabe mais no vetor principal)
        int indice = funcaoHash(chave);

        if (this.listas[indice] == null) {
            this.listas[indice] = new ListaEncadeada(); // Cria lista na posição
        }

        this.listas[indice].inserir(chave); // Insere na lista
    }

    // Busca uma chave na tabela
    public boolean buscar(int chave) {
        int indice = funcaoHash(chave);

        // Tenta procurar primeiro no vetor principal
        int tentativas = 0;
        while (tentativas < this.m) {
            int posicao = (indice + tentativas) % this.m;

            if (this.tabela[posicao].ocupada && this.tabela[posicao].chave == chave) {
                return true; // Achou no vetor
            }

            tentativas = tentativas + 1;
        }

        // Se não achou no vetor, procura na lista encadeada
        if (this.listas[indice] != null) {
            return this.listas[indice].buscar(chave);
        }

        return false; // Não achou
    }
}

public class L3Q2 {
    public static void main(String[] args) {
        // Cria a tabela hash com tamanho 7
        TabelaHash tabela = new TabelaHash(7);

        // Inserções iniciais
        tabela.insercao(10);
        tabela.insercao(20);
        tabela.insercao(30);
        tabela.insercao(15);
        tabela.insercao(22);
        tabela.insercao(35);
        tabela.insercao(40);

        // Aqui já deve começar o encadeamento
        tabela.insercao(50);
        tabela.insercao(17);
        tabela.insercao(24);
        tabela.insercao(31);

        // Teste de buscas
        boolean encontrado1 = tabela.buscar(22);  // Deve encontrar
        boolean encontrado2 = tabela.buscar(50);  // Também deve encontrar
        boolean encontrado3 = tabela.buscar(100); // Não existe → falso
    }
}
