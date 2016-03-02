import com.example.vin_s.cargo.model.Post;
import com.example.vin_s.cargo.model.Person;

import java.util.*;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
 
    // Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "CargoDB";
 
    // Table Names
    private static final String TABLE_POST = "posts";
    private static final String TABLE_PEOPLE = "people";

    //Post Column names
    private static final String KEY_ORIGIN = "Origin";
    private static final String KEY_DEST = "Destination";
    private static final String KEY_DATE = "Date";
    private static final String KEY_OWNERID = "OwnerID";

    //People Column names
    private static final String KEY_NAME = "Name";
    private static final String KEY_CINFO = "cInfo";
    private static final String KEY_TEXT = "Text";
    
    //Shared Column names
    private static final String KEY_ID = "ID";    

    //Create table statements
    private static final CREATE_TABLE_POST = "CREATE TABLE "
            + TABLE_POST + "(" + KEY_POSTID + " INTEGER PRIMARY KEY," + KEY_ORIGIN
            + " TEXT," + KEY_DEST + " TEXT," + KEY_DATE
            + " TEXT" + ")";
    
    private static final CREATE_TABLE_PEOPLE = "CREATE TABLE "
            + TABLE_PEOPLE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_CINFO + " TEXT," + KEY_TEST
            + " TEXT" + ")";
    
 
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_POST);
        db.execSQL(CREATE_TABLE_PEOPLE);
        db.execSQL(CREATE_TABLE_PPL_POST);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
 
        // create new tables
        onCreate(db);
    }
    
    public long createPost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, post.getPostid());
        values.put(KEY_OWNERID, post.getOwner());
        values.put(KEY_ORIGIN, post.getOrigin());
        values.put(KEY_DEST, post.getDest());
        values.put(KEY_DATE, post.getDate());
 
        // insert row
        long todo_id = db.insert(TABLE_TODO, null, values);
 
        return todo_id;
    }
    
    
    //get one post
    public Post getPost(long post_id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        String selectQuery = "SELECT  * FROM " + TABLE_POSTS + " WHERE "
                + KEY_ID + " = " + post_id;
 
        Log.e(LOG, selectQuery);
 
        Cursor c = db.rawQuery(selectQuery, null);
 
        if (c != null)
            c.moveToFirst();
 
        Post p = new Post();
        p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        p.setOwner(c.getInt(c.getColumnIndex(KEY_OWNERID)));
        p.setOrigin((c.getString(c.getColumnIndex(KEY_ORIGIN))));
        p.setDest(c.getString(c.getColumnIndex(KEY_DEST)));
        p.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
 
        return td;
    }
    
    //get all posts
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        String selectQuery = "SELECT  * FROM " + TABLE_POST;
     
        Log.e(LOG, selectQuery);
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Post p = new Post();
                p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                p.setOwner(c.getInt(c.getColumnIndex(KEY_OWNERID)));
                p.setOrigin((c.getString(c.getColumnIndex(KEY_ORIGIN))));
                p.setDest(c.getString(c.getColumnIndex(KEY_DEST)));
                p.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
     
                // adding to todo list
                posts.add(p);
            } while (c.moveToNext());
        }
     
        return posts;
    }
    
    //get all posts by Origin 
    public List<Post> getAllPostsO (String org) {
        List<Post> posts = new ArrayList<Post>();
     
        String selectQuery = "SELECT  * FROM " + TABLE_POST + " WHERE "
                + KEY_ORIGIN + " = '" + org +"'";
     
        Log.e(LOG, selectQuery);
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Post p = new Post();
                p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                p.setOwner(c.getInt(c.getColumnIndex(KEY_OWNERID)));
                p.setOrigin((c.getString(c.getColumnIndex(KEY_ORIGIN))));
                p.setDest(c.getString(c.getColumnIndex(KEY_DEST)));
                p.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
     
                // adding to todo list
                posts.add(p);
            } while (c.moveToNext());
        }
     
        return posts;
    }
    
    public List<Post> getAllPostsD (String des) {
        List<Post> posts = new ArrayList<Post>();
     
        String selectQuery = "SELECT  * FROM " + TABLE_POST + " WHERE "
                + KEY_DEST + " = '" + des +"'";
     
        Log.e(LOG, selectQuery);
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Post p = new Post();
                p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                p.setOwner(c.getInt(c.getColumnIndex(KEY_OWNERID)));
                p.setOrigin((c.getString(c.getColumnIndex(KEY_ORIGIN))));
                p.setDest(c.getString(c.getColumnIndex(KEY_DEST)));
                p.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
     
                // adding to todo list
                posts.add(p);
            } while (c.moveToNext());
        }
     
        return posts;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
   //helpful DB tutorial http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
} 