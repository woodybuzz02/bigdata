package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

public class BankStatementTSVParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 한 줄만 파싱, 이 클래스 내에서만 사용할 예정
	private BankTransaction parseFromTSV(final String line) {
		final String[] columns = line.split("\t");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String descriotion = columns[2];
		
		return new BankTransaction(date, amount, descriotion);
	}
	
	// 한 줄씩 파싱 후, 리스트에 추가
	// BankTransaction -> model 클래스
	public List<BankTransaction> parseLinesFromTSV(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line : lines) {
			BankTransaction bankTransaction = parseFromTSV(line);
			bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}
}