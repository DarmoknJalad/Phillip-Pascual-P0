import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.phillippascual.data.UserData;
import com.phillippascual.util.User;

public class UserDataTest {
	User testUser;
	
	@Before
	public void setup() {
		testUser = new User("test", "test", true);
	}
	
	@Test
	public void addUserTest_ArrayListIncrease() {
		
		UserData.addUser(testUser);
		assertTrue(UserData.getUsers().size() == 1);
	}
	
	public void validateLoginTest_returnsTrue() {
		assertTrue(UserData.validateLogin("test", "test"));
	}
}
