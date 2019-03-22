package daos;

import models.ConnectionFactory;
import models.VideoGames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoGames_DTO implements DTO {
    Connection connection = ConnectionFactory.getConnection();

    public int getID(VideoGames games) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SKU FROM videogames WHERE SKU=" + games.getSKU());
            if(rs.next())
            {
                VideoGames game = new VideoGames();
                game.setSKU( rs.getInt("SKU") );
                game.setName( rs.getString("Name") );
                game.setReleaseDate( rs.getString("Release_Date") );
                game.setPublisher( rs.getString("Publisher") );
                game.setPrice(rs.getFloat("Price"));
                return game.getSKU();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
