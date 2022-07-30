package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = input.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = input.nextLine();
		System.out.print("Level: ");
		String workerLevel = input.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = input.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println();
		System.out.print("How many contracts to this worker?: ");
		int qtdContracts = input.nextInt();
		
		for (int i = 1; i <= qtdContracts; i++) {
			System.out.println();
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(input.next());
			System.out.print("Value per hour: ");
			double valuePerHour = input.nextDouble();
			System.out.print("Duration (hours): ");
			int qtdHours = input.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, qtdHours);
			worker.addContract(contract);
		}
		input.nextLine();
		System.out.println();
		System.out.print("Enter month and year to calculate income (mm/yyyy): ");
		String monthAndYear = input.nextLine();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": US$ " + worker.income(month, year));

		
	}

}
