package entity;
/*用户银行卡的信息类*/
public class BankCard {
    String userId;
    String cardId;
    float amount;
    String bank;

    public BankCard() {
    }

    public BankCard(String userId, String cardId, float amount, String bank) {
        this.userId = userId;
        this.cardId = cardId;
        this.amount = amount;
        this.bank = bank;
    }

}
