package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class utils {

	public static String getName() {
		String name = RandomStringUtils.randomAlphabetic(1);
		return ("Testname"+name);
	}
}
