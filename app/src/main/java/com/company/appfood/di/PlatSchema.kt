package com.company.appfood.di


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.company.appfood.domain.model.MenuModel
import com.company.appfood.domain.model.PlatModel

class PlatSchema
// creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {

        val queryPlat = ("CREATE TABLE " + TABLE_PLAT + " ("
                + ID_PLAT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_PLAT + " TEXT,"
                + TYPE_MENU + " TEXT,"
                + PRIX_PLAT + " TEXT,"
                + DESCRIPTION_PLAT + " TEXT,"
                + IMAGE_PLAT + " TEXT)")
        db.execSQL(queryPlat)
    }

    // this method is use to add new course to our sqlite database.
    fun addNewPlat(
        label: String?,
        type_menu: String?,
        prix: String?,
        description: String?,
        image: String?
    ) {

        val db = this.writableDatabase
        val values = ContentValues()
//      Put entries
        values.put(NAME_PLAT, label)
        values.put(TYPE_MENU, type_menu)
        values.put(PRIX_PLAT, prix)
        values.put(DESCRIPTION_PLAT, description)
        values.put(IMAGE_PLAT, image)

        db.insert(TABLE_PLAT, null, values)

        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PLAT")
        onCreate(db)
    }



    companion object {

        // Configuration database
        private const val DB_NAME = "db_sahel_food"
        private const val DB_VERSION = 1
        // TABLE PLAT
        private const val TABLE_PLAT = "plat"

        private const val ID_PLAT = "id"

        private const val NAME_PLAT = "name"

        private const val TYPE_MENU = "type_menu"

        private const val PRIX_PLAT = "prix"

        private const val DESCRIPTION_PLAT = "description"

        private const val IMAGE_PLAT = "image"

    }


    //Read data
    fun readPlats(): ArrayList<PlatModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_PLAT", null)

        // on below line we are creating a new array list.
        val platModelArrayList: ArrayList<PlatModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                platModelArrayList.add(
                    PlatModel(

                        cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCourses.close()
        return platModelArrayList
    }

    fun updatePlat(
        originalCourseName: String, courseName: String?, courseDescription: String?,
        courseTracks: String?, courseDuration: String?,  coursePrice: String?
    ) {
        // calling a method to get writable database.
        val db = this.writableDatabase
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_PLAT, courseName)
        values.put(TYPE_MENU, courseDuration)
        values.put(PRIX_PLAT, coursePrice)
        values.put(DESCRIPTION_PLAT, courseDescription)
        values.put(IMAGE_PLAT, courseTracks)

        db.update(TABLE_PLAT, values, "name=?", arrayOf(originalCourseName))
        db.close()
    }


    fun deletePlat(idPlat: Int) {

        val db = this.writableDatabase

        db.delete(TABLE_PLAT, "id=?", arrayOf(arrayOf(idPlat).toString()))
        db.close()
    }

}