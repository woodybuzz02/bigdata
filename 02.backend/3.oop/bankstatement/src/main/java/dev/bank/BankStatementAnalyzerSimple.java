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
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		System.out.println(path);
		
		final List<String> lines = Files.readAllLines(path);
		System.out.println(lines);
		
		System.out.println(lines.get(0));
		
		// 총 사용금액
		double total = 0d;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
		}
		System.out.println("총 사용 금액은"+total+"입니다.");
		
		System.out.println("총 사용 금액은"+ findTransactionsInJanuary() +"입니다.");
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