package com.sportyshoes.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sportyshoes.models.Orders;

@Component
public interface OrdersDao {
	public Integer order(Orders orders);
	public List<Orders> allorders();
	public List<Orders> byuserid(int userid);
	public List<Orders> bydateace();
	public List<Orders> bydatedec();
	public List<Orders> byorderidace();
	public List<Orders> byorderiddec();

}
