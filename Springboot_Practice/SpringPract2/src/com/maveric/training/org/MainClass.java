package com.maveric.training.org;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainClass {

		public static void main(String[] args) {
			Resource r=new ClassPathResource("ApplicationContext.xml");
			BeanFactory factory=new XmlBeanFactory(r);
			
			Employee e1=(Employee) factory.getBean("employeeBean");
			System.out.println(e1);
		}
}
