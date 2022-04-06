import static java.lang.Double.*;

public class Main {

//    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 50000.01);
        Employee employee2 = new Employee("Petrov", "Petr", "Petrovich", 2, 60000.2);
        Employee employee3 = new Employee("Sidorov", "Ivan", "Petrovich", 3, 70000.3);
        Employee employee4 = new Employee("Popov", "Aleksandr", "Vladimirovich", 1, 80000.04);
        Employee employee5 = new Employee("Smirnof", "Andrey", "Nikitich", 1, 90000.55);

        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmpToArr(employee1);
        employeeBook.addEmpToArr(employee2);
        employeeBook.addEmpToArr(employee3);
        employeeBook.addEmpToArr(employee4);
        employeeBook.addEmpToArr(employee5);


        //a:
        employeeBook.printAllEmpInfo();  //Не совсем понял нужно ли было переопределить toString,
        // или просто вывести все. Решил просто сделать вывод всей информации.
        //В случае с использованием toString был бы тот же самый код, но с комментарием и в классе Employee.
        //b:
        employeeBook.printSumSalary();
        //c:
        employeeBook.minSalary();
        //d:
        employeeBook.maxSalary();
        //e:
        employeeBook.printAverageSumSalary();
        //f:
        employeeBook.printFullName();

        //Задачи повышенной сложности:
        System.out.println("\nЗадачи повышенной сложности:");
        //1:
        employeeBook.salaryIndexation(8);
        employeeBook.printAllEmpInfo();
        //2:
        //a:
        employeeBook.minSalaryInDep(1);
        //b:
        employeeBook.maxSalaryInDep(1);
        //c:
        employeeBook.printSalarySumInDep(1);
        //d:
        employeeBook.printAverageSumOfSalaryInDep(1);
        //e:
        employeeBook.salaryIndexationInDep(7, 1);
        employeeBook.printAllEmpInfo();
        //f:
        employeeBook.printAllEmpInfoNotDep();
        //3:
        //a:
        employeeBook.salarySumInDepBelowNumber(60000);
        //b:
        employeeBook.salarySumInDepMoreNumber(60000);
        //4:
        //a: вначале кода добавляю методом addEmpToArr() сотрудников.
        //b:
        employeeBook.deleteEmployee(3);
        //5:
        //a:
        employeeBook.findAndSetSalary("Ivanov", "Ivan", "Ivanovich", 100100.95);
        //b:
        employeeBook.findAndSetDep("Ivanov", "Ivan", "Ivanovich", 5);
        employeeBook.printAllEmpInfo();
        //6:
        employeeBook.printDepAndFullName();
    }


}