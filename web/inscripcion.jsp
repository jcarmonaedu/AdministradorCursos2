<%@page import="app.domain.FormaPagoDTO"%>
<%@page import="app.domain.CursoDTO"%>
<%@page import="java.util.List"%>
<%
   List<CursoDTO> cursos;
   List<FormaPagoDTO> formasPago;

    // obtengo los atributos que llegan en el request
   cursos = (List)request.getAttribute("cursos");
   formasPago = (List)request.getAttribute("formasPago");
%>

<html> 
<body>

   <form action="posInscripcion">
      Nombre: <input type="text" name="nombre"><br>
      Telefono: <input type="text" name="telefono"><br>
    
      Cursos:
      <select name="idCurso">
<%
      for(CursoDTO dto: cursos)
      {
%>
         <option value="<%=dto.getIdCurso()%>">
            <%=dto.getDescripcion()%>
         </option>      
<%
      }
%>      
      </select><br>
      
      Formas de pago:
      <select name="idFormaPago">
<%
      for(FormaPagoDTO dto: formasPago)
      {
%>
         <option value="<%=dto.getIdFormaPago()%>">
            <%=dto.getDescripcion()%>
         </option>      
<%
      }
%>      
      </select><br> 
      
      <input type="submit" value="Enviar">
     
   </form>
</body>
</html>

