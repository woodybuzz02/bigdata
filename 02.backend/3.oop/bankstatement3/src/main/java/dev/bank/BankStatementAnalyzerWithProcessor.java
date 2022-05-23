package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzerWithProcessor {

	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	
	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1

		// 1. 파일 경로 확인, 읽기
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);

		// 2. 읽어들인 파일 파싱(parsing)
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		// 3. 기능별 (총 입출금 내역 or 월 별 입출금 내역 or 카테고리별 등) 연산 처리(Processing)용 객체 생성
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		
		// 4. 입출금 내역 분석(Analyzer) 결과(Summary) 출력
		collectSummary(processor);
		
	}
	
	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("총 사용 금액은 "+bankStatementProcessor.calculateTotalAmount()+"입니다.");
		System.out.println("2월의 입출금 내역은 "+bankStatementProcessor.calculateListInMonth(Month.FEBRUARY)+"입니다.");
		System.out.println("Salary(급여) 카테고리의 총 입출금 내역은 " + bankStatementProcessor.calculateTotalForCategory("Salary") +"입니다.");
	}
	

}