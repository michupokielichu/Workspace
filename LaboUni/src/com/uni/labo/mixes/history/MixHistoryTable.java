package com.uni.labo.mixes.history;

import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gui.builder.components.Table;
import com.gui.builder.panel.AbstractPanel;
import com.uni.labo.hibernate.HibernateUtil;
import com.uni.labo.mixes.model.Mix;

public class MixHistoryTable extends AbstractPanel{

	@Override
	public void initialise() {
	Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
        tx = sesion.beginTransaction();
        Query query = sesion.createQuery("FROM Mix m where m.id <= :id1 and m.id >= :id2");
        query.setParameter("id2", 24479);
        query.setParameter("id1", 24679);
        List today = query.list();
        Table table = (Table) getContextMap().get("id1");
        
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        for (Iterator iterator = today.iterator(); iterator.hasNext();){

        	Mix mix =(Mix)iterator.next();
        	System.err.println(mix.getDescription());
				tableModel.addRow(new Object[] {
					mix.getId(),
					mix.getDate(),
					mix.getShift(),
					mix.getBatch(),
					mix.getRecipe(),
					mix.getDescription()
						
				});
        }
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        sesion.close();
    }
	}

	
	
}
