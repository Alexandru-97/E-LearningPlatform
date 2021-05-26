package service;

import model.*;
import repository.*;
import model.Category;
import repository.CategoryRepository;

import java.util.*;

public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService() {
        this.categoryRepository= new CategoryRepository();
    }

    public Category build(String categoryDetails) {
        String attributes = categoryDetails;
        String name = attributes;
        return new Category(name);
    }

    public void addCategory(Category category) {
        categoryRepository.addCategory(category);
    }

    public void deleteCategory(Category category)
    {
        categoryRepository.deleteCategory(category);
    }
/*
    public Optional<BankAccount> getBankAccountById(long id) {
        return bankAccountRepository.getBankAccountById(id);
    }

    public double getTotalAmountByType(BankAccountType type) {
        return bankAccountRepository.getTotalAmountByType(type);
    }

 */
}