package conm.neuedu.dao.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.Cart;

public class CartDaoImpl implements CartDao {

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		
		return DataSource.carts.add(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		//
		//step1:获取数据源
		 List<Cart> list=DataSource.carts;
		//step2:遍历，找到需要修改的商品
		for(int i=0;i<list.size();i++) {
			Cart cart=list.get(i);
			if(cart.getId()==id) {
				//step3:删除
				list.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return DataSource.carts;
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return DataSource.carts.size();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		
		//step1:获取数据源
		 List<Cart> list=DataSource.carts;
		//step2:遍历，找到需要修改的商品
		for(int i=0;i<list.size();i++) {
			Cart cart=list.get(i);
			if(cart.getId()==id) {
				//step3:修改数量
				cart.setProductNum(num);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		DataSource.carts.clear();
	}

}
