package glue;

import account.Account;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class AccountSteps {
        Account  account = null;

        @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
        public void accountExistsForAccNoWithName(String number, String name) {
            account = new Account(number, name);
        }

        @And("^deposits are made$")
        public void depositsAreMade(io.cucumber.datatable.DataTable dataTable) {
            dataTable.asList().forEach(deposit -> account.deposit(Double.parseDouble(deposit)));
        }

        @And("^withdrawls are made$")
        public void withdrawlsAreMade(io.cucumber.datatable.DataTable dataTable) {
            dataTable.asList().forEach(withdrawal -> account.withdraw(Double.parseDouble(withdrawal)));
        }

        @When("^statement is produced$")
        public void statementIsProduced() {
            account.produceStatement();
        }

        @Then("^statement includes \"([^\"]*)\"$")
        public void statementIncludes(String expectedStatement) {
            String actualStatement = account.getStatement();
            assertTrue(actualStatement.contains(expectedStatement));
        }
    }




