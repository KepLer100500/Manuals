package org.kepler;


public class UniLibrary implements Library {

    @Override
    public void getBook() {
        App.logger.info("get UniLibrary book.");
    }

    @Override
    public void getMagazine() {
        App.logger.info("get UniLibrary magazine.");
    }

    @Override
    public String returnBook() {
        App.logger.info("return UniLibrary book.");
        return "Ok";
    }

    @Override
    public int returnMagazine() {
        App.logger.info("return UniLibrary magazine.");
        return 1;
    }
    
    @Override
    public void buyBook(Book book, int cost) {
        App.logger.info("buy UniLibrary book. " + book.getName() + ". Cost: " + cost);
    }

    @Override
    public void buyMagazine(String title) {
        App.logger.info("buy UniLibrary magazine. " + title);
    }

    @Override
    public String putBook() {
        return "Put UniLibrary book";
    }
}