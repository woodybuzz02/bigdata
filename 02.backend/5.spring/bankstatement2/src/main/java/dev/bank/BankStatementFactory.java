package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dev.bank.data.BankStatementCSVParser;

@Configuration // 이 클래스가 빈 구성정보(IoC 컨테이너)로 활용될 수 있도록 설정 or 지정
public class BankStatementFactory {
	
//	@Bean // Bean 구성 정보 내에 둥록되어있는 하나의 Bean으로 지정
//	public BankStatementAnalyzer bankStatementAnalyzer() {
//		return new BankStatementAnalyzer(new BankStatementCSVParser());
//	}
	
	@Bean
	public BankStatementCSVParser bankStatementCSVParser() {
		return new BankStatementCSVParser();
	}
	
	@Bean
	public BankStatementAnalyzer bankStatementAnalyzer() {
		return new BankStatementAnalyzer(bankStatementCSVParser());
	}
}
