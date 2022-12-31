package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import entity.NormalOrder;
import entity.Order;
import entity.RushOrder;
import entity.media.Media;
import common.exception.PlaceOrderException;

public class PlaceRushOrderController extends PlaceOrderController {
	private static PlaceRushOrderController placeRushOrderController;
	PlaceRushOrderController(HashMap<Media, Integer> itemsToBePurchased) throws PlaceOrderException {
		super();
		Iterator<Entry<Media, Integer>> it = itemsToBePurchased.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Media,Integer> entry = (Entry<Media, Integer>)it.next();
			if(!entry.getKey().isRushSupported()) {
				throw new PlaceOrderException("Please choose items that support rushing (noted on the list)");
			}
		}
		this.order = new RushOrder(itemsToBePurchased);
	}
	
	public static PlaceRushOrderController getPlaceRushOrderController(HashMap<Media, Integer> itemsToBePurchased) throws PlaceOrderException {
		if (placeRushOrderController == null) {
			placeRushOrderController = new PlaceRushOrderController(itemsToBePurchased);
			placeRushOrderController.placeOrderController = placeRushOrderController;
		}
		
		return placeRushOrderController;
	}
}
