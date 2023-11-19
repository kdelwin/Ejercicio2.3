package com.example.ejercicio23;

public class Config {
    public static final String cards_table = "cards";
    public static final String id = "id";
    public static final String image = "image";
    public static final String description = "description";
    public static final String CreateTableCardsTable =
            "CREATE TABLE cards(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "image BLOB, description TEXT)";
    public static final String DropTableCardsTable ="DROP TABLE IF EXISTS cards_table";
    public static final String NameDataBase = "tarea2_3_db";
}
