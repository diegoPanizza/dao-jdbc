package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===TEST 1: Department findById===");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("===\nTEST 2: Department findAll===");
		List<Department> list = depDao.findAll();
		for (Department obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("===\nTEST 3: Department insert===");
		Department newDepartment = new Department(null, "Music");
		depDao.insert(newDepartment); 
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("===\nTEST 4: Department update===");
		Department dept = depDao.findById(1);
		dept.setName("Food");
		depDao.update(dept);
		System.out.println("Update Completed!");
		
		System.out.println("===\nTEST 5: Department delete===");
		System.out.print("Type the id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		sc.close();
	}
}
