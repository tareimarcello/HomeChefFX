package logic.dao.query;

import logic.beans.SearchBean;

public class ChefQuery {


    public String selectChefQuery(long id){
        return String.format("SELECT * FROM chef JOIN user ON (chef.iduser=user.iduser) WHERE chef.iduser=%d", id);
    }

    public String updateChefQuery(long id, String restaurant,String bestDish, String citta){
        return String.format("UPDATE chef SET restaurant = '%s',bestdish = '%s', city = '%s' WHERE iduser=%d" ,restaurant,bestDish,citta, id);
    }



    public String getChefBYParamQuery(SearchBean searchParam){

        StringBuilder query = new StringBuilder();
        boolean first = true;
        String condKey = "WHERE";
        String condition = "";
        query.append ("SELECT * FROM chef JOIN user ON (chef.iduser=user.iduser)");
        if (searchParam.getChefName()!= null && !searchParam.getChefName().equals("")){
            condition = "surname = '"+searchParam.getChefName()+"'";

            query.append(" ").append(condKey).append(" ").append(condition);

            first = false;
        }

        if (searchParam.getChefCity()!= null && !searchParam.getChefCity().equals("")){
            if (!first) condKey = "AND";
            else
                first = false;

            condition = "city = '"+searchParam.getChefCity()+"'";
            query.append(" ").append(condKey).append(" ").append(condition);


        }

        if (searchParam.getChefBestDish()!= null && !searchParam.getChefBestDish().equals("")){
            if (!first) condKey = "AND";

            condition = "bestdish = '"+searchParam.getChefBestDish()+"'";
            query.append(" ").append(condKey).append(" ").append(condition);


        }
        return query.toString();
    }
}
