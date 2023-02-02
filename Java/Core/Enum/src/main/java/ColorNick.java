enum ColorNick {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private final String color;

    ColorNick(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
