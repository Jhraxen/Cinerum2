package com.example.aplicacio.DB
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aplicacio.DB.PeliculasContract.COLUMN_NAME_DIRECTOR
import com.example.aplicacio.DB.PeliculasContract.COLUMN_NAME_IMAGE
import com.example.aplicacio.DB.PeliculasContract.COLUMN_NAME_TITLE
import com.example.aplicacio.DB.PeliculasContract.SQL_CREATE_ENTRIES
import com.example.aplicacio.DB.PeliculasContract.SQL_DELETE_ENTRIES
import com.example.aplicacio.DB.PeliculasContract.TABLE_NAME
/*aquí tenemos la clase PeliculasDBHelper, que extiende de SQLiteOpenHelper*/
class PeliculasDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    companion object {
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "peliculas.db"
    }

   fun insertPelicula(p: Pelicula) {

        val values = ContentValues()
        values.put(COLUMN_NAME_IMAGE, p.image)
        values.put(COLUMN_NAME_TITLE, p.title)
        values.put(COLUMN_NAME_DIRECTOR, p.director)
        val db = writableDatabase
        db.insert(TABLE_NAME, null, values)
  }

    fun deleteAllPeliculas() {
            val db = writableDatabase
            db.delete(TABLE_NAME, null, null)
        }
    fun deletePelicula(id: Int) {
            val db = this.writableDatabase
            db.execSQL("DELETE FROM $TABLE_NAME WHERE ID = $id")
        }

    @SuppressLint("Range")
    fun getAllPeliculas (): ArrayList<Pelicula> {
        val peliculas = ArrayList<Pelicula>()
        val db = writableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                //crides l'd .getInt(cursor.getColumn..("id")
                val id = cursor.getInt(cursor.getColumnIndex(("id")));
                val image = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_IMAGE))
                val title = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_TITLE))
                val director = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_DIRECTOR))
                val pelicula = Pelicula(id,image, title, director)
                peliculas.add(pelicula)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return peliculas
    }

}