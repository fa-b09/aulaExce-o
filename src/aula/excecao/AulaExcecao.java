
package aula.excecao;

import exceptions.businessExceptions;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;

/**
 *
 * @author User
 */
public class AulaExcecao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Titular: ");
        String holder = sc.nextLine();
        
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        
        System.out.print("Limite de saque: ");
        double whitdrawLimit = sc.nextDouble();
        System.out.println();
        Account acc = new Account(number, holder, balance, whitdrawLimit);
        
        
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();
        
        
        try{
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch(businessExceptions e){
            System.out.print(e.getMessage());
        }
        sc.close();
    }
    
}
