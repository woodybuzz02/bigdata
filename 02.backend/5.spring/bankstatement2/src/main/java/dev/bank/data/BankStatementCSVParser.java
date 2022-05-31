package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

public class BankStatementCSVParser implements BankStatementParser{
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String descriotion = columns[2];
		
		return new BankTransaction(date, amount, descriotion);
	}
	
	// �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// BankTransaction -> model Ŭ����
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line : lines) {
			BankTransaction bankTransaction = parseFrom(line);
			bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}

	
}