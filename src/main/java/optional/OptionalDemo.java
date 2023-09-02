package optional;

import lambda.Author;
import lambda.Book;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Author> author = getAuthor();
        if (!author.isPresent()) {
            System.out.println("异常");
        }

        Optional<List<Book>> books = author.map(Author::getBookList);
        books.ifPresent(System.out::println);
    }
    
    public static Optional<Author> getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }
}
