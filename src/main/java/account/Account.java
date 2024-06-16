package account;

import java.util.ArrayList;
import java.util.List;
public class Account {
        private String accountNumber;
        private String accountHolderName;
        private double balance;
        private List<String> transactions;

        public Account(String accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = 0.0;
            this.transactions = new ArrayList<>();
            transactions.add("Account created for " + accountHolderName + " with Account Number: " + accountNumber);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactions.add("Deposited: " + amount);
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactions.add("Withdrawn: " + amount);
            } else if (amount > balance) {
                transactions.add("Attempted withdrawal of " + amount + " failed due to insufficient funds.");
            }
        }

        public void produceStatement() {
            transactions.add("Current balance: " + balance);
        }

        public String getStatement() {
            StringBuilder statement = new StringBuilder();
            for (String transaction : transactions) {
                statement.append(transaction).append("\n");
            }
            return statement.toString();
        }
    }

