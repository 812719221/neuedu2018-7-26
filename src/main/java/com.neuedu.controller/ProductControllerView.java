package com.neuedu.controller;

import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductControllerView extends HttpServlet{
    ProductService productService=new ProductServiceImpl();
    ProductService pService=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation=req.getParameter("operation");
        if(operation!=null&&!operation.equals("")){
            if (operation.equals("1")){
                findProductInformation(req, resp);
            }
        }

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }




    //查看商品详情
    public void findProductInformation(HttpServletRequest request,HttpServletResponse response){
        String sid=request.getParameter("id");

        int id=0;
        try {
            id=Integer.parseInt(sid);
            Product product=findById(id);
        }catch(NumberFormatException e) {
            e.printStackTrace();
        }

    }
    private Product findById(int id) {

        return pService.findProductById(id);

    }
}
