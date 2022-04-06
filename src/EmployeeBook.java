import java.util.Arrays;

import static java.lang.Double.*;

public class EmployeeBook {

    private final Employee[] employees;

    public EmployeeBook(int i) {
        this.employees = new Employee[i];
    }

    public void addEmpToArr(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[employees.length - 1] != null) {
                System.out.println("База данных о сотрудниках заполнена, пожалуйста создайте новую базу данных");
                break;
            }
            if (employees[i] == null) {
                employees[i] = employee;
                System.out.println("Данные о сотруднике с ID: " + employee.getId() + " успешно добавлены в ячейку базы данных " + i);
                break;
            }
        }

    }

    public void printAllEmpInfo() {
        for (Employee employee :
                employees) {
            if (employee == null) {
                continue;
            }
            if (employee != null) {
                System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getMiddleName() + ", Department: " + employee.getDepartment() + ", Salary: " + employee.getSalary());
            }
        }
    }

    public void printSumSalary() {
        System.out.println("Сумма затрат на зарплаты в месяц " + sumSalary());

    }

    private double sumSalary() {
        double sum = 0.0;
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() != 0) {
                sum = sum + employee.getSalary();
            }
        }
        return Math.round(sum * scale) / scale;
    }

    public void printAverageSumSalary() {
        System.out.printf("Среднее значение зарплат: %.2f\n", sumSalary() / numbersOfPerson(employees));
    }

    public void minSalary() {
        double min = MAX_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                id = employee.getId();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с минимальной зарплатой равной: " + Math.round(min * scale) / scale);
    }

    public void maxSalary() {
        double min = MIN_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > min) {
                min = employee.getSalary();
                id = employee.getId();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с максимальной зарплатой равной: " + Math.round(min * scale) / scale);
    }

    private int numbersOfPerson(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public void printFullName() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                    employee.getMiddleName());
        }
    }

    //Задачи повышенной сложности:
    public void salaryIndexation(double index) {
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            employee.setSalary(Math.round(employee.getSalary() * (1 + index / 100) * scale) / scale);
        }
    }

    public void minSalaryInDep(int department) {
        double min = MAX_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        int dep = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < min && employee.getDepartment() == department) {
                min = employee.getSalary();
                id = employee.getId();
                dep = employee.getDepartment();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с минимальной зарплатой отделе " + dep + ", равной: " + Math.round(min * scale) / scale);
    }

    public void maxSalaryInDep(int department) {
        double min = MIN_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        int dep = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > min && employee.getDepartment() == department) {
                min = employee.getSalary();
                id = employee.getId();
                dep = employee.getDepartment();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с максимальной зарплатой отделе " + dep + ", равной: " + Math.round(min * scale) / scale);
    }

    private double sumInDepSalary(int department) {
        double sum = 0.0;
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() != 0 && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return Math.round(sum * scale) / scale;
    }

    private int numbersOfPersonInDep(Employee[] employees, int dep) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                count++;
            }
        }
        return count;
    }

    public void printSalarySumInDep(int dep) {
        System.out.println("Сумма затрат на зарплату по отделу " + dep + ": " + sumInDepSalary(dep));
    }

    public void printAverageSumOfSalaryInDep(int dep) {
        System.out.printf("Средняя сумма зарплат в отделе %d: %.2f \n", dep, sumInDepSalary(dep) / numbersOfPersonInDep(employees, dep));
    }

    public void salaryIndexationInDep(double index, int dep) {
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == dep) {
                employee.setSalary(Math.round(employee.getSalary() * (1 + index / 100) * scale) / scale);
            }
        }
    }

    public void printAllEmpInfoNotDep() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                    employee.getMiddleName() + ", Salary: " + employee.getSalary());
        }
    }

    public void salarySumInDepBelowNumber(double number) {
        System.out.printf("Сотрудники с зарплатой меньше %.2f:\n", number);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() != 0 && employee.getSalary() < number) {
                System.out.println("ID: " + employee.getId() + ", Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getMiddleName() + ", Salary: " + employee.getSalary());
            }
        }
    }

    public void salarySumInDepMoreNumber(double number) {
        System.out.printf("Сотрудники с зарплатой больше %.2f:\n", number);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() != 0 && employee.getSalary() >= number) {
                System.out.println("ID: " + employee.getId() + ", Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getMiddleName() + ", Salary: " + employee.getSalary());
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getId() == id) {
                employees[i] = null;
            }
        }
    }

    private Employee findEmployee(String lastName, String firstName, String middleName) {
        for (Employee employee : employees) {
            if (employee != null
                    && employee.getLastName().equalsIgnoreCase(lastName)
                    && employee.getFirstName().equalsIgnoreCase(firstName)
                    && employee.getMiddleName().equalsIgnoreCase(middleName)) {
                return employee;
            }
        }
        return null;
    }

    public void findAndSetSalary(String lastName, String firstName, String middleName, double newSalary) {
        Employee employee = findEmployee(lastName, firstName, middleName);
        if (employee != null) {
            employee.setSalary(newSalary);
        }
    }

    public void findAndSetDep(String lastName, String firstName, String middleName, int newDep) {
        Employee employee = findEmployee(lastName, firstName, middleName);
        if (employee != null) {
            employee.setDepartment(newDep);
        }
    }

    public void printDepAndFullName() {
        int[] dep = new int[numbersOfPerson(employees)];
        int skip = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                skip++;
                continue;
            } else if (employees[i] != null) {
                Employee employee = employees[i];
                dep[i - skip] = employee.getDepartment();
            }
        }
        Arrays.sort(dep);
        System.out.println(Arrays.toString(dep));
        for (int i = 0; i < dep.length; i++) {
            if (i == i + 1) {
                continue;
            }
            System.out.printf("Сотрудники отдела %d:\n", dep[i]);
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == dep[i]) {
                    System.out.printf("%s %s %s\n", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
                }
            }
        }
    }
}
