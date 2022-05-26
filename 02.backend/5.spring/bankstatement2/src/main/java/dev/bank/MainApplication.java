package dev.bank;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		
		// before spring
//		BankStatementFactory factory = new BankStatementFactory();
//		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		// after spring
		// spring IoC �����̳��� applicationContext ��ü ����,
		// Bean ���� ������ ������ ����ϰ� �ִ� BankStatementFactory�� ����
		
		// IoC �����̳� ����
		final ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(BankStatementFactory.class);
		
		// �����̳ʿ��� Analyzer �ν��Ͻ�(Bean) ��������
		final BankStatementAnalyzer analyzer = applicationContext.getBean(BankStatementAnalyzer.class);
		
		// �м�����
		analyzer.analyze("bank-data-simple.csv");
	}

}