import java.util.Scanner;
import java.util.TreeMap;


public class Problem4_2 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.nextLine());
		
		TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] userInput = scan.nextLine().split(" ");
			
			String ip = userInput[0];
			String user = userInput[1];
			int minutes = Integer.parseInt(userInput[2]);
			
			if (!users.containsKey(user)) {
				users.put(user, new TreeMap<>());				
			}
			
			TreeMap<String, Integer> sessions = users.get(user);
			int newMinutes = 0;
			if (sessions.containsKey(ip)) {
				newMinutes = sessions.get(ip);
			}
			sessions.put(ip, newMinutes + minutes);
		}
		
		for (String user : users.keySet()) {
			System.out.print(user+": ");
			int totalMinutes = 0;
			
			for (String ip : users.get(user).keySet()) {
				totalMinutes += users.get(user).get(ip);
			}
			
			System.out.print(totalMinutes+" ");
			System.out.print(users.get(user).keySet());
			System.out.println();
			
		}
	}

}
