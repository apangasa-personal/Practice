package scaler.LLD.Singleton;

public class Client {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.print();

        Database anotherDatabase = Database.getInstance();
        database.print();
    }
}
