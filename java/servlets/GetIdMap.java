package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class GetIdMap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetIdMap() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoGetIdMap dgm = new DoGetIdMap();
        try {

            List idMap = dgm.do_GetIdMap();
            if (idMap != null) {
                Map<Integer, String> brandMap = (Map<Integer, String>) idMap.get(0);
                Map<Integer, String> categoryMap = (Map<Integer, String>) idMap.get(1);
                Map<Integer, Integer> categoryParentMap = (Map<Integer, Integer>) idMap.get(2);
                HttpServletRequest req = (HttpServletRequest) request;
                HttpSession session = req.getSession();
                session.setAttribute("brandMap", brandMap);
                session.setAttribute("categoryMap", categoryMap);
                session.setAttribute("categoryParentMap", categoryParentMap);
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
