package biblioteca;

public class Program {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        biblioteca.cadastrarLivro(livro);

        biblioteca.emprestar(livro);
        biblioteca.devolver(livro);
    }

//    A classe biblioteca.Livro está sobrecarregada com várias responsabilidades,
//    como armazenar informações sobre o livro,
//    gerenciar o status de empréstimo e realizar operações de empréstimo e devolução.
//    Refatore aplicando o principio de responsabilidade unica e
//    adicione uma biblioteca.Biblioteca  responsável por gerenciar os livros


}
