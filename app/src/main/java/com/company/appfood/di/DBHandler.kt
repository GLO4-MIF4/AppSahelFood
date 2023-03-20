package com.company.appfood.di


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.company.appfood.domain.model.CommandModel
import com.company.appfood.domain.model.MenuModel
import com.company.appfood.domain.model.PlatModel
import com.company.appfood.domain.model.MyUserModel

class DBHandler
// creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    // below method is for creating a database by running a sqlite query
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(db: SQLiteDatabase) {
//      CREATE TABLE MENU
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + CATEGORIE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + IMAGE_COL + " TEXT)")
//      CREATE TABLE PLAT
        val queryDishes = ("CREATE TABLE " + TABLE_PLAT + " ("
                + ID_PLAT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_PLAT + " TEXT,"
                + TYPE_MENU + " TEXT,"
                + PRIX_PLAT + " TEXT,"
                + DESCRIPTION_PLAT + " TEXT,"
                + IMAGE_PLAT + " TEXT)")

//      CREATE TABLE USER
        val queryUser = ("CREATE TABLE " + TABLE_USER + " ("
                + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_USER + " TEXT,"
                + MAIL_USER + " TEXT,"
                + PHONE_USER + " TEXT,"
                + ROLE_USER + " TEXT)")
//      CREATE TABLE ORDER

        val queryCmd = ("CREATE TABLE " + TABLE_CMD + " ("
                + ID_CMD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DATE_CMD + " TEXT,"
                + QTE_CMD + " TEXT,"
                + USER_ID + " TEXT,"
                + PLAT_ID + " TEXT)")
//

        // EXECUTE  QUERIES
//
            db.execSQL(query)
            db.execSQL(queryDishes)
            db.execSQL(queryCmd)
            db.execSQL(queryUser)

    }

    // this method is use to add new course to our sqlite database.
    fun addNewMenu(
        label: String?,
        categorie: String?,
        description: String?,
        image: String?
    ) {

        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, label)
        values.put(CATEGORIE_COL, categorie)
        values.put(DESCRIPTION_COL, description)
        values.put(IMAGE_COL, image)

        db.insert(TABLE_NAME, null, values)

        db.close()
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
        // after adding all values we are passing
        db.insert(TABLE_PLAT, null, values)

        db.close()
    }

//    ADD USER
    fun addNewUser(
        name: String?,
        email: String?,
        phone: String?,
        role: String?,
    ) {

        val db = this.writableDatabase
        val values = ContentValues()
//      Put entries
        values.put(NAME_USER, name)
        values.put(MAIL_USER, email)
        values.put(PHONE_USER, phone)
        values.put(ROLE_USER, role )
        // after adding all values we are passing
        db.insert(TABLE_USER, null, values)

        db.close()
    }

//    ADD ORDER

    fun addNewCommand(
        date_cmd: String?,
        qte_cmd: String?,
        user_id: String?,
        plat_id: String?,

    ) {

        val db = this.writableDatabase
        val values = ContentValues()
//      Put entries
        values.put(DATE_CMD, date_cmd)
        values.put(QTE_CMD, qte_cmd)
        values.put(USER_ID, user_id)
        values.put(PLAT_ID, plat_id )
        // after adding all values we are passing
        db.insert(TABLE_CMD, null, values)

        db.close()
    }



    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PLAT")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CMD")
        onCreate(db)
    }



    companion object {
        // creating a constant variables for our database.
        // Configuration database
        private const val DB_NAME = "db_sahel_food"
        private const val DB_VERSION = 1

        // TABLE MENU
        private const val TABLE_NAME = "menu"

        private const val ID_COL = "id"

        private const val NAME_COL = "name"

        private const val CATEGORIE_COL = "categorie"

        private const val DESCRIPTION_COL = "description"

        private const val IMAGE_COL = "image"


        // TABLE PLAT
        private const val TABLE_PLAT = "plat"

        private const val ID_PLAT = "id"

        private const val NAME_PLAT = "name"

        private const val TYPE_MENU = "type_menu"

        private const val PRIX_PLAT = "prix"

        private const val DESCRIPTION_PLAT = "description"

        private const val IMAGE_PLAT = "image"

        // TABLE USER
        private const val TABLE_USER = "user_app"

        private const val ID_USER = "id"

        private const val NAME_USER = "name"

        private const val MAIL_USER = "email"

        private const val PHONE_USER = "phone"

        private const val ROLE_USER = "role"

        // TABLE ORDER
        private const val TABLE_CMD = "commande"

        private const val ID_CMD = "id"

        private const val DATE_CMD = "date_cmd"

        private const val QTE_CMD = "quantite"

        private const val USER_ID = "user_id"
        private const val PLAT_ID = "plat_id"

        // SECURITY APP
        private const val TABLE_SECURITY = "security"

        private const val ID_SEC = "id"

        private const val LOGIN = "login"

        private const val PASSWORD = "password"



    }



    //Read menu
    fun readCourses(): ArrayList<MenuModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // on below line we are creating a new array list.
        val menuModelArrayList: ArrayList<MenuModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                menuModelArrayList.add(
                    MenuModel(
//                        cursorCourses.getInt(1),

                        cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),


                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCourses.close()
        return menuModelArrayList
    }

    //Read  plat
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

    //Read command
    fun readUsers(): ArrayList<MyUserModel>? {
    // on below line we are creating a database for reading our database.
    val db = this.readableDatabase

    // on below line we are creating a cursor with query to read data from database.
    val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_USER", null)

    // on below line we are creating a new array list.
    val MyUserModelArrayList: ArrayList<MyUserModel> = ArrayList()

    // moving our cursor to first position.
    if (cursorCourses.moveToFirst()) {
        do {
            // on below line we are adding the data from cursor to our array list.
            MyUserModelArrayList.add(
               MyUserModel(
                    cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2),
                    cursorCourses.getString(3),
                    cursorCourses.getString(4),
                )
            )
        } while (cursorCourses.moveToNext())
        // moving our cursor to next.
    }
    // at last closing our cursor and returning our array list.
    cursorCourses.close()
    return MyUserModelArrayList
}

    //Read user
    fun readCommand(): ArrayList<CommandModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCommand: Cursor = db.rawQuery("SELECT * FROM $TABLE_CMD", null)

        // on below line we are creating a new array list.
        val commandModelArrayList: ArrayList<CommandModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCommand.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                commandModelArrayList.add(
                    CommandModel(
                        cursorCommand.getString(1),
                        cursorCommand.getString(2),
                        cursorCommand.getString(3),
                        cursorCommand.getString(4),
//                        cursorCommand.getString(4),
                    )
                )
            } while (cursorCommand.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCommand.close()
        return commandModelArrayList
    }

    fun updateCourse(
        originalCourseName: String, courseName: String?, courseDescription: String?,
        courseTracks: String?, courseDuration: String?
    ) {
        // calling a method to get writable database.
        val db = this.writableDatabase
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, courseName)
        values.put(CATEGORIE_COL, courseDuration)
        values.put(DESCRIPTION_COL, courseDescription)
        values.put(IMAGE_COL, courseTracks)

        db.update(TABLE_NAME, values, "name=?", arrayOf(originalCourseName))
        db.close()
    }

    // below is the method for updating our courses
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

    //  Update user and themes
    fun updateUser(
        originalCourseName: String, courseName: String?, courseEmail: String?,
        coursePhone: String?, courseRole: String?
    ) {
        // calling a method to get writable database.
        val db = this.writableDatabase
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_USER, courseName)
        values.put(MAIL_USER, courseEmail)
        values.put(PHONE_USER, coursePhone)
        values.put(ROLE_USER, courseRole)


        db.update(TABLE_USER, values, "name=?", arrayOf(originalCourseName))
        db.close()
    }

    //  Update user and themes
    fun updateCommand(
        originalCourseName: String, courseDate: String?, courseQte: String?,
        courseUserId: String?, coursePlatId: String?
    ) {
        // calling a method to get writable database.
        val db = this.writableDatabase
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DATE_CMD, courseDate)
        values.put(QTE_CMD, courseQte)
        values.put(USER_ID, courseUserId)
        values.put(PLAT_ID, coursePlatId)

        db.update(TABLE_CMD, values, "date_cmd=?", arrayOf(originalCourseName))
        db.close()
    }


    // on below line creating a function to delete course
    fun deleteCourse(id: String) {

        val db = this.writableDatabase
        db.delete(TABLE_NAME, "id=?", arrayOf((id)))
        db.close()
    }

    fun deletePlat(id: String) {
        val db = this.writableDatabase
        db.delete(TABLE_PLAT, "id=?", arrayOf((id)))
        db.close()
    }

    fun deleteUser(id: String) {
        val db = this.writableDatabase
        db.delete(TABLE_USER, "id=?", arrayOf((id)))
        db.close()
    }



}