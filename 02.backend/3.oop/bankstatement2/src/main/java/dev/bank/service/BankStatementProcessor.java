package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import dev.bank.domain.BankTransaction;

// 입출금 관련 도메인(비지니스) 로직을 처리하는 클래스
public class BankStatementProcessor {
	private final List<BankTransaction> bankTransactions;


	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	// 1. 총 입출금 내역 계산 로직
	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		} return total;
	}
	
	// 2. 월 별 입출금 내역 계산 로직
	public List<BankTransaction> calculateListInMonth(Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}

		return bankTransactionsInMonth;
	}
	
	
	// 3. 카테고리 별 총 입출금 내역 조회 계산 로직
	public double calculateTotalForCategory(String category) {
		double total = 0d;
		
		for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		
		return total;
	}
}

