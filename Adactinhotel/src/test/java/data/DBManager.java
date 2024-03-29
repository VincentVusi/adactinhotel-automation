package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    Connection connection= null;
    Statement statement = null;

    public DBManager() throws SQLException {
        this.connection= DriverManager.getConnection("jdbc:sqlite:src/test/java/data/testdata_db.db");
        System.out.println("Opened database successfully");
    }

    public void createDatabase(){
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE testdata " +
                    "(id INT PRIMARY KEY NOT NULL," +
                    " username       TEXT    , " +
                    " password       TEXT    , " +
                    " location       TEXT    , " +
                    " hotels         TEXT    , " +
                    " roomtype       TEXT    , " +
                    " numberofrooms  TEXT    , " +
                    " checkindate    TEXT    , " +
                    " checkoutdate   TEXT    , " +
                    " adultsperroom  TEXT    , " +
                    " childrenperroom TEXT   , " +
                    " firstname      TEXT    , " +
                    " lastname       TEXT    , " +
                    " address        TEXT    , " +
                    " creditcardnumber TEXT  , " +
                    " creditcardtype TEXT    , " +
                    " expirymonth    TEXT    , " +
                    " expiryyear     TEXT    , " +
                    " cvvnumber      TEXT    )";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public void insertData(String table, String[] data) throws SQLException {
        String numOfColumns = "";
        for(int i=0 ;i<data.length;i++){
            numOfColumns = numOfColumns + "?,";
        }
        String sql = "INSERT INTO "+table+" VALUES("+numOfColumns.substring(0, numOfColumns.length() - 1)+")";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i=0; i<data.length; i++) {
            preparedStatement.setString(i+1, data[i]);
        }
        preparedStatement.executeUpdate();
    }

    public List<List<String>> selectData(String table, String id) throws SQLException {
        String sql = "SELECT * FROM "+table+" WHERE id = ?";
        List<List<String>> data = new ArrayList<>();

        PreparedStatement preparedStatement  = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet rs  = preparedStatement.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // loop through the result set
        while (rs.next()) {
            List<String> record = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                record.add(rs.getString(i));
            }
            data.add(record);
        }

        return data;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String[] array = {"1","VincentTester", "123456", "Sydney", "Hotel Creek", "Standard", "1", "27/03/2024", "28/03/2024", "1", "0", "John", "Doe", "123 Main St", "4111111111111111", "VISA", "September", "2025", "123"};
        new DBManager().insertData("testdata",array);
        //new DBManager().createDatabase();
        //List<List<String>> data = new DBManager().selectData("testdata","1");
        //System.out.println("Done");
    }
}
