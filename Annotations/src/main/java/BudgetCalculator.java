import java.lang.reflect.Method;
import java.util.Scanner;

public class BudgetCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(input.nextLine());

        while (noOfTestCases > 0) {
            String role = input.next();
            int spend = input.nextInt();
            try {
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = method.getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if (spend <= budgetLimit) {
                                method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
                            } else {
                                System.out.println("Budget Limit Over");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            noOfTestCases--;
        }
    }
}
