package com.example.sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper{
        public static final int version = 1;
        public  static String dbName="Login.db";
        public static final String TABLE_NAME ="Userdata";
        public static final String COL1 = "id";
        public static final String COL2 = "username";
        public static final String COL3 = "password";
        public static final String COL4 = "name";
        private static final String CREATE_TABLE="create table if not exists "+ TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+COL2+" TEXT NOT NULL," + COL3 + " TEXT, " +COL4 + " INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        private Context context;
        
        public DatabaseHelper(@Nullable Context context){
            super(context,"Login.db",null,1)    ;
        }

//        public DatabaseHelper(Context context) {
//            super(context,dbName,null,version);
//            context=this.context;
//        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        public boolean InsertUser(User userObj)   {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COL2,userObj.getUserName());
            cv.put(COL3,userObj.getUserPassword());
            cv.put(COL4,userObj.getFullName());
            long result = db.insert(TABLE_NAME,null,cv);
            if(result == -1)
                return false;
            else
                return true;
        }

        public boolean updateData(User userObj){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();

            cv.put(COL3,userObj.getUserPassword());
            cv.put(COL4,userObj.getFullName());
            Cursor cursor=db.rawQuery("Select * from "+TABLE_NAME+ " where "+COL2+" = ?", new String[] {userObj.getUserName()});
            if(cursor.getCount()>0){
                long result=db.update(TABLE_NAME, cv, COL2+"=?", new String[] {userObj.getUserName()});
                if(result==-1){
                    return false;
                }
                else{
                    return  true;
                }
            }
            else{
                return false;
            }
        }

        public boolean deleteData(User userObj){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            Cursor cursor=db.rawQuery("Select * from "+TABLE_NAME+" where "+COL2+" = ?", new String[] {userObj.getUserName()});
            if(cursor.getCount()>0){
                long result=db.delete(TABLE_NAME, COL2+"=?", new String[] {userObj.getUserName()});
                if(result==-1){
                    return false;
                }
                else{
                    return  true;
                }
            }
            else{
                return false;
            }
        }

        public Cursor viewData(){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor =db.rawQuery("Select * from "+TABLE_NAME,null);
            return cursor;
        }
}

