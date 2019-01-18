import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
	public Employee(int id, int importance, List<Integer> subordinates) {
		super();
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
    
};
	
public class EmployeeImportance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of employees: ");
		int n = scanner.nextInt();
		List<Employee> employees = new ArrayList<Employee>();
		for(int i = 0; i < n; i++) {
			System.out.println("ID for Employee ID "+i+1);
			int id = scanner.nextInt();
			System.out.println("Importance for Employee ID = "+i+1);
			int importance = scanner.nextInt();
			System.out.println("Number of subordinates for Employee ID "+i+1);
			int numOfSub = scanner.nextInt();
			List<Integer> subordinates = new ArrayList<Integer>();
			for(int j = 0; j < numOfSub; j++) {
				subordinates.add(scanner.nextInt());
			}
			employees.add(new Employee(id, importance, subordinates));
		}
		System.out.println("Get importance of ? ");
		int id = scanner.nextInt();
		System.out.println(getImportance(employees, id));
		scanner.close();
	}
	
    public static int getImportance(List<Employee> employees, int id) {
    	HashMap<Integer, Integer> importance = new HashMap<Integer, Integer>(); // id=>importance
        HashMap<Integer, Employee> eachEmployeeMap = new HashMap<Integer, Employee>();
        for(Employee employee: employees) {
            if(!importance.containsKey(employee)) {
                importance.put(employee.id, employee.importance);
            }
            if(!eachEmployeeMap.containsKey(employee.id)) {
                eachEmployeeMap.put(employee.id, employee);
            }
        }
        Queue<Employee> queue = new LinkedList<>();
        
        List<Integer> subordinates = eachEmployeeMap.get(id).subordinates;
        int totalImportance = eachEmployeeMap.get(id).importance;
        for(Integer eachID: subordinates) {
            queue.add(eachEmployeeMap.get(eachID));
        }
        while(!queue.isEmpty()) {
            Employee emp = queue.poll();
            totalImportance += importance.get(emp.id);
            List<Integer> subordinates2 = emp.subordinates;
            for(Integer empID: subordinates2) {
                                   
                queue.add(eachEmployeeMap.get(empID));
            }
        }
        return totalImportance;
    }
 }


