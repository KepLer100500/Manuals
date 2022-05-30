package org.kepler;


interface Library {
    public void getBook();

    public void buyBook(Book book, int cost);

    public String returnBook();

    public void getMagazine();

    public void buyMagazine(String title);

    public int returnMagazine();

    public String putBook();
}
