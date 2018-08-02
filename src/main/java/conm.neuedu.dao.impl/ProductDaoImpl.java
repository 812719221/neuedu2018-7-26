package conm.neuedu.dao.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

/**
 * ��ƷDao��ʵ����
 * */
public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return DataSource.products.add(product);
		
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		return DataSource.products;
	}

	@Override
	public boolean updateProduct(Product product) {
		
		// TODO Auto-generated method stub
		//step1:�Ȳ�ѯ��Ҫ�޸ĵ���Ʒ
		List<Product> products=DataSource.products;
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			//��ƷID
			int  _id=p.getId();
			if(_id==product.getId()) {
				//step2:���µ���Ʒ��ֵ���ɵ���Ʒ
				products.set(i, product);
				return true;
			}
		}
		
		 
		
		
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		List<Product> products=DataSource.products;
		for(int i=0;i<products.size();i++) {
			Product p=products.get(i);
			//��ƷID
			int  _id=p.getId();
			if(_id==id) {
				products.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		
		List<Product> list=DataSource.products;
		for(int i=0;i<list.size();i++) {
			Product p=list.get(i);
			if(p.getId()==id) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}




}
