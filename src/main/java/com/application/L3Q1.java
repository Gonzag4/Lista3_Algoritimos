package com.application;

// Representa um nó de uma árvore binária de busca
class No {
    int chave;     // Valor que o nó armazena
    No esquerda;   // Referência para o filho da esquerda
    No direita;    // Referência para o filho da direita
    No pai;        // Referência para o nó pai (útil para remoção e sucessor)

    public No(int chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}

// Implementação de uma Árvore Binária de Busca (ABB)
class ArvoreBinariaDeBusca {
    No raiz; // Nó raiz da árvore

    public ArvoreBinariaDeBusca() {
        this.raiz = null;
    }

    // PROCEDIMENTO 1: BUSCA
    // Chama a busca recursiva começando pela raiz
    public No busca(int chave) {
        return buscaRecursiva(this.raiz, chave);
    }

    // Busca recursiva padrão de ABB:
    // Se chave < nó → vai para esquerda
    // Se chave > nó → vai para direita
    private No buscaRecursiva(No no, int chave) {
        // Caso base: chegou numa folha ou encontrou o valor
        if (no == null || no.chave == chave) {
            return no;
        }

        // Escolhe o lado da árvore para continuar a busca
        if (chave < no.chave) {
            return buscaRecursiva(no.esquerda, chave);
        } else {
            return buscaRecursiva(no.direita, chave);
        }
    }

    // PROCEDIMENTO 2: INSERÇÃO
    // Insere um novo nó respeitando a propriedade da ABB
    public void insercao(int chave) {
        No novoNo = new No(chave);
        No y = null; // Será o pai do novo nó
        No x = this.raiz; // Começa pesquisando pela raiz

        // Caminha pela árvore para encontrar onde inserir
        while (x != null) {
            y = x;
            if (novoNo.chave < x.chave) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        // Define o pai do novo nó
        novoNo.pai = y;

        // Se a árvore estava vazia, o novo nó vira a raiz
        if (y == null) {
            this.raiz = novoNo;
            // Senão, define se é filho da esquerda ou direita
        } else if (novoNo.chave < y.chave) {
            y.esquerda = novoNo;
        } else {
            y.direita = novoNo;
        }
    }

    // PROCEDIMENTO 3: SUCESSOR
    // O sucessor é o próximo maior elemento da árvore
    public No sucessor(No no) {
        if (no == null) {
            return null;
        }

        // Caso exista subárvore à direita: o sucessor é o menor dessa subárvore
        if (no.direita != null) {
            return minimo(no.direita);
        }

        // Caso contrário, sobe pelos pais até encontrar alguém maior
        No y = no.pai;
        while (y != null && no == y.direita) {
            no = y;
            y = y.pai;
        }

        return y;
    }

    // Retorna o nó de valor mínimo a partir de um nó
    private No minimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    // PROCEDIMENTO 4: REMOÇÃO
    // Primeiro busca o nó. Se existir, chama removerNo
    public void remocao(int chave) {
        No no = busca(chave);
        if (no != null) {
            removerNo(no);
        }
    }

    // Remove corretamente um nó da árvore
    private void removerNo(No no) {
        // Caso 1: Nó tem zero ou apenas um filho
        if (no.esquerda == null) {
            transplantar(no, no.direita);
        } else if (no.direita == null) {
            transplantar(no, no.esquerda);
        }
        // Caso 2: Nó tem dois filhos → preciso do sucessor
        else {
            No suc = sucessor(no);

            // Se o sucessor não está logo à direita do nó removido
            if (suc.pai != no) {
                transplantar(suc, suc.direita);
                suc.direita = no.direita;
                suc.direita.pai = suc;
            }

            transplantar(no, suc);
            suc.esquerda = no.esquerda;
            suc.esquerda.pai = suc;
        }
    }

    // Substitui um nó u por um nó v na árvore
    private void transplantar(No u, No v) {
        if (u.pai == null) {
            this.raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }

        if (v != null) {
            v.pai = u.pai;
        }
    }
}

public class L3Q1 {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        // Inserindo elementos na árvore
        arvore.insercao(50);
        arvore.insercao(30);
        arvore.insercao(70);
        arvore.insercao(20);
        arvore.insercao(40);
        arvore.insercao(60);
        arvore.insercao(80);

        // Teste de busca
        No encontrado = arvore.busca(40);

        // Teste de sucessor
        No no30 = arvore.busca(30);
        No suc = arvore.sucessor(no30);

        // Teste de remoção
        arvore.remocao(30);
        arvore.remocao(50);
    }
}
