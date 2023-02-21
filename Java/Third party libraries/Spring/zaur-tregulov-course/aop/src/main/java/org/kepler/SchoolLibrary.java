package org.kepler;


public class SchoolLibrary implements Library {

    @Override
    public void getBook() {
        App.logger.info("get SchoolLibrary book.");
    }

    @Override
    public void getMagazine() {
        App.logger.info("get SchoolLibrary magazine.");
    }

    @Override
    public String returnBook() {
        App.logger.info("return SchoolLibrary book.");
        return "Ok";
    }

    @Override
    public int returnMagazine() {
        App.logger.info("return SchoolLibrary magazine.");
        return 1;
    }

    @Override
    public void buyBook(Book book, int cost) {
        App.logger.info("buy SchoolLibrary book. " + book.getName() + ". Cost: " + cost);
    }

    @Override
    public void buyMagazine(String title) {
        App.logger.info("buy SchoolLibrary magazine. " + title);
    }

    @Override
    public String putBook() {
        return "Put SchoolLibrary book";
    }
}