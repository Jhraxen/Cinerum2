package com.example.aplicacio.DB
/*aquí tenemos las columnas*/
object PeliculasContract {
        val TABLE_NAME = "peliculas"
        val COLUMN_NAME_IMAGE = "image"
        val COLUMN_NAME_TITLE = "title"
        val COLUMN_NAME_DIRECTOR = "director"

        val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE_NAME (" +
                    "id INTEGER PRIMARY KEY," +
                    "$COLUMN_NAME_IMAGE TEXT," +
                    "$COLUMN_NAME_TITLE TEXT," +
                    "$COLUMN_NAME_DIRECTOR TEXT)"

        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"


    }