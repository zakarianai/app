package ma.banque.metier;

public interface IBankApis {
    void accountsRetrait(String accountNumber, Double rising, String witchAccount) throws Exception;

    void accountsPayment(String accountNumber, Double rising, String witchAccount);

    void accountsCourantVersement(String accountNumberIssuer, String accountNumberReceiver, Double rising);
}
