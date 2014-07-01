package biz.apollogames.eve.api;

import biz.apollogames.eve.api.character.*;

public class CharApiHelper extends ApiHelper {

    private long characterID;

    public CharApiHelper(long keyID, String vCode) {
        super(keyID, vCode);
    }

    public CharApiHelper(long keyID, String vCode, long characterID) {
        super(keyID, vCode);
        this.characterID = characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public AccountBalance getAccountBalance() {
        return api().getAccountBalance(keyID, vCode, characterID);
    }

    public AssetList getAssetList() {
        return api().getAssetList(keyID, vCode, characterID);
    }

    public CharacterSheet getCharacterSheet() {
        return api().getCharacterSheet(keyID, vCode, characterID);
    }

    public Contracts getContracts() {
        return api().getContracts(keyID, vCode, characterID);
    }

    public Contracts.Items getContractItems(long contractID) {
        return api().getContractItems(keyID, vCode, characterID, contractID);
    }

    public IndustryJobs getIndustryJobs() {
        return api().getIndustryJobs(keyID, vCode, characterID);
    }

    public KillLog getKillLog() {
        return api().getKillLog(keyID, vCode, characterID, 10);
    }

    public Mail getMail() {
        return api().getMail(keyID, vCode, characterID);
    }

    public Mail.Bodies getMailBodies(Long... ids) {
        return api().getMailBodies(keyID, vCode, characterID, ids);
    }

    public Planetary getPlanetary() {
        return api().getPlanetary(keyID, vCode, characterID);
    }

    public Planetary.Pins getPlanetaryPins(long planetID) {
        return api().getPlanetaryPins(keyID, vCode, characterID, planetID);
    }

    public Planetary.Routes getPlanetaryRoutes(long planetID) {
        return api().getPlanetaryRoutes(keyID, vCode, characterID, planetID);
    }

    public Planetary.Links getPlanetaryLinks(long planetID) {
        return api().getPlanetaryLinks(keyID, vCode, characterID, planetID);
    }

    public SkillQueue getSkillQueue() {
        return api().getSkillQueue(keyID, vCode, characterID);
    }

    public SkillQueue.Training getSkillInTraining() {
        return api().getSkillInTraining(keyID, vCode, characterID);
    }

}
