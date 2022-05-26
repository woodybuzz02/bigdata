package dev.bank;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class BankStatementFactory {
	
	public BankStatementAnalyzer bankStatementanalyzer() {
		
		final BankStatementParser parser = new BankStatementCSVParser();
		
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		
		return analyzer;
	}
}
