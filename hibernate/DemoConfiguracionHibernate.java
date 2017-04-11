import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ventanaEmpleados.Empleado;


public class DemoConfiguracionHibernate {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	public static void main (String[] args){
		
			File conf = new File("hibernate.cfg.xml");
			System.out.print(conf.canRead());
			Configuration configuracion = new Configuration();
			
			configuracion.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuracion.getProperties()).buildServiceRegistry();
	
			sessionFactory = configuracion.buildSessionFactory(serviceRegistry);
			
			
			DemoConfiguracionHibernate demConfHiber = new DemoConfiguracionHibernate();
			java.sql.Timestamp ts = java.sql.Timestamp.valueOf( "2017-12-12 00:00:00" ) ;
			Integer empl1 = demConfHiber.addEmpleado(1,"pablo", "perez", "p.perez@rr.com", "IT", 112.2f, ts);
			
			
			
			
			//ak finalizar para cerrar
			sessionFactory.close();
	
	}
	
	public Integer addEmpleado(int id,String fname, String appe, String email,String departamento,float salario,Timestamp fechaIni){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer colaboradorID = null;
		try {
			tx = session.beginTransaction();
			Empleado emp = new Empleado(id,fname, appe, email,departamento,salario,fechaIni);
			colaboradorID = (Integer)session.save(emp);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return colaboradorID;
	}
	
	public void listEmpleados(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List empList = session.createQuery("FROM table1").list();
			for(Iterator it =  empList.iterator();it.hasNext();){
				Empleado emp = (Empleado) it.next();
				System.out.println("nombre "+emp.getNombre());
				System.out.println("apellidos "+emp.getApellido());
				System.out.println("email "+emp.getEmail());
			}
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
}
