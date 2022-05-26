package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {// Analyzer : �м���
	// -> �м���� ��� �м��� ���Ҹ� �����ؾ��ϴµ�, Parsing�� ���ҵ� �����ϰ� ����.
	// TSVParser�� CSVParser�� �����ϱ� ���ؼ��� Analyzer Ŭ������ ���浵 �Բ� �߻�.

	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
		private static final String RESOURCES = "src/main/resources/";
		
		// �ܺο��� �����ڸ� ���� �ν��Ͻ� ���Թ޵��� ����, �������� Ŭ���� ���ο��� ���� ����, �����ϴ� ����̾���. private final BankStatementParser parser = new BankStatementCSVParser();
		private final BankStatementParser parser;
		
		public BankStatementAnalyzer(BankStatementParser parser) {
			this.parser = parser;
		}

		// ����� ���� �м� ���� �޼���
		public void analyze(String fileName) throws IOException {
			
			final Path path = Paths.get(RESOURCES + fileName);
			final List<String> lines = Files.readAllLines(path);
			
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
			
			// ��ȯ�� ������(���� ������ -> Java ��ü BankTransaction)�� Ȱ���Ͽ� ����� ���� ����
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