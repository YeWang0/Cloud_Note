package com.ud.cloudnote.dao;

import java.util.List;
import java.util.Map;

import com.ud.cloudnote.entity.Favorite;

public interface FavDao {
public void saveFav(Favorite favorite);

public List<Favorite> getFavorite(String userId);

public Favorite favPreview(String favId);

public int cancelFav(String favId);

public boolean checkFav(Map<String,String> param);
}
