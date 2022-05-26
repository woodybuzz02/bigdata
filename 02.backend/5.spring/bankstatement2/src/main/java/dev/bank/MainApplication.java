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
		// spring IoC 컨테이너인 applicationContext 객체 생성,
		// Bean 구성 정보의 역할을 담당하고 있는 BankStatementFactory를 동록
		
		// IoC 컨테이너 생성
		final ApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(BankStatementFactory.class);
		
		// 컨테이너에서 Analyzer 인스턴스(Bean) 꺼내오기
		final BankStatementAnalyzer analyzer = applicationContext.getBean(BankStatementAnalyzer.class);
		
		// 분석수행
		analyzer.analyze("bank-data-simple.csv");
	}

}