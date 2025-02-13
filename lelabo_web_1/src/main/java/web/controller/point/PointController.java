package web.controller.point;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.MemberDao;


@WebServlet("/point")
public class PointController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println(" /point get ok ");

            Object result = null;
            
            Object object = req.getSession().getAttribute("loginMno");
            if( object != null ) {
                    int loginMno = (Integer)object;
                    result = MemberDao.getInstance().getPointLog( loginMno );
            }
            ObjectMapper mapper = new ObjectMapper();
            String jsonResult = mapper.writeValueAsString( result );
            
            resp.setContentType("application/json");
            resp.getWriter().print( jsonResult );
            
 } // f end 
}

