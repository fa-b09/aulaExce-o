
package model.entities;

import exceptions.businessExceptions;

/**
 *
 * @author User
 */
public class Account {
     private Integer number;
    private String holder;
    private Double balance;
    private Double WithdrawLimit;
    
    public  Account(){
        
    }

    public Account(Integer number, String holder, Double balance, Double WithdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.WithdrawLimit = WithdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return WithdrawLimit;
    }

    public void setWithdrawLimit(Double WithdrawLimit) {
        this.WithdrawLimit = WithdrawLimit;
    }
    
    public void deposit(Double amount){
        this.balance+=amount;
    }
    public void withdraw(Double amount){
        validateWithdraw(amount);
        this.balance-=amount;
    }
    
    private void validateWithdraw(double amount){
        if(amount > getWithdrawLimit()){
            throw  new businessExceptions ("Erro de saque: A quantia excede o limite de saue");
            
        }
        if(amount > getBalance()){
           throw new businessExceptions("Erro de saque: Saldo insuficiente");
            
        }
        
    }
}
