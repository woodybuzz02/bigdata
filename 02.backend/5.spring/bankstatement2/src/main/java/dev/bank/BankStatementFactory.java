package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dev.bank.data.BankStatementCSVParser;

@Configuration // �� Ŭ������ �� ��������(IoC �����̳�)�� Ȱ��� �� �ֵ��� ���� or ����
public class BankStatementFactory {
	
//	@Bean // Bean ���� ���� ���� �շϵǾ��ִ� �ϳ��� Bean���� ����
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
