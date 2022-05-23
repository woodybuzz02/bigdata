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

	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
		private static final String RESOURCES = "src/main/resources/";
		
		// 입출금 내역 분석 수행 메서드
		public void analyze(String fileName, BankStatementParser parser) throws IOException {
			
			final Path path = Paths.get(RESOURCES + fileName);
			final List<String> lines = Files.readAllLines(path);
			
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
			
			BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
			
			collectSummary(processor);
			
		}
		
		// 입출금 내역 분석 결과 출력 메서드
		public static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은 "+processor.calculateTotalAmount()+"입니다.");
		System.out.println("2월의 입출금 내역은 "+processor.calculateListInMonth(Month.FEBRUARY)+"입니다.");
		System.out.println("Salary(급여) 카테고리의 총 입출금 내역은 " + processor.calculateTotalForCategory("Salary") +"입니다.");
		}
	
}