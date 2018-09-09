 package app.client.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.CursoDTO;
import app.domain.FormaPagoDTO;
import app.logical.Facade;

@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet
{
   protected void doGet(HttpServletRequest request
                       ,HttpServletResponse response) 
                                    throws ServletException
                                          ,IOException
   {
       // obtengo el facade
      Facade f = new Facade();
		
       // obtengo las colecciones 
      List<CursoDTO> cursos = f.obtenerCursos();
      List<FormaPagoDTO> formasPago = f.obtenerFormasPago();
		
       // adjunto las colecciones al request
      request.setAttribute("cursos", cursos);
      request.setAttribute("formasPago", formasPago);
		
       // redirecciono el request a la pagina JSP  
      request.getRequestDispatcher("inscripcion.jsp")
                               .forward(request, response);
   }
}
