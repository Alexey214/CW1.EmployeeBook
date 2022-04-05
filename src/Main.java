import static java.lang.Double.*;

public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 50000.01);
        Employee employee2 = new Employee("Petrov", "Petr", "Petrovich", 2, 60000.2);
        Employee employee3 = new Employee("Sidorov", "Ivan", "Petrovich", 3, 70000.3);
        Employee employee4 = new Employee("Popov", "Aleksandr", "Vladimirovich", 1, 80000.04);
        Employee employee5 = new Employee("Smirnof", "Andrey", "Nikitich", 1, 90000.55);

        addEmpToArr(employee1);
        addEmpToArr(employee2);
        addEmpToArr(employee3);
        addEmpToArr(employee4);
        addEmpToArr(employee5);
        //a:
        printAllEmpInfo();  //Не совсем понял нужно ли было переопределить toString,
                            // или просто вывести все. Решил просто сделать вывод всей информации.
                            //В случае с использованием toString был бы тот же самый код, но с комментарием и в классе Employee.
        //b:
        printSumSalary();
        //c:
        minSalary();
        //d:
        maxSalary();
        //e:
        printAverageSumSalary();
        //f:
        printFullName();

        //Задачи повышенной сложности:
        System.out.println("\nЗадачи повышенной сложности:");
        //1:
        salaryIndexation(8);
        printAllEmpInfo();
        //2:
        //a:
        minSalaryInDep(1);
        //b:
        maxSalaryInDep(1);
        //c:
        printSalarySumInDep(1);
        //d:
        printAverageSumOfSalaryInDep(1);
        //e:
        salaryIndexationInDep(7, 1);
        printAllEmpInfo();
        //f:
        printAllEmpInfoNotDep();
        //3:
        //a:
        salarySumInDepBelowNumber(60000);
        //b:
        salarySumInDepMoreNumber(60000);
    }

    //Задачи базовой сложности:
    public static void addEmpToArr(Employee employee) {
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

    public static void printAllEmpInfo() {
        for (Employee employee :
                employees) {
            if (employee == null) {
                break;
            }
            System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                    employee.getMiddleName() + ", Department: " + employee.getDepartment() + ", Salary: " + employee.getSalary());
        }
    }

    public static void printSumSalary() {
        System.out.println("Сумма затрат на зарплаты в месяц " + sumSalary());

    }

    public static double sumSalary() {
        double sum = 0.0;
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() != 0) {
                sum = sum + employee.getSalary();
            }
        }
        return Math.round(sum * scale) / scale;
    }

    public static void printAverageSumSalary() {
        System.out.printf("Среднее значение зарплат: %.2f\n", sumSalary() / numbersOfPerson(employees));
    }

    public static void minSalary() {
        double min = MAX_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                id = employee.getId();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с минимальной зарплатой равной: " + Math.round(min * scale) / scale);
    }

    public static void maxSalary() {
        double min = MIN_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() > min) {
                min = employee.getSalary();
                id = employee.getId();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с максимальной зарплатой равной: " + Math.round(min * scale) / scale);
    }

    public static int numbersOfPerson(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static void printFullName() {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                    employee.getMiddleName());
        }
    }

    //Задачи повышенной сложности:
    public static void salaryIndexation(double index) {
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            employee.setSalary(Math.round(employee.getSalary() * (1 + index / 100) * scale) / scale);
        }
    }

    public static void minSalaryInDep(int department) {
        double min = MAX_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        int dep = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < min && employee.getDepartment() == department) {
                min = employee.getSalary();
                id = employee.getId();
                dep = employee.getDepartment();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с минимальной зарплатой отделе " + dep + ", равной: " + Math.round(min * scale) / scale);
    }

    public static void maxSalaryInDep(int department) {
        double min = MIN_VALUE;
        double scale = Math.pow(10, 2);
        int id = -1;
        int dep = -1;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() > min && employee.getDepartment() == department) {
                min = employee.getSalary();
                id = employee.getId();
                dep = employee.getDepartment();
            }
        }
        System.out.println("Сотрудник (ID:" + id + ") с максимальной зарплатой отделе " + dep + ", равной: " + Math.round(min * scale) / scale);
    }

    public static double sumInDepSalary(int department) {
        double sum = 0.0;
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() != 0 && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return Math.round(sum * scale) / scale;
    }

    public static int numbersOfPersonInDep(Employee[] employees, int dep) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                count++;
            }
        }
        return count;
    }

    public static void printSalarySumInDep(int dep) {
        System.out.println("Сумма затрат на зарплату по отделу " + dep + ": " + sumInDepSalary(dep));
    }

    public static void printAverageSumOfSalaryInDep(int dep) {
        System.out.printf("Средняя сумма зарплат в отделе %d: %.2f \n", dep, sumInDepSalary(dep) / numbersOfPersonInDep(employees, dep));
    }

    public static void salaryIndexationInDep(double index, int dep) {
        double scale = Math.pow(10, 2);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == dep) {
                employee.setSalary(Math.round(employee.getSalary() * (1 + index / 100) * scale) / scale);
            }
        }
    }

    public static void printAllEmpInfoNotDep() {
        for (Employee employee :
                employees) {
            if (employee == null) {
                break;
            }
            System.out.println("Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                    employee.getMiddleName() + ", Salary: " + employee.getSalary());
        }
    }

    public static void salarySumInDepBelowNumber( double number) {
        System.out.printf("Сотрудники с зарплатой меньше %.2f:\n", number);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() != 0 && employee.getSalary()<number) {
                System.out.println("ID: "+ employee.getId() + ", Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getMiddleName() + ", Salary: " + employee.getSalary());
            }
        }
    }

    public static void salarySumInDepMoreNumber(double number) {
        System.out.printf("Сотрудники с зарплатой больше %.2f:\n", number);
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() != 0 && employee.getSalary()>=number) {
                System.out.println("ID: "+ employee.getId() + ", Full name: " + employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getMiddleName() + ", Salary: " + employee.getSalary());
            }
        }
    }


}