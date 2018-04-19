package org.formation.order.bo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.formation.order.dao.OrderDAO;
import org.formation.order.dto.Order;
import org.formation.order.exception.BOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderBOImplTest {

	private static final int ORDER_ID = 123;

	@Mock
	OrderDAO dao;
	private OrderBOImpl bo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao).create(order);

	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(0);
		boolean result = bo.placeOrder(order);
		assertFalse(result);
		verify(dao).create(order);
	}

	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelOrder(ORDER_ID);
		assertTrue(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_not_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(ORDER_ID);
		assertFalse(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}

	public void deleteOrder_Deletes_The_Order() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenReturn(1);

		boolean result = bo.deleteOrder(ORDER_ID);
		assertTrue(result);

		verify(dao).delete(ORDER_ID);
	}

	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_A_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);

		bo.placeOrder(order);

	}

	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_A_BOExceptionOnRead() throws SQLException, BOException {
		when(dao.read(ORDER_ID)).thenThrow(SQLException.class);

		bo.cancelOrder(ORDER_ID);

	}

	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_A_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);

		bo.cancelOrder(ORDER_ID);
	}

}
