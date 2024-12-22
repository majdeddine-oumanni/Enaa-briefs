public class Book {
    String title, authorName, isbn;
    boolean isAvailable;

    public Book(String title, String authorName, String isbn, boolean isAvailable){
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "title= " + title + "\n" +
                "authorName= " + authorName + "\n" +
                "isbn= " + isbn + "\n" +
                "Availability= " + isAvailable + "\n" ;
    }

}