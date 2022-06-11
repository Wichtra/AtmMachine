package AtmMachine;

public class Account extends  DataBase{

    int balance;

    Account(String Username, int Pin,int balance){
        DataBase.Username =Username;
        DataBase.Pin =Pin;
        this.balance = balance;
    }
    public void setUsername(String username){
        Username= username;
    }
    public void setPassword(int Pin){
        DataBase.Pin = Pin;
    }

    public void setbalance(int balance){
        this.balance=balance;
    }
    public int getbalance(){
        return balance;
    }
    public void tranferbalance(int tranfer){
        this.balance -= tranfer;
    }
    public void setPin(int Piin){
        Pin = Piin;
    }
    public int getPin(){
        return Pin;
    }
}

