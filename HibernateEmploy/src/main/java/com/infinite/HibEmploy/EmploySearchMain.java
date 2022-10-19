package com.infinite.HibEmploy;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmploySearchMain {
	
	
	public static void main(String[] args) {
		int empno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employ No");
		empno=sc.nextInt();
		Configuration  cfg=new AnnotationConfiguration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Employ where empno="+empno);
		List<Employ> EmployList=query.list();
		if(EmployList.size()==1){
			System.out.println(EmployList.get(0));
		}else{
			System.out.println("*** Record not Found");
		}
	}

}
