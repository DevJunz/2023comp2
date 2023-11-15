package Data;

import java.util.Random;

public class UserInfo {
	private String Name;
	private int Password; 
	private int C_ID;
	private static int count = 0;
	public UserInfo(String name,int password) {
		Name = name;
		Password = password;
		C_ID = count++;
	}
}
