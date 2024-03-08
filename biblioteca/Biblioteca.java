package biblioteca;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Biblioteca {

    private Map<Livro, Boolean> livros;

    public Biblioteca(Collection<Livro> livros) {
        this.livros = livros.stream().collect(Collectors.toMap(
                l -> l,
                l -> false
        ));
    }

    public Biblioteca() {
        this.livros = new HashMap<>();
    }

    public Set<Livro> getLivro() {
        return this.livros.keySet();
    }

    public Boolean cadastrarLivro(Livro livro) {
        return this.livros.put(livro, false);
    }

    public Boolean removerLivro(Livro livro) {
        return this.livros.remove(livro);
    }

    public boolean estaEmprestado(Livro livro) {
        return this.livros.get(livro);
    }

    public void emprestar(Livro livro) {
        if (!this.livros.get(livro)) {
            this.livros.put(livro, true);
            System.out.println("biblioteca.Livro emprestado com sucesso!");
        } else {
            System.out.println("biblioteca.Livro já emprestado!");
        }
    }

    public void devolver(Livro livro) {
        if (this.livros.get(livro)) {
            this.livros.put(livro, false);
            System.out.println("biblioteca.Livro devolvido com sucesso!");
        } else {
            System.out.println("biblioteca.Livro já está na biblioteca!");
        }
    }

    public class LivroControler {

        private Livro livro;

        public LivroControler(Livro livro) {
            if (!Biblioteca.this.livros.containsKey(livro)) {
                throw new IllegalArgumentException("O livro não existe!");
            }
            this.livro = livro;
        }

        public void emprestar() {
            Biblioteca.this.emprestar(this.livro);
        }

        public void devolver() {
            Biblioteca.this.devolver(this.livro);
        }

    }

}
