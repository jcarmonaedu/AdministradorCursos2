package app.client.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.InscripcionDTO;
import app.logical.Facade;

@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet
{
   protected void doGet(HttpServletRequest request
                       ,HttpServletResponse response)
                      throws ServletException, IOException
   {
       // obtengo los datos del formulario
      String nombre = request.getParameter("nombre");
      String telefono = request.getParameter("telefono");

       // recordemos que los parametros siempre son cadenas
      int idCurso = Integer.parseInt(
                          request.getParameter("idCurso"));
      int idFormaPago = Integer.parseInt(
                      request.getParameter("idFormaPago"));
      
       // instancio el DTO y le asigno los datos
      InscripcionDTO dto = new InscripcionDTO();
      dto.setNombre(nombre);
      dto.setTelefono(telefono);
      dto.setIdCurso(idCurso);
      dto.setIdFormaPago(idFormaPago);
      
       // invoco al facade para procesar la inscripcion
      Facade f = new Facade();
      int idInsc = f.registrarInscripcion(dto);
      
       // el resultado lo adjunto como atributo en el request
      request.setAttribute("idInsc", idInsc);
      
       // redirecciono el control hacia la siguiente vista,
       // es decir: hacia su servlet de pre-procesamiento
      request.getRequestDispatcher("/preConfirmacion")
                               .forward(request, response);
   }
}
