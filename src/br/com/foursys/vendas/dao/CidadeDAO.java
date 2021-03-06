package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class CidadeDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Cidade> buscarTodos() throws Exception {

        ArrayList<Cidade> listaRetorno = new ArrayList<Cidade>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Cidade.class);

        criteria.addOrder(Order.asc("idCidade"));

        listaRetorno = (ArrayList<Cidade>) criteria.list();

        sessao.close();

        return listaRetorno;

    }

    public Cidade buscarPorCodigo(int idCidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cidade cidade = (Cidade) sessao.get(Cidade.class, idCidade);
        sessao.close();
        return cidade;
    }

}
