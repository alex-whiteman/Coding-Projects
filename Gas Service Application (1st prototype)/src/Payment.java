import java.util.Scanner;

// Use constructor
public class Payment
{
    String cardType;
    String debitOrCredit;
    int cardNumber;
    int cardExpirationMonth;
    int cardExpirationYear;
    Integer cardCVV;

    public Payment() {
    }

    public void setPaymentInfo() {
        Scanner in = new Scanner(System.in);

            System.out.println("Please enter what type of card you have: ");
            cardType = in.nextLine();
            System.out.println("Please specify whether your card is debit or credit: ");
            debitOrCredit = in.nextLine();
            System.out.println("Please enter your card number: ");
            cardNumber = in.nextInt();
            System.out.println("Please enter the expiration month followed by year: ");
            cardExpirationMonth = in.nextInt();
            cardExpirationYear = in.nextInt();
            System.out.println("Please enter the CCV number on the back of your card: ");
            cardCVV = in.nextInt();
    }

    public String getCardType() {
        String cardType = this.cardType; // Hook up to database
        return cardType;
    }

    public String getDebitOrCredit() {
        String debitOrCredit = this.debitOrCredit; // Hook up to database
        return debitOrCredit;
    }

    public int getCardNumber() {
        int cardNubmer = this.cardNumber; // Hook up to database
        return cardNubmer;
    }

    public int getCardExpirationMonth() {
        int cardExpirationMonth = this.cardExpirationMonth; // Hook up to database
        return cardExpirationMonth;
    }

    public int getCardExpirationYear() {
        int cardExpirationYear = this.cardExpirationYear; // Hook up to database
        return cardExpirationYear;
    }

    public int getCardCVV() {
        int cardCVV = this.cardCVV; // Hook up to database;
        return cardCVV;
    }
}

