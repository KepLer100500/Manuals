package behavioral.chain;

/**
 * Chain of Responsibility (Цепочка ответственности) - связываение объектов
 * получателей в цепочку и и передача запроса по ней
 */

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SimpleNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        notifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        notifier.notifierManager("Normal work.", Priority.ROUTINE);
        System.out.println();
        notifier.notifierManager("Solving problems.", Priority.IMPORTANT);
        System.out.println();
        notifier.notifierManager("Ahtung, problems!!!", Priority.ASAP);

    }
}
