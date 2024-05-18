import java.util.ArrayList;

public class Customer {
    String name;
    ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, Double initialTransactions){
        this.name = name;
        transactions.add(initialTransactions);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }

    public void addTransaction(double transaction){
        transactions.add(transaction);

    }
}
