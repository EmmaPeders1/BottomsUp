package com.mygdx.bottomsup;

import java.util.List;

public class DesktopInterfaceClass implements FireBaseInterface{
    @Override
    public String hostLobby(String name, String blockTower) {
        return null;
    }

    @Override
    public String joinLobby(String code, String name, String blockTower) {
        return null;
    }


    @Override
    public void updateBlockTower(String code, String playerId, String blockTower) {

    }

    @Override
    public List<List<Integer>> updateOthers(String code, String playerId) {
        return null;
    }

    @Override
    public List<String> getResults(String code) {
        return null;
    }

    @Override
    public void setResult(String code, String playerId, String value) {

    }

    @Override
    public void hostStartGame(String code) {

    }

    @Override
    public List<String> updatePlayerList(String code) {
        return null;
    }
}
