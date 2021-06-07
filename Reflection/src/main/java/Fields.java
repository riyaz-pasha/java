import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Employee {
    public String name;
    public int age;
    private Double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class Fields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee emp1 = new Employee();
        Class empClassObj = emp1.getClass();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Employee details before");
        System.out.println(emp1.toString());

        System.out.println("-------------------------------------------------------------------");
        // Shows only public fields
        for (Field field : empClassObj.getFields()) {
            System.out.println("Field Name " + field.getName());
            System.out.println("Field Type " + field.getType());
            System.out.println("Field Modifier " + Modifier.toString(field.getModifiers()));
        }

        System.out.println("-------------------------------------------------------------------");
        // Shows all fields
        for (Field field : empClassObj.getDeclaredFields()) {
            System.out.println("Field Name " + field.getName());
            System.out.println("Field Type " + field.getType());
            System.out.println("Field Modifier " + Modifier.toString(field.getModifiers()));
        }

        System.out.println("-------------------------------------------------------------------");

        Field empName = empClassObj.getField("name");
        System.out.println("Employee Name - " + empName.get(emp1)); // return null

        empName.set(emp1, "Riyaz");
        System.out.println("Employee Name after setting - " + empName.get(emp1)); // return Riyaz

        System.out.println("-------------------------------------------------------------------");
        // Accessing private field
        Field empSalary = empClassObj.getDeclaredField("salary");
        empSalary.setAccessible(true);
        System.out.println("Employee Salary - " + empSalary.get(emp1)); // return null


        Double amount = Double.valueOf(1000);
        empSalary.set(emp1, amount);
        System.out.println("Employee Salary after setting - " + empSalary.get(emp1)); // return 100

        System.out.println("-------------------------------------------------------------------");
        Field empAge = empClassObj.getDeclaredField("age");
        empAge.setInt(emp1, 21);
        System.out.println("Employee Salary after setting - " + empAge.get(emp1)); // return 21

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Employee details after");
        System.out.println(emp1.toString());
    }
}
