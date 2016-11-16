package administrator.data;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController extends SQLiteOpenHelper {

	public DBController(Context applicationcontext) {
		super(applicationcontext, "androidsqlite.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		String query;
		query = "CREATE TABLE administrator ( username TEXT PRIMARY KEY, password TEXT)";
		database.execSQL(query);

	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
		String query;
		query = "DROP TABLE IF EXISTS administrator";
		database.execSQL(query);
		onCreate(database);
	}

	public void insertdb(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", queryValues.get("username"));
		values.put("password", queryValues.get("password"));
		database.insert("administrator", null, values);
		database.close();
	}

	public int updatepass(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", queryValues.get("username"));
		values.put("password", queryValues.get("password"));
		return database.update("administrator", values, "username" + " = ?",
				new String[] { queryValues.get("username") });

	}

	public HashMap<String, String> getuser(String id) {
		HashMap<String, String> wordList = new HashMap<String, String>();
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT password FROM administrator where username='" + id + "'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {

				wordList.put("password", cursor.getString(0));

			} while (cursor.moveToNext());
		}
		return wordList;
	}
}
