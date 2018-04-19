package org.formation.order.bo;

import org.formation.order.dto.Order;
import org.formation.order.exception.BOException;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
