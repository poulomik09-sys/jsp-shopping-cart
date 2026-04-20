package com.example;//defines the project package
import jakarta.servlet.*;//is needed for servlet functionallity
import jakarta.servlet.http.*;//import http specific servlet classes
import java.io.IOException;//import input and outputs classes used in file and string handling
import java.util.*;//import utility classes like list and the arraylist
public class CartServlet extends HttpServlet //inherited by the class servlet it handles the http request (get and post){
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//it is used for when user submit a form
            throws ServletException, IOException //it is used to solve the servlet errors{
        String item = request.getParameter("item")//reads the item name from input
        HttpSession session = request.getSession();//it stores the data per user 
        List<String> cart = (List<String>) session.getAttribute("cart");//helps you to retrive the cart from the session and here we done typecasting also required.object is changed to the string.
        if (cart == null)//first time user cart does not exist {
            cart = new ArrayList<>();
        }       
        if (item != null && !item.trim().isEmpty())//it prevent empty or null items {
            cart.add(item);
        }
        session.setAttribute("cart", cart);//update the session data
        response.sendRedirect("cart");//it redirects to the \cart.it also triggers the doGet method.
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//the user visits 
            throws ServletException, IOException {
        HttpSession session = request.getSession();//it sends the request to the session
        List<String> cart = (List<String>) session.getAttribute("cart");
        request.setAttribute("cartItems", cart);//passes the cart data to the jspm page.
        RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");//send the request to the cart.jsp and jsp will display the cart items.
        rd.forward(request, response);
    }
}
