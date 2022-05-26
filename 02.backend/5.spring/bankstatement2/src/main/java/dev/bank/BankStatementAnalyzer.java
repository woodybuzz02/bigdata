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

public class BankStatementAnalyzer {// Analyzer : 분석기
	// -> 분석기는 결과 분석의 역할만 수행해야하는데, Parsing의 역할도 수행하고 있음.
	// TSVParser를 CSVParser로 변경하기 위해서는 Analyzer 클래스의 변경도 함께 발생.

	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
		private static final String RESOURCES = "src/main/resources/";
		
		// 외부에서 생성자를 통해 인스턴스 주입받도록 수정, 그전에는 클래스 내부에서 직접 생성, 수정하는 방식이었음. private final BankStatementParser parser = new BankStatementCSVParser();
		private final BankStatementParser parser;
		
		public BankStatementAnalyzer(BankStatementParser parser) {
			this.parser = parser;
		}

		// 입출금 내역 분석 수행 메서드
		public void analyze(String fileName) throws IOException {
			
			final Path path = Paths.get(RESOURCES + fileName);
			final List<String> lines = Files.readAllLines(path);
			
			List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
			
			// 변환된 데이터(실제 데이터 -> Java 객체 BankTransaction)를 활용하여 입출금 내역 정산
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