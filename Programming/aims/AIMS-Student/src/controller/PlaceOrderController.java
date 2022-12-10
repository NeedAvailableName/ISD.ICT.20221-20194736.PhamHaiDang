package controller;
import java.util.regex.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import entity.cart.Cart;
import entity.cart.CartMedia;
import common.exception.InvalidDeliveryInfoException;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import views.screen.popup.PopupScreen;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */
public class PlaceOrderController extends BaseController{

    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the avalibility of product when user click PlaceOrder button
     * @throws SQLException
     */
    public void placeOrder() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    public Order createOrder() throws SQLException{
        Order order = new Order();
        for (Object object : Cart.getCart().getListMedia()) {
            CartMedia cartMedia = (CartMedia) object;
            OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(), 
                                                   cartMedia.getQuantity(), 
                                                   cartMedia.getPrice());    
            order.getlstOrderMedia().add(orderMedia);
        }
        return order;
    }

    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException{
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
    }
    
    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
    	
    }
    
    public boolean validatePhoneNumber(String phoneNumber) {
    	// TODO: your work
    	if(phoneNumber.length() != 10) return false;
    	if(!phoneNumber.startsWith("0")) return false;
    	try {
    		Integer.parseInt(phoneNumber);
    	}
    	catch(NumberFormatException e) {
    		return false;
    	}
    	return true;
    }
    
    public boolean validateName(String name) {
    	// TODO: your work
    	String regex = "^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$";
    	Pattern p = Pattern.compile(regex);
    	if(name == null) return false;
    	Matcher m = p.matcher(name);
    	if(!m.matches()) return false;
    	return true;
    }
    
    public boolean validateAddress(String address) {
    	// TODO: your work
    	String regex = "^[A-Za-z0-9\\s]{1,}[A-Za-z0-9\\s]{0,}$";
    	Pattern p = Pattern.compile(regex);
    	if(address == null) return false;
    	Matcher m = p.matcher(address);
    	if(!m.matches()) return false;
    	return true;
    }
    
    public boolean validateExpirationDate(String date) {
    	// TODO: your work
    	String regex = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$";
    	Pattern p = Pattern.compile(regex);
    	if(date == null) return false;
    	Matcher m = p.matcher(date);
    	if(!m.matches()) return false;
    	return true;
    }
    
    public boolean validateCardNumber(String cardNumber) {
    	// TODO: your work
    	String regex = "^[A-Za-z0-9\\s]{1,}[A-Za-z0-9\\s]{0,}$";
    	Pattern p = Pattern.compile(regex);
    	if(cardNumber == null) return false;
    	Matcher m = p.matcher(cardNumber);
    	if(!m.matches()) return false;
    	return true;
    }
    
    public boolean validateSecurityCode(String securityCode) {
    	// TODO: your work
    	if(securityCode == null) return false;
    	if(securityCode.length() != 3) return false;
    	String regex = "^[0-9]*$";
    	Pattern p = Pattern.compile(regex);
    	Matcher m = p.matcher(securityCode);
    	if(!m.matches()) return false;
    	return true;
    }
    
    public boolean validateHolderName(String holderName) {
    	// TODO: your work
    	String regex = "^[A-Za-z\\s]{1,}[A-Za-z\\s]{0,}$";
    	Pattern p = Pattern.compile(regex);
    	if(holderName == null) return false;
    	Matcher m = p.matcher(holderName);
    	if(!m.matches()) return false;
    	return true;
    }
    
    /**
     * This method calculates the shipping fees of order
     * @param order
     * @return shippingFee
     */
    public int calculateShippingFee(Order order){
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount() );
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }
}
