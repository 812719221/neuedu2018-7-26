package conm.neuedu.dao.impl;

import com.neuedu.dao.OrderDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrder;

public class OrderDaoImpl implements OrderDao {

	
	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		return DataSource.orders.add(userOrder);
		
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return DataSource.orders.size()+1;
	}

}
