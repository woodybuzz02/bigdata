package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;


public class MainApplication {

	public static void main(String[] args) throws IOException {
		
		// 생성자에서 팩토리로...
		// before
		//		final BankStatementParser parser = new BankStatementCSVParser();	
		//		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		// after
		BankStatementFactory factory = new BankStatementFactory();
		
		BankStatementAnalyzer analyzer = factory.bankStatementanalyzer();
		
		analyzer.analyze("bank-data-simple.csv");
	}

}