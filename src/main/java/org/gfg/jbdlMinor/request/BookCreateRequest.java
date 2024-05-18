package org.gfg.jbdlMinor.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.gfg.jbdlMinor.model.Author;
import org.gfg.jbdlMinor.model.Book;
import org.gfg.jbdlMinor.model.BookType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequest {
    @NotBlank(message = "Book Name cannot be blank")
    private String name;

    @NotBlank(message = "Book Number cannot be blank")
    private String bookNo;

    @Positive
    private int cost;
    private BookType type;
    private String authorName;
    private String authorEmail;

    public Author toAuthor() {
        return Author.builder().
                name(this.authorName).
                email(this.authorEmail).
                build();
    }

    public Book toBook() {
        return Book.builder().
                name(this.name).
                bookNo(this.bookNo).
                cost(this.cost).
                type(this.type).
                build();
    }
}
