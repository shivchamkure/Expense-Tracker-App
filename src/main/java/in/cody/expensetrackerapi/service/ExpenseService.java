package in.cody.expensetrackerapi.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.cody.expensetrackerapi.entity.Expense;


public interface ExpenseService {
	
	Page<Expense> getAllExpenses(Pageable page);
	
	Expense getExpense(Long id);
	
	void deleteExpense(Long id);
	
	Expense saveExpense(Expense expense);
	
	Expense updateExpenseDetails(Long id, Expense expense);
}
