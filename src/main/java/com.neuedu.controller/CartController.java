package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cart.do")
public class CartController extends HttpServlet{
    CartService cartService=new CartServiceImpl();
	ProductService pService=new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String operation =req.getParameter("operation");
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {//��ѯ���ﳵ
				findCart(req, resp);
			}else if (operation.equals("2")) {
				//findAll(req,resp);
			}else if (operation.equals("3")) {
				//deleteCart(req,resp);
			}
			else if (operation.equals("4")) {
				//findCartById(req, resp);
			}
			else if (operation.equals("5")) {
				//updateCart(req, resp);
			}
			else if (operation.equals("6")) {
				//findCartByPage(req, resp);
			}else if (operation.equals("7")) {
				//findCartById2(req, resp);
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	//��ѯ���ﳵ
	public void findCart(HttpServletRequest request,HttpServletResponse response) throws IOException {

		List<Cart> cartlist=findAllCart();
		String callback=request.getParameter("callback");
		Gson gson=new Gson();
		String json=gson.toJson(cartlist);
		PrintWriter printWriter=response.getWriter();
		printWriter.write(callback+"("+json+")");


	}








	/**
	 * ��ӹ��ﳵ
	 **/
	public  void addCart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Cart cart=new Cart();
		int productid=0;
		int productnum=0;
		System.out.println(req.getParameter("pid"));
		boolean result=false;
		try {
			productid=Integer.parseInt(req.getParameter("pid"));
			productnum=Integer.parseInt(req.getParameter("productnum"));
			ProductController  productController=new ProductController();
			Product product= productController.findProductById(productid);
			cart.setProduct(product);
			cart.setProductNum(productnum);
			result= addCart(cart);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result) {
			System.out.println("���ﳵ��ӳɹ�");
			//findCartByPage(req, resp);

		}else {
			System.out.println("���ﳵ���ʧ��");
		}

	}
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}

	/**
	 * �������ﳵ
	 *
	 **/
	public  void findAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		List<Cart> carts= cartService.findAllCart();
	//	String info=JSONArray.toJSONString(carts);
	//	resp.getWriter().print(info);
		req.setAttribute("carts", carts);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}



	/**
	 * ɾ��
	 * */
	public boolean  deleteCart(int id) {
		return cartService.deleteCart(id);
	}
	/**
	 * �޸Ĺ��ﳵ
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * ��ѯ���ﳵ
	 * */
	public List<Cart> findAllCart(){
		return cartService.findAllCart();
	}
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
