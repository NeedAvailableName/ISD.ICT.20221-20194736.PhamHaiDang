package boundary;
import entities.Cart;
import exceptions.aims.PlaceOrderException;
import interfaces.PlaceOrderSubsystemInterface;
public class PlaceOrderBoundary implements PlaceOrderSubsystemInterface {
	@Override
	public void placeOrder(Cart cart) throws PlaceOrderException {
	}

	@Override
	public void placeRushOrder(Cart cart) throws PlaceOrderException {
	}

}
