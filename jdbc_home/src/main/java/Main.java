import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        String username = "admin";
        String password = "admin";
        String url = "jdbc:h2:file:W:/Lex/Java/javaEE/jdbc_home/src/main";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            selectEmployeesByDepartment(connection, "all");

//            deleteTableByName(connection, "PIVOT_TABLE_BY_EMPLOYEES");

            showAllTablesInDatabase(connection);

            createPivotTableByEmployees(connection);

            previousWorkplacesOfEmployees(connection);
        }

    }

    static void previousWorkplacesOfEmployees(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT EMPLOYEE.NAME, COMPANIES.COMPANY_NAME " +
                "FROM EMPLOYEE " +
                "INNER JOIN COMPANIES ON EMPLOYEE.ID = COMPANIES.ID " +
                "ORDER BY EMPLOYEE.NAME");
        printTwoColumns(resultSet);
    }

    private static void createPivotTableByEmployees(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            statement.execute("CREATE TABLE PIVOT_TABLE_BY_EMPLOYEES " +
                    "AS (SELECT EMPLOYEE.ID, EMPLOYEE.NAME, DEPARTMENTS.DEPARTMENT, SALARIES.AMOUNT_UAH, HIRE_DATES.HIRE_DATE " +
                    "FROM EMPLOYEE " +
                    "INNER JOIN DEPARTMENTS ON EMPLOYEE.ID = DEPARTMENTS.ID " +
                    "INNER JOIN SALARIES ON EMPLOYEE.ID = SALARIES.ID " +
                    "INNER JOIN HIRE_DATES ON EMPLOYEE.NAME = HIRE_DATES.NAME)" +
                    "ORDER BY EMPLOYEE.NAME");
        } catch (SQLException e) {
            statement.execute("DROP TABLE PIVOT_TABLE_BY_EMPLOYEES");
            statement.execute("CREATE TABLE PIVOT_TABLE_BY_EMPLOYEES " +
                    "AS (SELECT EMPLOYEE.ID, EMPLOYEE.NAME, DEPARTMENTS.DEPARTMENT, SALARIES.AMOUNT_UAH, HIRE_DATES.HIRE_DATE " +
                    "FROM EMPLOYEE " +
                    "INNER JOIN DEPARTMENTS ON EMPLOYEE.ID = DEPARTMENTS.ID " +
                    "INNER JOIN SALARIES ON EMPLOYEE.ID = SALARIES.ID " +
                    "INNER JOIN HIRE_DATES ON EMPLOYEE.NAME = HIRE_DATES.NAME)" +
                    "ORDER BY EMPLOYEE.NAME");
        }
    }

    private static void showAllTablesInDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        printTwoColumns(resultSet);
    }

    private static void deleteTableByName(Connection connection, String nameOfTable) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE " + nameOfTable);
    }

    private static void selectEmployeesByDepartment(Connection connection, String descriptionOfDepartment) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        if (descriptionOfDepartment.toUpperCase().equals("ALL")) {
            resultSet = statement.executeQuery(
                    "SELECT EMPLOYEE.NAME, DEPARTMENTS.DEPARTMENT FROM EMPLOYEE, DEPARTMENTS" +
                            " WHERE EMPLOYEE.ID = DEPARTMENTS.ID ORDER BY EMPLOYEE.NAME");
        } else {
            resultSet = statement.executeQuery(
                    "SELECT EMPLOYEE.NAME, DEPARTMENTS.DEPARTMENT FROM EMPLOYEE, DEPARTMENTS" +
                            " WHERE EMPLOYEE.ID = DEPARTMENTS.ID AND DEPARTMENT LIKE "
                            + "'" + descriptionOfDepartment.toUpperCase() + "%' ORDER BY EMPLOYEE.NAME");
        }
        printTwoColumns(resultSet);
    }


    private static void printFourColumns(ResultSet resultSet) throws SQLException {
        System.out.println("\n");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4)
            );
        }
    }

    private static void printTwoColumns(ResultSet resultSet) throws SQLException {
        System.out.println("\n");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2)
            );
        }
    }
}
