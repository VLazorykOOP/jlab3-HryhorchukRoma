import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть завдання: ");
        int task = scanner.nextInt();

        if (task == 1) {
            Employee[] employees = {
                    new Worker("John Doe", 1001, 50000, "Factory Worker"),
                    new HR("Alice Smith", 2002, 60000, "Human Resources"),
                    new Engineer("Bob Johnson", 3003, 70000, "Software Engineer", "Software Development"),
                    new Administration("Eva Brown", 4004, 55000, "Office Administrator")
            };

            for (Employee employee : employees) {
                employee.show();
                System.out.println();
            }
        } else if (task == 2) {
            Currency[] currencies = {
                    new Dollar(50),
                    new Euro(40)
            };

            for (Currency currency : currencies) {
                System.out.println("Original: " + currency);
                System.out.println("Converted to UAH: " + currency.convertToUah());
                currency.display();
                System.out.println();
            }
        }
    }

    abstract static class Employee {
        private String name;
        private int employeeId;
        private double salary;

        public Employee(String name, int employeeId, double salary) {
            this.name = name;
            this.employeeId = employeeId;
            this.salary = salary;
        }

        public void show() {
            System.out.println("Name: " + name + ", Employee ID: " + employeeId + ", Salary: " + salary);
        }
    }

    static class Worker extends Employee {
        private String jobTitle;

        public Worker(String name, int employeeId, double salary, String jobTitle) {
            super(name, employeeId, salary);
            this.jobTitle = jobTitle;
        }

        @Override
        public void show() {
            super.show();
            System.out.println("Job Title: " + jobTitle);
        }
    }

    static class HR extends Employee {
        private String department;

        public HR(String name, int employeeId, double salary, String department) {
            super(name, employeeId, salary);
            this.department = department;
        }

        @Override
        public void show() {
            super.show();
            System.out.println("Department: " + department);
        }
    }

    static class Engineer extends Worker {
        private String engineeringField;

        public Engineer(String name, int employeeId, double salary, String jobTitle, String engineeringField) {
            super(name, employeeId, salary, jobTitle);
            this.engineeringField = engineeringField;
        }

        @Override
        public void show() {
            super.show();
            System.out.println("Engineering Field: " + engineeringField);
        }
    }

    static class Administration extends Employee {
        private String role;

        public Administration(String name, int employeeId, double salary, String role) {
            super(name, employeeId, salary);
            this.role = role;
        }

        @Override
        public void show() {
            super.show();
            System.out.println("Role: " + role);
        }
    }

    abstract static class Currency {
        private double amount;

        public Currency(double amount) {
            this.amount = amount;
        }

        public abstract double convertToUah();

        public abstract void display();

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Amount: " + amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Currency currency = (Currency) o;
            return Double.compare(currency.amount, amount) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount);
        }
    }

    static class Dollar extends Currency {
        public Dollar(double amount) {
            super(amount);
        }

        @Override
        public double convertToUah() {
            return getAmount() * 37;
        }

        @Override
        public void display() {
            System.out.println("Dollar amount: $" + getAmount());
        }

        @Override
        public String toString() {
            return super.toString() + " (Dollar)";
        }
    }

    static class Euro extends Currency {
        public Euro(double amount) {
            super(amount);
        }

        @Override
        public double convertToUah() {
            return getAmount() * 40;
        }

        @Override
        public void display() {
            System.out.println("Euro amount: €" + getAmount());
        }

        @Override
        public String toString() {
            return super.toString() + " (Euro)";
        }
    }
}
