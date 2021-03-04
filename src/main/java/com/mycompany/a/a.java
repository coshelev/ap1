import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class A{
	
	private static SessionFactory sessionFactory;
	public static void main(String[] args){
		System.out.print("hello A\n");
	
		 StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                .configure() // configures settings from hibernate.cfg.xml
                                .build();
                //try {
                        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			Session session = sessionFactory.openSession();
                        session.beginTransaction();
                        session.save( new Event( "Our very first event!", new Date() ) );
                        session.save( new Event( "A follow up event", new Date() ) );
                        session.getTransaction().commit();
                        session.close();

                //}
               // catch (Exception e) {
                        // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory so destroy it manually.
               //         StandardServiceRegistryBuilder.destroy(registry);
		//	System.out.print("exeption!\n");
               // };

		//Session session = sessionFactory.openSession();
                //session.beginTransaction();
		//session.save( new Event( "Our very first event!", new Date() ) );
                //session.save( new Event( "A follow up event", new Date() ) );
                //session.getTransaction().commit();
		//session.close();
	}
}

