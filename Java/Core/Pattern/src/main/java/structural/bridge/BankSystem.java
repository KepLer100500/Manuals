package structural.bridge;


public class BankSystem extends Program {
    protected BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank System develop in progress...");
        developer.writeCode();
    }
}