package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import model.bean.Item;

public class ItemDAO extends ConnectionDAO implements QueryItemInterface {

	public ItemDAO() {
		super();
	}
	
	@Override
	public void addItem(Item item) {
		try {
			final String query ="INSERT into item(id,name,category,price,vote,description,duration,startDate) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = createConnection().prepareStatement(
					query);
//			ps.setString(1, user.getUsername());
//			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();			
	
			closeConnection();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("SQLException:" + e.getSQLState());
			System.out.println("Insert Failed -> duplicated Key!!");
		}
		
	}

	@Override
	public void removeItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSONObject getAllItems() {
		JSONObject json = new JSONObject();
		JSONArray items = new JSONArray();
		try {
			final String query = "select * from my_db.item order by (my_db.item.name)desc;";
			final PreparedStatement ps = createConnection().prepareStatement(
					query);
			final ResultSet mResultSet = ps.executeQuery();
			while (mResultSet.next()) {
				JSONObject item = new JSONObject();
				item.put("id", mResultSet.getString("id"));
				item.put("name", mResultSet.getString("type"));
				item.put("category", mResultSet.getString("point"));
				item.put("price", mResultSet.getString("vote"));
				item.put("vote", mResultSet.getString("path"));
				item.put("description", mResultSet.getString("description"));
				item.put("duration", mResultSet.getString("day_of_week"));
				
				items.put(item);
			}
			json.put("items", items);
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;
	}

	@Override
	public JSONObject getItem(int id) {
		
		JSONObject json = new JSONObject();
		try {
		final String query = "select * from my_db.item as i where i.id=?;";
		final PreparedStatement ps = createConnection().prepareStatement(
				query);
		ps.setString(1, "id");
		ResultSet mResultSet = ps.executeQuery();
		json.put("id", mResultSet.getString("id"));
		json.put("name", mResultSet.getString("type"));
		json.put("category", mResultSet.getString("point"));
		json.put("price", mResultSet.getString("vote"));
		json.put("vote", mResultSet.getString("path"));
		json.put("description", mResultSet.getString("description"));
		json.put("duration", mResultSet.getString("day_of_week"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
		
	}

	@Override
	public void modifyItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLastItems() {
		// TODO Auto-generated method stub
		
	}

	
	
}
