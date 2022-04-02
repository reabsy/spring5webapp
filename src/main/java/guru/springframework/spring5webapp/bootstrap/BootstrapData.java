package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher bla = new Publisher("Bla", "blub", "Hamburg", "20000");
        publisherRepository.save(bla);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(bla);
        bla.getBook().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(bla);


        Author michal = new Author("Michael", "Ende");
        Book jim = new Book("Jim Knopf und Lukas der Lokomotivführer", "321");
        michal.getBooks().add(jim);
        jim.getAuthors().add(michal);
        jim.setPublisher(bla);
        bla.getBook().add(jim);

        authorRepository.save(michal);
        bookRepository.save(jim);
        publisherRepository.save(bla);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Number of Publishers " + publisherRepository.count());

     }
}
