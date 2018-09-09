package app.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.util.UConnection;

public class CursoDAO
{
   public List<CursoDTO> getCursos()
   {
       // el query
      String sql = "";
      sql+="SELECT id_curso ";
      sql+="      ,descripcion ";
      sql+="      ,precio ";
      sql+="FROM curso ";

       // ejecuto el query 
      try( Connection con = UConnection.getConnection()
          ;PreparedStatement pstm = con.prepareStatement(sql)
          ;ResultSet rs = pstm.executeQuery() )
      {
         List<CursoDTO> lst = new ArrayList<>();
         while( rs.next() )
         {
            CursoDTO dto = new CursoDTO();
            dto.setIdCurso(rs.getInt("id_curso"));
            dto.setDescripcion(rs.getString("descripcion"));
            dto.setPrecio(rs.getDouble("precio"));
            lst.add(dto);
         }
         
         return lst;
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
         throw new RuntimeException(ex);
      }
   }
}
