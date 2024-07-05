package InstabugTests;

public class UsersConfig {
	
	enum UsernameIndex
	{
		StandardUserIndex(0),
		LockedUserIndex(1),
		ProblemUserIndex(2),
		PerformanceGlitchUserIndex(3),
		ErrorUserIndex(4),
		VisualUserIndex(5);
		
		private int numVal;

		UsernameIndex(int numVal) {
		 this.numVal = numVal;
		}

		public int getNumVal() {
		  return numVal;
		}
	}
	static String WebsiteURL = "https://www.saucedemo.com/";
	static String SuccessfulLoginURL = "https://www.saucedemo.com/inventory.html";
	static int AcceptedLoginTime = 1; //s
	static int AcceptedLogoutTime = 1; //s
}
