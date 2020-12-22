import java.util.Scanner;

//creating program class
public class Lab4 {
	
	//creating main method
	public static void main(String[] args) {
		
		//creating scanner object
		Scanner input = new Scanner(System.in);
		
		//displaying program title
		System.out.println("*****Company Payroll Calculator*****");
		
		//creating instance variables
		double hoursWorked;
		double payRate;
		double basePay;
		double overtimeHours;
		double overtimePay;
		double grossPay;
		double taxDeducted;
		double netPay;
		
		int totalEmployee=0;
		double totalOvertime=0;
		double totalOvrtPay=0;
		double totalTax=0;
		double totalPayroll=0;
		
		
		int employee = 1;
		int initial = 0;
		
		//while statement for all user inputs other than -1
		while (initial !=-1) {
			
		//prompting user for number of hours worked and rate of pay for each employee
		System.out.print("\nEnter hours worked for employee " +employee+ ":");
		hoursWorked = input.nextDouble();
		
		
		System.out.print("Enter rate of pay for employee "  +employee+ ":");
		payRate = input.nextDouble();
		
		//displaying employee base pay, overtime pay, gross pay, net pay and tax deduction
		System.out.println("\nEmployee " +employee+ " pay information: ");
		
		//calculating base pay and overtime pay
		if(hoursWorked > 37.5) {
			basePay = 37.5 * payRate;
			overtimeHours = hoursWorked - 37.5;
			overtimePay = overtimeHours * payRate * 1.5;
			
		}else{
			basePay = hoursWorked * payRate;
			overtimeHours = 0;
			overtimePay = 0;
		}
		
		//calculating gross pay
		grossPay = basePay + overtimePay;
		
		//calculating tax deduction
		if(grossPay < 1000) {
			taxDeducted = 0;
			
		}else if(grossPay <= 2000) {
			taxDeducted = grossPay * 0.20;
			
		}else{
		taxDeducted = grossPay * 0.30;
		
		}
		
		//calculating net pay
		netPay = grossPay - taxDeducted;
		
		
		System.out.printf("Base pay: %.2f$\n", (basePay));
		System.out.printf("Overtime pay: %.2f$\n", (overtimePay));
		System.out.printf("Tax deducted: %.2f\n", (taxDeducted));
		System.out.printf("Gross pay: %.2f$\n", (grossPay));
		System.out.printf("Net pay: %.2f\n", (netPay));
		
		//using incrementer to calculate total employees and compounder to add total payroll info
		totalEmployee = employee++;	
		totalOvertime += overtimeHours;
		totalOvrtPay += overtimePay;
		totalTax += taxDeducted;
		totalPayroll += netPay;
	
		//prompting to continue or finish entering employee data
		System.out.print("\nDo you have more employee wages to calculate?");
		System.out.print("\nType -1 to quit or any other key to continue: ");
		initial = input.nextInt();
		}
		
		//displaying company payroll info(total employees,total OT, total OT pay, total tax, total payroll)
		System.out.printf("\ntotal employees: %d \n", (totalEmployee));
		
		System.out.printf("total overtime hours worked: %.2f \n", (totalOvertime));
		
		System.out.printf("total overtime paid: $%.2f \n", (totalOvrtPay));
		
		System.out.printf("total tax deducted: $%.2f \n", (totalTax));
		
		System.out.printf("total payroll: $%.2f", (totalPayroll));	
		
		input.close();
	}//end of main method
	
}//end of class