package app.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.util.UConnection;

public class FormaPagoDTO
{
	private int idFormaPago;
	private String descripcion;
	private double recargo;

	public int getIdFormaPago()
	{
		return idFormaPago;
	}

	public void setIdFormaPago(int idFormaPago)
	{
		this.idFormaPago=idFormaPago;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}

	public double getRecargo()
	{
		return recargo;
	}

	public void setRecargo(double recargo)
	{
		this.recargo=recargo;
	}

	public List<FormaPagoDTO> getFormasPago()
	{
		// el query
		String sql="";
		sql+="SELECT id_forma_pago ";
		sql+="      ,descripcion ";
		sql+="      ,recargo ";
		sql+="FROM forma_pago ";

		// ejecuto el query
		try (Connection con=UConnection.getConnection(); PreparedStatement pstm=con.prepareStatement(sql); ResultSet rs=pstm.executeQuery())
		{
			List<FormaPagoDTO> lst=new ArrayList<>();
			while(rs.next())
			{
				FormaPagoDTO dto=new FormaPagoDTO();
				dto.setIdFormaPago(rs.getInt("id_forma_pago"));
				dto.setDescripcion(rs.getString("descripcion"));
				dto.setRecargo(rs.getDouble("recargo"));
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
