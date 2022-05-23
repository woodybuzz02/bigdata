package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final BankStatementParser parser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze("bank-data-simple.csv", parser);
	}

}