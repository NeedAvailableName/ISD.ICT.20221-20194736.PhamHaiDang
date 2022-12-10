import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

public class validateDeliveryInfo {
	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"0123456789, true",
		"01234, false",
		"abc123, false",
		"1234567890, false"
	})
	@Test
	public void testValidatePhoneNumber(String phone, boolean expected) {
		boolean isValided = placeOrderController.validatePhoneNumber(phone);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"dang pham, true",
		"dang_pham, false",
		"abc123, false",
		"!dangpham, false"
	})
	@Test
	public void testValidateName(String name, boolean expected) {
		boolean isValided = placeOrderController.validateName(name);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1 dai co viet, true",
		"tran_duy_hung, false",
		"abc123@, false",
		" , false"
	})
	@Test
	public void testValidateAddress(String address, boolean expected) {
		boolean isValided = placeOrderController.validateAddress(address);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"dai co viet, true",
		"tran_duy_hung, false",
		"abc123@, false",
		" , false"
	})
	@Test
	public void testValidateHolderName(String holderName, boolean expected) {
		boolean isValided = placeOrderController.validateHolderName(holderName);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1 dai co viet, true",
		"tran_duy_hung, false",
		"abc123@, false",
		" , false"
	})
	@Test
	public void testValidateCardNumber(String cardNumber, boolean expected) {
		boolean isValided = placeOrderController.validateCardNumber(cardNumber);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1/12/2022, true",
		"tran_duy_hung, false",
		"abc123@, false",
		" , false"
	})
	@Test
	public void testValidateExpirationDate(String date, boolean expected) {
		boolean isValided = placeOrderController.validateExpirationDate(date);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"123, true",
		"tran_duy_hung, false",
		"abc123@, false",
		" , false"
	})
	@Test
	public void testValidateSecurityCode(String securityCode, boolean expected) {
		boolean isValided = placeOrderController.validateSecurityCode(securityCode);
		assertEquals(expected, isValided);
	}
}
