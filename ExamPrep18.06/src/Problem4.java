import java.util.Scanner;
import java.util.TreeMap;


public class Problem4 {

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
			
			if (!users.containsKey(user)) {//If the user does not exist
				users.put(user, new TreeMap<>());
				users.get(user).put(ip, minutes);
			}else if (users.get(user).containsKey(ip)) {//If the IP already exists
				int tempMinutes = users.get(user).get(ip);
				users.get(user).put(ip, tempMinutes+minutes);
			}else{//If a user exists but the IP doesn't have a record
				users.get(user).put(ip, minutes);
			}
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
