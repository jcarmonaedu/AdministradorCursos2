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
}
