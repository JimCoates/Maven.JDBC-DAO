package models;

import daos.VideoGames_DAO;

import java.util.List;
import java.util.Set;

public class Application {


    public static void main(String[] args) {
        Set resultSet;
        VideoGames_DAO dao = new VideoGames_DAO();
        VideoGames game1 = new VideoGames("Doom", 20.0F, "Publisher ABC", "1995-03-09", 234434567);
        VideoGames game2 = new VideoGames("Uncharted Trilogy", 30.0F, "Treyarch", "2004-09-012", 345678484);
        VideoGames game3 = new VideoGames("Call of Duty", 15.0F, "Activision", "2009-09-012", 345338484);

        dao.create(game1);
        dao.create(game2);
        dao.create(game3);

        resultSet = dao.findAll();
        dao.update(game2);

        dao.delete(347236475);

        System.out.println(dao.findByID(347236475));

    }
}
