package app.logical;

import java.util.List;

import app.domain.CursoDTO;
import app.domain.FormaPagoDTO;
import app.domain.InscripcionDAO;
import app.domain.InscripcionDTO;

public class Facade
{
	public int registrarInscripcion(InscripcionDTO dto)
	{
		InscripcionDAO dao=new InscripcionDAO();
		return dao.insertar(dto);
	}

	public List<CursoDTO> obtenerCursos()
	{
		CursoDAO dao=new CursoDAO();
		return dao.getCursos();
	}

	public List<FormaPagoDTO> obtenerFormasPago()
	{
		FormaPagoDAO dao=new FormaPagoDAO();
		return dao.getFormasPago();
	}
}
