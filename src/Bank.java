import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public Bank(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", branches=" + branches +
                '}';
    }

    public boolean addBranch(String branchName){//branchName
        Branch newBranch = findBranch(branchName);
        if(newBranch == null){
            branches.add(new Branch(branchName));
            System.out.println("Branch added: " + branchName);
            return true;
        }

        System.out.println("Branch exists already");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch newBranch = findBranch(branchName);
        if(newBranch != null){
            newBranch.newCustomer(customerName,initialTransaction);
            System.out.println("New customer added");
            return true;
        }
        System.out.println("New customer not added");
        return false;
    }

    public boolean addCustomerTransaction(String branchName,String customerName, double transaction){
        Branch newBranch = findBranch(branchName);
        if(newBranch != null){
            newBranch.addCustomerTransaction(customerName,transaction);
            System.out.println("Customer transaction added");
            return true;
        }
        System.out.println("Customer transaction not added");
        return false;
    }

    private Branch findBranch(String branchName){

        for(int i=0; i<branches.size(); i++){
            Branch checkedBranch = branches.get(i);
            if(checkedBranch.getName().equals(branchName)){
                System.out.println("Branch already exists");
                return checkedBranch;
            }
        }
        System.out.println("Branch to be created");
        return null;
    }

    public boolean listCustomers(String branchName,boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }



}
