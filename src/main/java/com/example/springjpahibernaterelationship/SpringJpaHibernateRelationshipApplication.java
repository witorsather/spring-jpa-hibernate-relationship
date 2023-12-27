package com.example.springjpahibernaterelationship;

import com.example.springjpahibernaterelationship.bidirectional.manyToMany.PersistBiMtm;
import com.example.springjpahibernaterelationship.bidirectional.oneToMany.PersistBiOtm;
import com.example.springjpahibernaterelationship.unidirectional.manyToMany.PersistUniMtm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaHibernateRelationshipApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJpaHibernateRelationshipApplication.class, args);

//		PersistUniMtm persistUniMtm = context.getBean(PersistUniMtm.class);
//		persistUniMtm.performJpaOperations();

//		PersistBiOtm persistBiOtm = context.getBean(PersistBiOtm.class);
//		persistBiOtm.performJpaOperations();

		PersistBiMtm persistBiMtm = context.getBean(PersistBiMtm.class);
		persistBiMtm.performJpaOperations();
	}

}
