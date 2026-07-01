interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Email Sent");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        notifier.send();
        System.out.println("SMS Sent");
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier n = new SMSNotifierDecorator(new EmailNotifier());
        n.send();
    }
}
