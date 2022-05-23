package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerSimple {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		System.out.println(path);
		
		final List<String> lines = Files.readAllLines(path);
		System.out.println(lines);
		
		System.out.println(lines.get(0));
		
		// �� ���ݾ�
		double total = 0d;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
		}
		System.out.println("�� ��� �ݾ���"+total+"�Դϴ�.");
		
		System.out.println("�� ��� �ݾ���"+ findTransactionsInJanuary() +"�Դϴ�.");
	}
	
	public static double findTransactionsInJanuary() throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;

		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		for (String line : lines) {
			final String[] columns = line.split("\t");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			
			if(date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
	
		}
		return total;
	}

}