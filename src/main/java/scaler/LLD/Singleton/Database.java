package scaler.LLD.Singleton;

public class Database {
    private Database(){};

    static Database database;

    public static Database getInstance(){
        if(database == null){
            synchronized (Database.class){
                if(database == null){
                    database = new Database();
                }
            }
        }
        return database;
    }

    public void print(){
        System.out.println("Hello World" + this);
    }
}
