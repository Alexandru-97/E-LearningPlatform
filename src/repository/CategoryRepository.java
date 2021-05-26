package repository;

import config.*;
import model.*;


import java.sql.*;
import java.util.Optional;

public class CategoryRepository {
    /*
     *   Statement
     *   PreparedStatement
     *   CallableStatement
     *
     * */

    public void addCategory(Category category) {
        String sql = "insert into categories values (null, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public Optional<BankAccount> getBankAccountById(long id) {
        String sql = "select * from bankaccounts ba where ba.id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                //i have at least one record in the result set
                long bankAccountId = result.getLong(1);
                String accountNumber = result.getString("accountNumber");
                double balance = result.getDouble("balance");
                BankAccountType type = BankAccountType.valueOf(result.getString("type"));
                String cardNumber = result.getString("cardNumber");
                return Optional.of(new BankAccount(bankAccountId, accountNumber, balance, type, cardNumber));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    public double showAll(CategoryType type) {
        double result = 0;

        String sql = "{? = call total_amount_per_type(?)}";

        try (CallableStatement stmt = DatabaseConnection.getInstance().prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.DOUBLE);
            stmt.setString(2, type.toString());
            stmt.execute();
            result = stmt.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

 */
public void deleteCategory(Category category){
    String sql = "delete from categories where name = ?";
    try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
    {
        statement.setString(1, category.getName());
        statement.executeUpdate();

    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}

}