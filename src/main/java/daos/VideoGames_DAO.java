package daos;

import models.ConnectionFactory;
import models.VideoGames;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VideoGames_DAO implements DAO<VideoGames> {
    Connection connection = ConnectionFactory.getConnection();

    public VideoGames extractGameFromSQL(ResultSet rs) throws SQLException {
        VideoGames games = new VideoGames();

        games.setName(((ResultSet) rs).getString("Name"));
        games.setSKU(((ResultSet) rs).getInt("SKU"));
        games.setPrice(((ResultSet) rs).getFloat("Price"));
        games.setPublisher(((ResultSet) rs).getString("Publisher"));
        games.setReleaseDate(((ResultSet) rs).getString("Release_Date"));

        return games;
    }


    public VideoGames findByID(Integer SKU) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = ((Statement) stmt).executeQuery("SELECT * FROM videogames WHERE SKU=" + SKU);

            if (((ResultSet) rs).next()) {
                return extractGameFromSQL(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Set findAll() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM videogames");

            Set gamesSet = new HashSet();

            while (rs.next()) {
                VideoGames games = extractGameFromSQL(rs);
                gamesSet.add(games);
            }

            return gamesSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Boolean update(VideoGames games) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET name=?, price=?, publisher=? release_date=?, SKU=?");
            if (preparedStatement(games, ps)) return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public Boolean create(VideoGames games) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?)");
            if (preparedStatement(games, ps)) return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(int SKU) {
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM videogames WHERE SKU=" + SKU);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    private boolean preparedStatement(VideoGames games, PreparedStatement ps) throws SQLException {
        ps.setString(1, games.getName());
        ps.setFloat(2, games.getPrice());
        ps.setString(3, games.getPublisher());
        ps.setString(4, games.getReleaseDate());
        ps.setInt(5, games.getSKU());
        int i = ps.executeUpdate();

        if (i == 1) {
            return true;
        }
        return false;
    }
}
