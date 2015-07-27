package br.com.dissemine.livraria.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@FacesConverter(forClass = Editora.class)
public class ConversorEditora implements Converter {

	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Editora editora = (Editora) object;
		if (editora == null || editora.getId() == null) {
			return null;
		}
		return String.valueOf(editora.getId());
	}

	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(string);
		Editora editora = JPAUtil.getEntityManager().find(Editora.class, id);
		return editora;
	}
}
