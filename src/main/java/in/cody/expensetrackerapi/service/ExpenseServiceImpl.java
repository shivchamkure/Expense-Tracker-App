
package in.cody.expensetrackerapi.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.cody.expensetrackerapi.entity.Expense;
import in.cody.expensetrackerapi.exception.ResourceNotFoundException;
import in.cody.expensetrackerapi.repository.ExpenseRepository;


@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;

	
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}

	
	@Override
	public Expense getExpense(Long id){
		Optional<Expense> expense = expenseRepo.findById(id);
			if (expense.isPresent()){
				return expense.get();
				}
			throw new ResourceNotFoundException("***** Expense not found by its id "+ id +" ****");
	}

	@Override
	public void  deleteExpense(Long id) {	
		expenseRepo.deleteById(id);
	
	}

	
	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepo.save(expense);
	}


	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpense(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		return expenseRepo.save(existingExpense);
	}
	
	


}






























