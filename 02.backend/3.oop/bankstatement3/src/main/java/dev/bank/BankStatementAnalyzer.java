package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
		private static final String RESOURCES = "src/main/resources/";
		
		// ����� ���� �м� ���� �޼���
		public void analyze(String fileName, BankStatementParser parser) throws IOException {
			
			final Path path = Paths.get(RESOURCES + fileName);
			final List<String> lines = Files.readAllLines(path);
			
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
			
			BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
			
			collectSummary(processor);
			
		}
		
		// ����� ���� �м� ��� ��� �޼���
		public static void collectSummary(BankStatementProcessor processor) {
		System.out.println("�� ��� �ݾ��� "+processor.calculateTotalAmount()+"�Դϴ�.");
		System.out.println("2���� ����� ������ "+processor.calculateListInMonth(Month.FEBRUARY)+"�Դϴ�.");
		System.out.println("Salary(�޿�) ī�װ��� �� ����� ������ " + processor.calculateTotalForCategory("Salary") +"�Դϴ�.");
		}
	
}