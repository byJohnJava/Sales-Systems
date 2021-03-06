package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EstadoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Estado> buscarTodos() throws Exception {

        ArrayList<Estado> listaRetorno = new ArrayList<Estado>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Estado.class);

        criteria.addOrder(Order.asc("idEstado"));

        listaRetorno = (ArrayList<Estado>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Estado buscarPorCodigo(int idEstado) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Estado estado = (Estado) sessao.get(Estado.class, idEstado);
        sessao.close();
        return estado;
    }

}
