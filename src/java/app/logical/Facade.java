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
		CursoDTO dao=new CursoDTO();
		return dao.getCursos();
	}

	public List<FormaPagoDTO> obtenerFormasPago()
	{
		FormaPagoDTO dao=new FormaPagoDTO();
		return dao.getFormasPago();
	}
}
