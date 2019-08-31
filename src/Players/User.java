package Players;

public class User {
    int bet;
    int bankBalance;
    UserType type;

    public User(int bet, int bankBalance, UserType type){
        this.bet=bet;
        this.bankBalance=bankBalance;
        this.type=type;
    }

    public int getBet() {
        return bet;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public UserType getType() {
        return type;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "bet=" + bet +
                ", bankBalance=" + bankBalance +
                ", type=" + type +
                '}';
    }
}
