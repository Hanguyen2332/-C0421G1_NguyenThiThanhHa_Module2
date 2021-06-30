package furamaResort.services;

public interface EmployeeService extends Service {

    void addNew();

    void edit();

    String checkInputProperty(String[] arr);
}
