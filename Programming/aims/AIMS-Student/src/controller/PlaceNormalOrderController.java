package controller;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import entity.media.*;
import entity.order.*;
import common.exception.*;
public class PlaceNormalOrderController extends PlaceOrderController {
	private static PlaceNormalOrderController placeNormalOrderController;
	PlaceNormalOrderController(HashMap<Media, Integer> itemsToBePurchased) throws PlaceOrderException {
		super();
//		this.order = new NormalOrder(itemsToBePurchased);
	}
	public static PlaceNormalOrderController getPlaceNormalOrderController(HashMap<Media, Integer> itemsToBePurchased) throws PlaceOrderException {
		if(placeNormalOrderController == null) {
			placeNormalOrderController = new PlaceNormalOrderController(itemsToBePurchased);
			placeNormalOrderController.placeNormalOrderController = placeNormalOrderController;
		}
		return placeNormalOrderController;
	}
}
