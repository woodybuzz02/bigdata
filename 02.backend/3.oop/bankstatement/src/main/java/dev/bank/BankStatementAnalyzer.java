package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;

public class BankStatementAnalyzer {

	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1

		// 1. ���� ��� Ȯ��, �б�
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);

		// 2. �о���� ���� �Ľ�(parsing)
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		System.out.println("�� ��� �ݾ���" + calculateTotalAmount(bankTransactions) + "�Դϴ�.");

		System.out.println("2���� ����� ������ " + selectInMonth(bankTransactions, Month.FEBRUARY) + "�Դϴ�.");
		
		System.out.println("�� 1�� ��� �ݾ���"+ findTransactionsInJanuary() +"�Դϴ�.");
	}

	// �� ����� ���� Ȯ��, �޼������ ���� �ش� �޼��尡 �����ϴ� ���� �ٷ� ������ �� �ֵ���, ��ü���� ����ȭ�� �����ϴ� �޼������ �ۼ�
	public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
		double total = 0d;
		
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
			// final double amount = bankTransaction.getAmount();
			// total += amount;
		}

		return total;
	}

	// Ư�� ���� ���� ����� ���� ����Ʈ Ȯ��
	public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}

		return bankTransactionsInMonth;
	}

	// Ư�� �޿��� �� ���� ����� ������ �߻��Ͽ��°�?
	public static double findTransactionsInJanuary() throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;

		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// ����
		for (String line : lines) {
			final String[] columns = line.split("\t");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

			if (date.getMonth() == Month.JANUARY) { // 1���̸� true
				// Java 11 Month
				final double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
		}

		return total;
	}

}