import java.util.ArrayList;

public class Branch {
    String name;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean newCustomer(String customerName, double initialTransaction){
        Customer newCust = findCustomer(customerName);
        if(newCust == null){
            customers.add(new Customer(customerName,initialTransaction));
            return true;
        }
        return false;

    }

    public boolean addCustomerTransaction(String customerName,double transaction){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(transaction);
            //System.out.println("Customer transaction added");
            return true;
        }
        //System.out.println("Customer transaction not added");
        return false;
    }

    private Customer findCustomer(String customerName){

        for(int i=0; i<customers.size(); i++){
            Customer checkedCustomer = customers.get(i);
            if(checkedCustomer.getName().equals(customerName)){
                //System.out.println("Customer already exists");
                return checkedCustomer;
            }
        }
        //System.out.println("Customer to be created");
        return null;
    }
}
