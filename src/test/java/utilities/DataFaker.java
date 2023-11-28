package utilities;

import java.util.Date;
import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFaker {

	public static Locale local = new Locale("en");
	public static Faker faker = new Faker(local);

	public static DataFaker getDataHelper() {
		return new DataFaker();
	}

	public static String getFirstName() {
		return faker.address().firstName();
	}

	public static String getLastName() {
		return faker.address().lastName();
	}

	public static String getAddress() {
		return faker.address().fullAddress();
	}

	public static String getCity() {
		return faker.address().city();
	}

	public static String getState() {
		return faker.address().state();
	}

	public static int getPIN() {
		return faker.number().numberBetween(100000, 999999);
	}

	public static String getMobile() {
		return faker.phoneNumber().phoneNumber();
	}

	public static String getEmail() {
		return faker.internet().emailAddress();
	}

	public static String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public static String getPassword() {
		return faker.internet().password(6, 12, true, true);
	}
}
